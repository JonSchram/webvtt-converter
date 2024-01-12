package com.jonathanschram.vttconverter.lib.vtt.parsing;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Pattern;

/***
 * Common utilities for parsing VTT files. Written to conform to ASCII
 * definitions of characters (ASCII digits, whitespace, etc.).
 */
public class Utils {

    private static final Pattern ASCII_DIGIT_PATTERN = Pattern.compile("\\d");
    private static final Pattern PERCENT_PATTERN = Pattern.compile("\\d+(?:\\.\\d+)?%");
    private static final Set<Character> ASCII_WHITESPACE;

    static {
        Set<Character> set = new HashSet<>();
        set.add(' ');
        set.add('\t');
        // Both carriage return and line feed.
        set.add('\r');
        set.add('\n');
        // Form feed.
        set.add('\f');
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
    public static boolean endsWithWhitespace(String line, int start) {
        for (int i = start; i < line.length(); i++) {
            if (!ASCII_WHITESPACE.contains(line.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public static String stripWhitespace(String input) {
        int startIndex = findFirstNonWhitespace(input);
        int endIndex = findLastNonWhitespace(input);

        if (startIndex >= input.length() || endIndex < 0) {
            // All whitespace.
            return "";
        }

        // Add one to end index so the range includes the end character.
        // End index will never be greater than input.length - 1, so this is guaranteed
        // to be safe.
        return input.substring(startIndex, endIndex + 1);
    }

    private static int findFirstNonWhitespace(String input) {
        int i = 0;
        while (i < input.length() && ASCII_WHITESPACE.contains(input.charAt(i))) {
            i++;
        }
        return i;
    }

    private static int findLastNonWhitespace(String input) {
        int i = input.length() - 1;
        while (i >= 0 && ASCII_WHITESPACE.contains(input.charAt(i))) {
            i--;
        }
        return i;
    }

    /***
     * Returns a string that is the result of replacing all consecutive ASCII
     * whitespaces with a single space.
     * 
     * @param input
     * @return
     */
    public static String condenseConsecutiveWhitespace(String input) {
        StringBuilder result = new StringBuilder();
        boolean previousWasSpace = false;
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (ASCII_WHITESPACE.contains(currentChar)) {
                if (!previousWasSpace) {
                    result.append(' ');
                    previousWasSpace = true;
                }
            } else {
                previousWasSpace = false;
                result.append(currentChar);
            }
        }
        return result.toString();
    }

    /***
     * Finds the next index in the string after any ASCII whitespace starting at the
     * given index.
     * 
     * @param line
     * @param start
     * @return
     */
    public static int getWhitespaceEnd(String line, int start) {
        int i = start;
        while (i < line.length() && ASCII_WHITESPACE.contains(line.charAt(i))) {
            i++;
        }
        return i;
    }

    public static String[] splitOnTabsAndSpaces(String line) {
        return line.split("[ \\t]+");
    }

    public static Map<String, String> parseSettingsList(Iterable<String> settings) {
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

    public static Map<String, String> parseSettingsList(String[] settings) {
        return parseSettingsList(Arrays.asList(settings));
    }

    public static boolean containsAsciiDigits(String s) {
        return ASCII_DIGIT_PATTERN.matcher(s).find();
    }

    public static boolean isAsciiDigit(char c) {
        return '0' <= c && c <= '9';
    }

    /***
     * Parses a double value represented as a percentage, returning an empty value
     * if the value is not a percent or cannot be parsed as a double.
     * 
     * @param value
     * @return
     * @throws NumberFormatException
     */
    public static Optional<Double> parsePercentage(String value) {
        if (!PERCENT_PATTERN.matcher(value).matches()) {
            return Optional.empty();
        }

        // Strip percent sign from end.
        String numberPortion = value.substring(0, value.length() - 1);

        try {
            return Optional.of(Double.parseDouble(numberPortion));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

}
