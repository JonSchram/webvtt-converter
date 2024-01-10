package com.jonathanschram.vttconverter.lib.vtt.cue.node;

import com.jonathanschram.vttconverter.lib.vtt.cue.TimeCode;

/***
 * A node that indicates a time at which the text that follows it should appear.
 */
public class TimestampNode extends VttNode {
    public static class Builder extends VttNode.Builder {

        protected TimeCode time;

        @Override
        public VttNode build() {
            return new TimestampNode(this);
        }

        public Builder setTimeCode(TimeCode time) {
            this.time = time;
            return this;
        }

    }

    private TimeCode time;

    public TimestampNode(Builder builder) {
        this.time = builder.time;
    }

    public TimeCode getTimeCode() {
        return time;
    }
}
