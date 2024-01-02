package com.jonathanschram.vttconverter.lib.vtt.parsing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import com.jonathanschram.vttconverter.lib.vtt.VttObject;
import com.jonathanschram.vttconverter.lib.vtt.css.RawCssBlock;
import com.jonathanschram.vttconverter.lib.vtt.cue.Cue;
import com.jonathanschram.vttconverter.lib.vtt.cue.TimeCode;
import com.jonathanschram.vttconverter.lib.vtt.parsing.RawCue.Builder;
import com.jonathanschram.vttconverter.lib.vtt.region.Location;
import com.jonathanschram.vttconverter.lib.vtt.region.Region;

/***
 * A WebVTT parser based on the official W3C VTT specification
 * (https://www.w3.org/TR/webvtt1).
 * 
 * The algorithm deviates slightly from the official algorithm (mainly to avoid
 * needing to manually convert bytes to UTF-8), but it should produce exactly
 * the same output.
 */
public class VttParser {

	private static final String VTT_MAGIC_HEADER = "WEBVTT";

	private InputStream input;
	/**
	 * All lines read from the input stream, read to a list to make it easier to
	 * parse.
	 */
	private List<String> inputLines;
	/**
	 * Current line being scanned. Is an instance variable because parsing needs to
	 * maintain state in order to return to previous lines.
	 */
	private int currentLine = 0;

	/***
	 * Whether a cue has been seen while parsing. All cues must appear after style
	 * and region definitions.
	 */
	private boolean seenCue = false;

	private boolean inputParsed = false;

	private List<RawCue> parsedCues = new ArrayList<>();
	private List<Region> parsedRegions = new ArrayList<>();
	private List<RawCssBlock> parsedStyleBlocks = new ArrayList<>();

	public VttParser(InputStream input) {
		this.input = input;

		VttObject.Builder builder = new VttObject.Builder();
	}

