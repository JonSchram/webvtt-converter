package com.jonathanschram.vttconverter.lib.vtt.parsing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;

import com.jonathanschram.vttconverter.lib.vtt.cue.TimeCode;

class TimingLineParserTest {

    @Test
    void testGetStartAndEnd() throws TimingLineParseException {
        String input = "00:00:00.000 --> 00:01.123";

        TimingLineParser parser = new TimingLineParser(input);
        parser.parse();

        assertEquals(new TimeCode(0, 0, 0, 0), parser.getStartTime());
        assertEquals(new TimeCode(0, 0, 1, 123), parser.getEndTime());

        Map<String, String> properties = parser.getSettings();
        assertTrue(properties.isEmpty());
    }

    @Test
    void testGetSingleProperty() throws TimingLineParseException {
        String input = "01:01:01.000 --> 02:01:03.005\tpropertyname:value";

        TimingLineParser parser = new TimingLineParser(input);
        parser.parse();

        assertEquals(new TimeCode(1, 1, 1, 0), parser.getStartTime());
        assertEquals(new TimeCode(2, 1, 3, 5), parser.getEndTime());

        Map<String, String> properties = parser.getSettings();
        assertEquals(1, properties.size());
        assertEquals("value", properties.get("propertyname"));
    }

    @Test
    void testGetMultipleProperties() throws TimingLineParseException {
        String input = "01:01:01.000 --> 02:01:03.005\tpropertyname:value second:secondvalue";

        TimingLineParser parser = new TimingLineParser(input);
        parser.parse();

        assertEquals(new TimeCode(1, 1, 1, 0), parser.getStartTime());
        assertEquals(new TimeCode(2, 1, 3, 5), parser.getEndTime());

        Map<String, String> properties = parser.getSettings();
        assertEquals(2, properties.size());
        assertEquals("value", properties.get("propertyname"));
        assertEquals("secondvalue", properties.get("second"));
    }

    @Test
    void testGetMultipleProperties_MultipleSpaces() throws TimingLineParseException {
        String input = "01:01:01.000 --> 02:01:03.005\tpropertyname:value \t second:secondvalue";

        TimingLineParser parser = new TimingLineParser(input);
        parser.parse();

        assertEquals(new TimeCode(1, 1, 1, 0), parser.getStartTime());
        assertEquals(new TimeCode(2, 1, 3, 5), parser.getEndTime());

        Map<String, String> properties = parser.getSettings();

        assertEquals(2, properties.size());
        assertEquals("value", properties.get("propertyname"));
        assertEquals("secondvalue", properties.get("second"));
    }

    @Test
    void testParse_EndsBeforeArrow() {
        String input = "0:00:00.000 --";

        TimingLineParser parser = new TimingLineParser(input);
        assertThrows(TimingLineParseException.class, () -> parser.parse());
    }

    @Test
    void testParse_InvalidArrow() {
        String input = "0:00:00.000 --- 0:00:01.000";

        TimingLineParser parser = new TimingLineParser(input);
        assertThrows(TimingLineParseException.class, () -> parser.parse());
    }

    @Test
    void testParse_InvalidStartTime() {
        String input = "0:00 --> 0:00:01.000";

        TimingLineParser parser = new TimingLineParser(input);
        assertThrows(TimingLineParseException.class, () -> parser.parse());
    }

    @Test
    void testParse_InvalidEndTime() {
        String input = "0:00:00.000 --> 0:100:99.000";

        TimingLineParser parser = new TimingLineParser(input);
        assertThrows(TimingLineParseException.class, () -> parser.parse());
    }

}
