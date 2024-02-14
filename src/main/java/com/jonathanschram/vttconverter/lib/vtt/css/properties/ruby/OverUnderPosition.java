package com.jonathanschram.vttconverter.lib.vtt.css.properties.ruby;

import java.util.Objects;

/***
 * An implementation of {@link RubyPosition} that encodes an over or under style
 * with corresponding alternate setting.
 */
public class OverUnderPosition implements RubyPosition {

    /***
     * Whether the ruby position alternates between over and under.
     */
    private final boolean alternate;
    private final RubyTextPosition position;

    public OverUnderPosition(boolean alternate, RubyTextPosition position) {
        super();
        this.alternate = alternate;
        this.position = position;
    }

    @Override
    public RubyPosition computeValue() {
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OverUnderPosition other = (OverUnderPosition) obj;
        return alternate == other.alternate && position == other.position;
    }

    public RubyTextPosition getPosition() {
        return position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(alternate, position);
    }

    public boolean isAlternate() {
        return alternate;
    }

    @Override
    public boolean isComputedValue() {
        return true;
    }

    @Override
    public String toString() {
        return "OverUnderPosition [alternate=" + alternate + ", position=" + position + "]";
    }

}