	public VttObject parseFromStream() {
		if (inputParsed) {
			throw new IllegalStateException("Input stream has already been parsed");
		}
		inputParsed = true;

		// A 'standard' VTT parser would read byte-by-byte, but it would have to handle
		// UTF-8 conversion and correctly handle carriage return / line feed.
		// Java's input stream reader and buffered reader handle both of these for us.
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8))) {
			inputLines = reader.lines().toList();

			if (inputLines.size() == 0) {
				// There are no lines in input, this is an invalid file.
				return null;
			}

			if (!validateSignature(inputLines.get(0))) {
				// Signature doesn't pass, it is an invalid file.
				return null;
			}

			currentLine = 1;

			/*
			 * Skip header metadata immediately following the magic WEBVTT signature. A
			 * blank line signals the end of the header.
			 * 
			 * Old versions of the VTT spec allowed regions to be specified with a metadata
			 * header but this is no longer in the spec.
			 * 
			 * TODO: Maybe allow parsing region metadata headers.
			 */
			skipNonBlankLines();

			// Advance to the first block.
			skipBlankLines();

			while (currentLine < inputLines.size()) {
				// TODO: Parse a block, then skip blank lines.
				// TODO: Set inVttBody correctly
				parseBlock(true);
				skipBlankLines();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Input lines aren't needed after parsing.
		inputLines = null;

		return null;
	}

	private boolean validateSignature(String line) {
		if (line == null) {
			return false;
		}

		if (line.length() < 6) {
			return false;
		}

		// TODO: Handle byte order mark.

		if (line.startsWith(VTT_MAGIC_HEADER)) {
			if (line.length() == 6) {
				// VTT header contains the magic string and nothing else.
				return true;
			}
			// There is text following the magic string - it must begin with a space or a
			// tab.
			char headerSuffix = line.charAt(6);
			if (headerSuffix == ' ' || headerSuffix == '\u0009') {
				// We don't care what the remainder of the line is.
				return true;
			}
		}

		return false;
	}

	/***
	 * Skips blank lines in input, sets currentLine to the first line that is not
	 * blank, or to the line after the last line in the input.
	 */
	private void skipBlankLines() {
		while (currentLine < inputLines.size() && "".equals(inputLines.get(currentLine))) {
			currentLine++;
		}
	}

	private void skipNonBlankLines() {
		while (currentLine < inputLines.size() && !"".equals(inputLines.get(currentLine))) {
			currentLine++;
		}
	}

	/***
	 * Parses a block section of a VTT file.
	 * 
	 * A block is either a REGION definition, STYLE definition, or a cue.
	 * 
	 * Based on the W3C's algorithm under the "Collect a WebVTT block" heading in
	 * the WebVTT spec (https://www.w3.org/TR/webvtt1/).
	 * 
	 * @param inHeader
	 * @throws Exception
	 */
	private void parseBlock(boolean inVttBody) throws Exception {
		if (currentLine + 1 >= inputLines.size()) {
			// No data can be parsed from the file.
			// A comment is the only thing that can be on a single line and those are
			// ignored.
			currentLine = inputLines.size();
			return;
		}

		String line = inputLines.get(currentLine);
		String nextLine = inputLines.get(currentLine + 1);

		if (line.contains("-->")) {
			parseCue(null, currentLine);
		} else if (nextLine.contains("-->")) {
			parseCue(line, currentLine + 1);
		} else if (!seenCue && isPrefixFollowedByWhitespace(line, "STYLE")) {
			// Check for style block after checking for timing arrow, because a cue could
			// theoretically have the identifier "STYLE".
			parseStyle();
		} else if (!seenCue && isPrefixFollowedByWhitespace(line, "REGION")) {
			// Same as with STYLE, a cue may be named "REGION" so this must be checked after
			// cues.
			parseRegion();
		} else if (line.startsWith("NOTE")) {
			parseComment();
		}
		// If none of the above conditions matched, there is a malformed file and no
		// action should be taken. Any blank lines should have been consumed before
		// calling this method.
	}

	/***
	 * Returns whether the string 's' starts with the given prefix and is followed
	 * by ASCII whitespace.
	 * 
	 * @param s
	 * @param prefix
	 * @return
	 */
	private boolean isPrefixFollowedByWhitespace(String s, String prefix) {
		return s.startsWith(prefix) && Utils.endsWithWhitespace(s, prefix.length());
	}

	/***
	 * Moves CurrentLine past a WebVTT comment block.
	 */
	private void parseComment() {
		// Comment blocks begin with NOTE and continue until a blank line. As we don't
		// need to parse comments, we can just skip until the next blank line.
		skipNonBlankLines();
	}

	/***
	 * Parses a WebVTT Region block.
	 * 
	 * @throws Exception
	 */
	private void parseRegion() throws Exception {
		System.out.println("Region definition found.");
		// Advance past REGION tag.
		currentLine++;

		List<String> settingEntries = parseSpaceSeparatedValues();
		Map<String, String> settingsMap = Utils.parseSettingsList(settingEntries);

		Region.Builder builder = new Region.Builder();

		for (Entry<String, String> entry : settingsMap.entrySet()) {
			String value = entry.getValue();
			switch (entry.getKey()) {
			case "id":
				builder.setIdentifier(value);
				break;
			case "width":
				Optional<Double> width = Utils.parsePercentage(value);
				width.ifPresent((val) -> builder.setWidthPercent(val));
				break;
			case "lines":
				if (value.chars().allMatch(Character::isDigit)) {
					builder.setLineCount(Integer.parseInt(value));
				}
				break;
			case "regionanchor":
				if (value.contains(",")) {
					parseLocation(value).ifPresent((anchor) -> builder.setRegionAnchor(anchor));
				}
				break;
			case "viewportanchor":
				if (value.contains(",")) {
					parseLocation(value).ifPresent((anchor) -> builder.setViewportAnchor(anchor));
				}
				break;
			case "scroll":
				builder.setScroll("up".equals(value));
				break;
			}
		}
		parsedRegions.add(builder.build());
	}

	private Optional<Location> parseLocation(String value) throws Exception {
		String[] anchorPoints = value.split(",");
		if (anchorPoints.length == 2) {
			Optional<Double> anchorX = Utils.parsePercentage(anchorPoints[0]);
			Optional<Double> anchorY = Utils.parsePercentage(anchorPoints[1]);
			if (anchorX.isPresent() && anchorY.isPresent()) {
				return Optional.of(new Location(anchorX.get(), anchorY.get()));				
			}
			return Optional.empty();
		} else {
			throw new Exception("Expected two percentage values, received " + value);
		}
	}

	/***
	 * Parses a list of values from {@link this#inputLines} starting at
	 * {@link this#currentLine}, separated by spaces, tabs, or line breaks.
	 * 
	 * Advances {@link this#currentLine} to the line after the end of the list.
	 * 
	 * @return
	 */
	private List<String> parseSpaceSeparatedValues() {
		List<String> keyValuePairs = new ArrayList<>();
		while (currentLine < inputLines.size() && !"".equals(inputLines.get(currentLine))) {
			String line = inputLines.get(currentLine);
			String[] attributes = Utils.splitOnTabsAndSpaces(line);
			for (String item : attributes) {
				keyValuePairs.add(item);
			}
			currentLine++;
		}
		return keyValuePairs;
	}

	/***
	 * Parses a WebVTT Style block containing CSS rules.
	 */
	private void parseStyle() {
		System.out.println("Style definition found");
		// Advance past STYLE definition.
		currentLine++;

		StringBuilder blockBuilder = new StringBuilder();
		while (currentLine < inputLines.size() && !"".equals(inputLines.get(currentLine))) {
			if (!blockBuilder.isEmpty()) {
				blockBuilder.append('\n');
			}
			blockBuilder.append(inputLines.get(currentLine));
			currentLine++;
		}

		parsedStyleBlocks.add(new RawCssBlock(blockBuilder.toString()));
	}

	/***
	 * Parses a WebVTT cue block.
	 * 
	 * @param identifier       The identifier name to give the cue. Null if there is
	 *                         no identifier.
	 * @param timingLineNumber The index into {@link this#inputLines} containing the
	 *                         timing line for this cue. This is guaranteed to be a
	 *                         valid index.
	 */
	private void parseCue(String identifier, int timingLineNumber) {
		if (identifier != null) {
			System.out.println("Cue found with identifier: " + identifier);
		} else {
			System.out.println("Cue found, no identifier");
		}

		StringBuilder cueText = new StringBuilder();
		int i = timingLineNumber + 1;
		while (i < inputLines.size()) {
			String line = inputLines.get(i);
			if ("".equals(line) || line.contains("-->")) {
				break;
			}
			if (!cueText.isEmpty()) {
				cueText.append("\n");
			}
			cueText.append(line);
			i++;
		}

		System.out.println(cueText);

		String timingLine = inputLines.get(timingLineNumber);
		TimingLineParser p = new TimingLineParser(timingLine);
		try {
			p.parse();
			RawCue.Builder cueBuilder = new Builder(p.getStartTime(), p.getEndTime());
			cueBuilder.setRawSettings(p.getSettings()).setIdentifier(identifier).setRawText(cueText.toString());

			RawCue cue = cueBuilder.build();
			parsedCues.add(cue);

		} catch (Exception e) {
			// TODO: Possibly fail parsing the file. Probably indicates a major problem with
			// the file.
			System.out.println("Error parsing: " + e.toString());
		}

		seenCue = true;
		this.currentLine = i;
	}

}
