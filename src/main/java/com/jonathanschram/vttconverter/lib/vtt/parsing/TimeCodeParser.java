package com.jonathanschram.vttconverter.lib.vtt.parsing;

import java.util.ArrayList;
import java.util.List;

import com.jonathanschram.vttconverter.lib.vtt.cue.TimeCode;

public class TimeCodeParser {

    private final String input;

    private int currentPosition;

    public TimeCodeParser(String input) {
        this(input, 0);
    }

    public TimeCodeParser(String input, int currentPosition) {
        this.input = input;
        this.currentPosition = currentPosition;
    }

    /***
     * Gets the current position of the parser in the original string. Useful to
     * determine where the time code ends after it was parsed.
     * 
     * @return
     */
    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int newPosition) {
        // TODO: Instead of setting current position before parsing, just set the
        // current position when calling parseTimestamp().
        if (newPosition < 0 || newPosition >= input.length()) {
            throw new IllegalArgumentException("New position must be between 0 and length of input string");
        }
        this.currentPosition = newPosition;
    }

    public TimeCode parseTimestamp() throws TimeCodeParseException {
        List<Integer> values = new ArrayList<>();

        boolean firstValueHours = false;
        String firstTime = "";
        while (currentPosition < input.length() && Utils.isAsciiDigit(input.charAt(currentPosition))) {
            firstTime += input.charAt(currentPosition);
            currentPosition++;
        }
        values.add(Integer.parseInt(firstTime));

        if (values.get(0) > 59) {
            firstValueHours = true;
        }

        assertColon();
        values.add(parseNumberWithLength(2));

        assertNotEndOfLine();
        if (firstValueHours || input.charAt(currentPosition) == ':') {
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

        if (input.charAt(currentPosition) != '.') {
            throw new TimeCodeParseException("Time code in incorrect format. Expected a period.");
        }

        currentPosition++;
        values.add(parseNumberWithLength(3));

        // Guaranteed to have 4 entries in the list. Validate minutes and seconds.
        if (values.get(1) > 59 || values.get(2) > 59) {
            throw new TimeCodeParseException("Time code in incorrect format. Minutes and seconds cannot be greater than 59.");
        }

        return new TimeCode(values.get(0), values.get(1), values.get(2), values.get(3));
    }

    /***
     * Verifies that the character at the current position in line is a colon, and
     * advances current position to the next character.
     * 
     * @throws Exception
     */
    private void assertColon() throws TimeCodeParseException {
        if (input.charAt(currentPosition) != ':') {
            throw new TimeCodeParseException("Time code in incorrect format. Expected colon.");
        }
        currentPosition++;
    }

    private void assertNotEndOfLine() throws TimeCodeParseException {
        if (currentPosition >= input.length()) {
            throw new TimeCodeParseException("Unexpected end of time code.");
        }
    }

    private int parseNumberWithLength(int length) throws TimeCodeParseException {
        String buffer = "";
        while (currentPosition < input.length() && Utils.isAsciiDigit(input.charAt(currentPosition))) {
            buffer += input.charAt(currentPosition);
            currentPosition++;
        }
        if (buffer.length() != length) {
            // TODO: Throw a more appropriate exception, might want to re-throw any Integer
            // parse exceptions as this as well.
            throw new TimeCodeParseException("Time code in incorrect format. Expected an integer with " + length
                    + " digits. Received: " + buffer);
        }

        return Integer.parseInt(buffer);
    }
}
