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
        TimeCodeParser timeParser = new TimeCodeParser(line);
        start = timeParser.parseTimestamp();
        currentPosition = Utils.getWhitespaceEnd(line, timeParser.getCurrentPosition());
        assertArrow();
        currentPosition = Utils.getWhitespaceEnd(line, currentPosition);
        
        // Update time code parser with the location of the next time stamp.
        timeParser.setCurrentPosition(currentPosition);
        end = timeParser.parseTimestamp();

        currentPosition = Utils.getWhitespaceEnd(line, currentPosition);
        if (currentPosition < line.length()) {
            cueSettings = Utils.parseSettingsList(Utils.splitOnTabsAndSpaces(line.substring(currentPosition)));
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

}
