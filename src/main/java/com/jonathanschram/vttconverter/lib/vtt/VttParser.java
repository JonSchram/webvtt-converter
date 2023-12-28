package com.jonathanschram.vttconverter.lib.vtt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.jonathanschram.vttconverter.lib.vtt.cue.Cue;

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
	private static final Set<Character> ASCII_WHITESPACE;

	static {
		Set<Character> set = new HashSet<>();
		// Tab.
		set.add('\u0009');
		// Line feed.
		set.add('\n');
		// Form feed.
		set.add('\f');
		// Carriage return.
		set.add('\r');
		// Space.
		set.add(' ');
		ASCII_WHITESPACE = Collections.unmodifiableSet(set);
	}

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
	
	private boolean inputParsed = false;

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
			 */
			skipBlankLines();

			while (currentLine < inputLines.size()) {
				// TODO: Parse a block, then skip blank lines.
				parseBlock();
				skipBlankLines();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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

	/***
	 * Parses a block section of a VTT file.
	 * 
	 * A block is either a REGION definition, STYLE definition, or a cue.
	 * 
	 * Based on the W3C's algorithm under the "Collect a WebVTT block" heading in
	 * the WebVTT spec (https://www.w3.org/TR/webvtt1/).
	 * 
	 * @param inHeader
	 */
	private void parseBlock() {
		int lineCount = 0;

		boolean seenArrow = false;
		// TODO: Really want this to be outside this method, because once a cue is seen,
		// parsing a block should never allow a style or region definition.
		boolean seenCue = false;

		// Buffer is always populated with complete lines, so maybe this isn't needed,
		// can just reference previous line...?
		// But that would be hard with cues occupying a variable number of lines.
		StringBuilder buffer = new StringBuilder();

		// Initialize line for first iteration of loop.
		// TODO: May need to remove the string comparison from while loop to prevent
		// crashing when there are no lines remaining.
		String line = inputLines.get(currentLine);
		while (currentLine < inputLines.size() && !"".equals(line)) {
			lineCount++;
			line = inputLines.get(currentLine);
			if (line.contains("-->")) {
				// An arrow appears once per cue, so it will be safe to construct a new cue
				// (text will be added later).
				if (lineCount == 1 || (lineCount == 2 && !seenArrow)) {
					// Ensure the arrow is either the first line (no cue identifier) or the second
					// line (with cue identifier).
					seenArrow = true;

					// TODO: Populate.
					Cue cue = new Cue();
					System.out.println("Creating cue with identifier: " + buffer);
					
					// Clear buffer.
					buffer.setLength(0);
					seenCue = true;

				}
			} else if ("".equals(line)) {
				// If this condition is on the while loop, this branch might be redundant.
				break;
			} else {
				if (lineCount == 2) {
					if (seenCue == false) {
						String bufferContents = buffer.toString();
						if (isPrefixFollowedByWhitespace(bufferContents, "STYLE")) {
							// Everything after STYLE is a whitespace.
							// TODO: Parse style
						} else if (isPrefixFollowedByWhitespace(bufferContents, "REGION")) {
							// Everything after "REGION" is a whitespace.
							// TODO: Parse region
						}
					}

				}
				if (!buffer.isEmpty()) {
					buffer.append('\n');
				}
				buffer.append(line);
			}

			currentLine++;
		}
		// TODO: If cue isn't null, set cue text to buffer, return cue.
		System.out.println("Cue text: " + buffer);

		// TODO: If style sheet is not null, parse style sheet from buffer and return
		// it.

		// TODO: If region is not null, collect region settings from buffer, parse, and
		// return.

		// Nothing found.
	}
	
	/***
	 * Returns whether the string 's' starts with the given prefix and is followed by ASCII whitespace.
	 * @param s
	 * @param prefix
	 * @return
	 */
	private boolean isPrefixFollowedByWhitespace(String s, String prefix) {
		return s.startsWith(prefix) && endsWithWhitespace(s, prefix.length());
	}

	/***
	 * Returns whether every character in the string after the given start position
	 * is an ASCII whitespace.
	 * 
	 * This checks for tab, line feed, form feed, carriage return, and space
	 * according to the
	 * <a href="https://infra.spec.whatwg.org/#ascii-whitespace">official
	 * specification</a>.
	 * <p>
	 * Java's {@link Character#isWhitespace(char)} checks for a different set of
	 * characters and cannot be used.
	 * 
	 * @param line
	 * @param start
	 * @return
	 */
	private boolean endsWithWhitespace(String line, int start) {
		for (int i = start; i < line.length(); i++) {
			if (!ASCII_WHITESPACE.contains(line.charAt(i))) {
				return false;
			}
		}

		return true;
	}

	/***
	 * Parses a WebVTT Region block.
	 */
	private void parseRegion() {

	}

	/***
	 * Parses (and ignores) a WebVTT comment block.
	 */
	private void parseComment() {

	}

	/***
	 * Parses a WebVTT Style block containing CSS rules.
	 */
	private void parseStyle() {

	}

	/***
	 * Parses a WebVTT cue block.
	 */
	private void parseCue() {

	}
}
