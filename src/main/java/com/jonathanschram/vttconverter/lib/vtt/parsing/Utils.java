package com.jonathanschram.vttconverter.lib.vtt.parsing;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Utils {
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
}
