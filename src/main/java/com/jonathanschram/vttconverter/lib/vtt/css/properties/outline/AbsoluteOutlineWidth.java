package com.jonathanschram.vttconverter.lib.vtt.css.properties.outline;

import java.util.Objects;

import com.jonathanschram.vttconverter.lib.vtt.css.types.length.Length;

public class AbsoluteOutlineWidth implements OutlineWidth {

    private Length width;

    public AbsoluteOutlineWidth(Length width) {
        this.width = width;
    }

    @Override
    public OutlineWidth computeValue(OutlineWidth parentValue) {
        if (isComputedValue()) {
            return this;
        }
        // TODO Convert width to an absolute measurement.
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AbsoluteOutlineWidth other = (AbsoluteOutlineWidth) obj;
        return Objects.equals(width, other.width);
    }

    @Override
    public Length getMeasuredSize() {
        return width;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width);
    }

    @Override
    public boolean isComputedValue() {
        return width.isAbsoluteLength();
    }

}
