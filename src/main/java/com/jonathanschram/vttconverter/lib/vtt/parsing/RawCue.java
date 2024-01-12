package com.jonathanschram.vttconverter.lib.vtt.parsing;

import java.util.Collections;
import java.util.Map;

import com.jonathanschram.vttconverter.lib.vtt.cue.TimeCode;

public class RawCue {

    public static class Builder {
        /*** A string uniquely naming this cue. */
        private String identifier = null;

        /*** The start time of the cue. */
        private TimeCode start;
        /*** The end time of the cue. */
        private TimeCode end;

        /*** The text to display in this cue, before parsing HTML tags. */
        private String rawText;

        /*** A map from setting name to setting value, unparsed. */
        private Map<String, String> rawSettings;

        public Builder(TimeCode start, TimeCode end) {
            this.start = start;
            this.end = end;
        }

        public RawCue build() {
            return new RawCue(this);
        }

        public Builder setIdentifier(String identifier) {
            this.identifier = identifier;
            return this;
        }

        public Builder setRawText(String rawText) {
            this.rawText = rawText;
            return this;
        }

        public Builder setRawSettings(Map<String, String> settings) {
            rawSettings = settings;
            return this;
        }

    }

    /***
     * Cue text before it has been converted to a node tree.
     */
    private String rawText;

    private TimeCode start;

    private TimeCode end;

    private String identifier;

    private Map<String, String> rawSettings;

    public RawCue(Builder builder) {
        this.rawText = builder.rawText;
        this.start = builder.start;
        this.end = builder.end;

        this.identifier = builder.identifier;
        this.rawSettings = Collections.unmodifiableMap(builder.rawSettings);
    }

    public TimeCode getEnd() {
        return end;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getRawText() {
        return rawText;
    }

    public TimeCode getStart() {
        return start;
    }

    public Map<String, String> getRawSettings() {
        return rawSettings;
    }

}
