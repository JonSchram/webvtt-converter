package com.jonathanschram.vttconverter.lib.vtt.cue.node;

import java.util.Objects;

import com.jonathanschram.vttconverter.lib.vtt.cue.NodeVisitor;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TimestampNode other = (TimestampNode) obj;
        return Objects.equals(time, other.time);
    }

    public TimeCode getTimeCode() {
        return time;
    }

    @Override
    public int hashCode() {
        return Objects.hash(time);
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visitTimestampNode(this);
    }
}
