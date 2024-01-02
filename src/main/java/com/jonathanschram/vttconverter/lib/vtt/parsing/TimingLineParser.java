package com.jonathanschram.vttconverter.lib.vtt.parsing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jonathanschram.vttconverter.lib.vtt.cue.TimeCode;

/***
 * A parser for the timing & settings line of a VTT file. Based on the algorithm
 * in the <a href="https://www.w3.org/TR/webvtt1/">official spec</a>.
 */
public class TimingLineParser {
	private final String line;

	private TimeCode start;
	private TimeCode end;
	private Map<String, String> cueSettings;

	private int currentPosition = 0;

	public TimingLineParser(String line) {
		this.line = line;
		cueSettings = new HashMap<>();
	}

	public TimeCode getEndTime() {
		return end;
	}

	public TimeCode getStartTime() {
		return start;
	}

	public Map<String, String> getSettings() {
		return Collections.unmodifiableMap(cueSettings);
	}

	public void parse() throws Exception {
		start = parseTimestamp();
		currentPosition = Utils.getWhitespaceEnd(line, currentPosition);
		assertArrow();
		currentPosition = Utils.getWhitespaceEnd(line, currentPosition);
		end = parseTimestamp();

		currentPosition = Utils.getWhitespaceEnd(line, currentPosition);
		if (currentPosition < line.length()) {
			cueSettings = Utils.parseSettingsList(Utils.splitOnTabsAndSpaces(line.substring(currentPosition)));
		}
	}

	/***
	 * Verifies that the character at the current position in line is a colon, and
	 * advances current position to the next character.
	 * 
	 * @throws Exception
	 */
	private void assertColon() throws Exception {
		if (line.charAt(currentPosition) != ':') {
			throw new Exception("Time code in incorrect format. Expected colon.");
		}
		currentPosition++;
	}

	private void assertNotEndOfLine() throws Exception {
		if (currentPosition >= line.length()) {
			throw new Exception("Unexpected end of time code.");
		}
	}

	/***
	 * Asserts that the current position in the line contains the special arrow
	 * symbol (-->). Afterwards, advances the current position to the character
	 * after the arrow.
	 * 
	 * @throws Exception
	 */
	private void assertArrow() throws Exception {
		if (currentPosition + 2 > line.length()) {
			throw new Exception("Invalid format. Expected sequence \"-->\", but line ended.");
		}

		if (!"-->".contentEquals(line.subSequence(currentPosition, currentPosition + 3))) {
			throw new Exception("Invalid format. Expected sequence \"-->\".");
		}
		currentPosition += 3;
	}

	private int parseNumberWithLength(int length) throws Exception {
		String buffer = "";
		while (currentPosition < line.length() && Character.isDigit(line.charAt(currentPosition))) {
			buffer += line.charAt(currentPosition);
			currentPosition++;
		}
		if (buffer.length() != length) {
			// TODO: Throw a more appropriate exception, might want to re-throw any Integer
			// parse exceptions as this as well.
			throw new Exception("Time code in incorrect format. Expected an integer with " + length
					+ " digits. Received: " + buffer);
		}

		return Integer.parseInt(buffer);
	}

	private TimeCode parseTimestamp() throws Exception {
		List<Integer> values = new ArrayList<>();

		boolean firstValueHours = false;
		String firstTime = "";
		while (currentPosition < line.length() && Character.isDigit(line.charAt(currentPosition))) {
			firstTime += line.charAt(currentPosition);
			currentPosition++;
		}
		values.add(Integer.parseInt(firstTime));

		if (values.get(0) > 59) {
			firstValueHours = true;
		}

		assertColon();
		values.add(parseNumberWithLength(2));

		assertNotEndOfLine();
		if (firstValueHours || line.charAt(currentPosition) == ':') {
			currentPosition++;
			values.add(parseNumberWithLength(2));

			// We may be in this block because the next value is a colon, telling us that
			// the following value is seconds (and that the first value was hours).
			firstValueHours = true;
		} else {
			// We know the first value was minutes, so insert the implied 0 at the beginning
			// of the list.
			values.add(0, 0);
		}

		assertNotEndOfLine();

		if (line.charAt(currentPosition) != '.') {
			throw new Exception("Time code in incorrect format. Expected a period.");
		}

		currentPosition++;
		values.add(parseNumberWithLength(3));

		// Guaranteed to have 4 entries in the list. Validate minutes and seconds.
		if (values.get(1) > 59 || values.get(2) > 59) {
			throw new Exception("Time code in incorrect format. Minutes and seconds cannot be greater than 59.");
		}

		return new TimeCode(values.get(0), values.get(1), values.get(2), values.get(3));
	}

}
