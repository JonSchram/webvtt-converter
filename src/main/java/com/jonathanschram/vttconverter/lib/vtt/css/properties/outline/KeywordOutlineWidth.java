package com.jonathanschram.vttconverter.lib.vtt.css.properties.outline;

import java.util.Objects;

import com.jonathanschram.vttconverter.lib.vtt.css.types.Unit;
import com.jonathanschram.vttconverter.lib.vtt.css.types.length.Length;
import com.jonathanschram.vttconverter.lib.vtt.css.types.length.NumericLength;

public class KeywordOutlineWidth implements OutlineWidth {
    private final OutlineWidthKeyword width;

    public KeywordOutlineWidth(OutlineWidthKeyword width) {
        this.width = width;
    }

    @Override
    public Length getMeasuredSize() {
        switch (width) {
        case THIN:
            return new NumericLength(1, Unit.PIXELS);
        case MEDIUM:
            return new NumericLength(3, Unit.PIXELS);
        case THICK:
            return new NumericLength(5, Unit.PIXELS);
        default:
            // Default to medium.
            return new NumericLength(3, Unit.PIXELS);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(width);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        KeywordOutlineWidth other = (KeywordOutlineWidth) obj;
        return width == other.width;
    }

    @Override
    public String toString() {
        return "KeywordOutlineWidth [width=" + width + "]";
    }

    @Override
    public boolean isComputedValue() {
        return false;
    }

    @Override
    public OutlineWidth computeValue() {
        // TODO The computed value is a length, not an outline width... Unless there is
        // an "absolute length outline width" I don't see how to make this work.
        return new AbsoluteOutlineWidth(getMeasuredSize());
    }

}
