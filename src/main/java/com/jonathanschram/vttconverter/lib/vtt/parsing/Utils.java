package com.jonathanschram.vttconverter.lib.vtt.parsing;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class Utils {

	private static final Pattern PERCENT_PATTERN = Pattern.compile("\\d+(?:\\.\\d+)?%");
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
	static boolean endsWithWhitespace(String line, int start) {
		for (int i = start; i < line.length(); i++) {
			if (!ASCII_WHITESPACE.contains(line.charAt(i))) {
				return false;
			}
		}

		return true;
	}

	/***
	 * Finds the next index in the string after any ASCII whitespace starting at the
	 * given index.
	 * 
	 * @param line
	 * @param start
	 * @return
	 */
	static int getWhitespaceEnd(String line, int start) {
		int i = start;
		while (i < line.length() && ASCII_WHITESPACE.contains(line.charAt(i))) {
			i++;
		}
		return i;
	}

	static String[] splitOnTabsAndSpaces(String line) {
		return line.split("[ \\t]+");
	}

	static Map<String, String> parseSettingsList(Iterable<String> settings) {
		Map<String, String> result = new HashMap<>();
		for (String setting : settings) {
			int colonIndex = setting.indexOf(':');
			// Only process setting if the colon isn't the first or last character
			if (colonIndex > 0 && colonIndex < setting.length()) {
				String propertyName = setting.substring(0, colonIndex);
				String value = setting.substring(colonIndex + 1);
				result.put(propertyName, value);
			}
		}
		return result;
	}

	static Map<String, String> parseSettingsList(String[] settings) {
		return parseSettingsList(Arrays.asList(settings));
	}

	static double parsePercentage(String value) throws Exception {
		if (!PERCENT_PATTERN.matcher(value).matches()) {
			throw new Exception("Expected percent value, received " + value);
		}

		// Strip percent sign from end.
		String numberPortion = value.substring(0, value.length() - 1);

		return Double.parseDouble(numberPortion);
	}

}
