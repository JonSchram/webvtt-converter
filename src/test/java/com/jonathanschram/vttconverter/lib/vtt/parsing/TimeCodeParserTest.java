package com.jonathanschram.vttconverter.lib.vtt.parsing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.jonathanschram.vttconverter.lib.vtt.cue.TimeCode;

class TimeCodeParserTest {

    @Test
    void testSetCurrentPosition_Invalid() {
        TimeCodeParser parser = new TimeCodeParser("00:00:00.000");
        assertThrows(IllegalArgumentException.class, () -> parser.setCurrentPosition(12));
    }

    @Test
    void testParseTimestamp_SimpleTime() throws Exception {
        TimeCodeParser parser = new TimeCodeParser("00:01.000");

        TimeCode result = parser.parseTimestamp();
        assertEquals(new TimeCode(0, 0, 1, 0), result);
        assertEquals(9, parser.getCurrentPosition());
    }

    @Test
    void testParseTimestamp_WhitespaceFollowingTime() throws Exception {
        TimeCodeParser parser = new TimeCodeParser("00:01.000     ");

        TimeCode result = parser.parseTimestamp();
        assertEquals(new TimeCode(0, 0, 1, 0), result);
        assertEquals(9, parser.getCurrentPosition());
    }

    @Test
    void testParseTimestamp_WithHours() throws Exception {
        TimeCodeParser parser = new TimeCodeParser("03:02:01.020");

        TimeCode result = parser.parseTimestamp();
        assertEquals(new TimeCode(3, 2, 1, 20), result);
        assertEquals(12, parser.getCurrentPosition());
    }

    @Test
    void testParseTimestamp_WithStartPosition() throws Exception {
        TimeCodeParser parser = new TimeCodeParser("skip this 9:59:59.999");

        parser.setCurrentPosition(10);
        TimeCode result = parser.parseTimestamp();
        assertEquals(new TimeCode(9, 59, 59, 999), result);
        assertEquals(21, parser.getCurrentPosition());
    }

    @Test
    void testParseTimestamp_ManyHours() throws Exception {
        TimeCodeParser parser = new TimeCodeParser("100:00:00.000");

        TimeCode result = parser.parseTimestamp();
        assertEquals(new TimeCode(100, 0, 0, 0), result);
        assertEquals(13, parser.getCurrentPosition());
    }

    @Test
    void testParseTimestamp_InvalidFormat() {
        TimeCodeParser parser = new TimeCodeParser("0:00:00:00:00:00");
        assertThrows(TimeCodeParseException.class, () -> parser.parseTimestamp());
    }

    @Test
    void testParseTimestamp_ContainsLetters() {
        TimeCodeParser parser = new TimeCodeParser("0abc:00:00.000");
        assertThrows(TimeCodeParseException.class, () -> parser.parseTimestamp());
    }

    @Test
    void testParseTimestamp_NotEnoughDigits() {
        TimeCodeParser parser = new TimeCodeParser("0:0:00.000");
        assertThrows(TimeCodeParseException.class, () -> parser.parseTimestamp());
    }

    @Test
    void testParseTimestamp_TooManyDigits() {
        TimeCodeParser parser = new TimeCodeParser("0:000:00.000");
        assertThrows(TimeCodeParseException.class, () -> parser.parseTimestamp());
    }

    @Test
    void testParseTimestamp_TooManyMinutes() {
        TimeCodeParser parser = new TimeCodeParser("00:70.000");
        assertThrows(TimeCodeParseException.class, () -> parser.parseTimestamp());
    }

}
