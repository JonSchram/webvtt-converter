package com.jonathanschram.vttconverter.lib.vtt.css.properties.font;

import java.util.Objects;

import com.jonathanschram.vttconverter.lib.vtt.css.types.Percentage;

public class KeywordFontStretch implements FontStretch {
    private final FontStretchKeyword stretch;

    public KeywordFontStretch(FontStretchKeyword stretch) {
        this.stretch = stretch;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        KeywordFontStretch other = (KeywordFontStretch) obj;
        return stretch == other.stretch;
    }

    @Override
    public Percentage getStretchPercent() {
        switch (stretch) {
        case ULTRA_CONDENSED:
            return new Percentage(50);
        case EXTRA_CONDENSED:
            return new Percentage(62.5);
        case CONDENSED:
            return new Percentage(75);
        case SEMI_CONDENSED:
            return new Percentage(87.5);
        case NORMAL:
            return new Percentage(100);
        case SEMI_EXPANDED:
            return new Percentage(112.5);
        case EXPANDED:
            return new Percentage(125);
        case EXTRA_EXPANDED:
            return new Percentage(150);
        case ULTRA_EXPANDED:
            return new Percentage(200);
        default:
            // Default to normal.
            return new Percentage(100);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(stretch);
    }

    @Override
    public String toString() {
        return "KeywordFontStretch [stretch=" + stretch + "]";
    }

    @Override
    public boolean isComputedValue() {
        return false;
    }

    @Override
    public FontStretch computeValue() {
        // TODO Create a percentage font stretch.
        return null;
    }

}
