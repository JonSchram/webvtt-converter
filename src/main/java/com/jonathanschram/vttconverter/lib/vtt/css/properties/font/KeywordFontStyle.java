package com.jonathanschram.vttconverter.lib.vtt.css.properties.font;

import java.util.Objects;

public class KeywordFontStyle implements FontStyle {
    private final FontStyleKeyword style;

    public KeywordFontStyle(FontStyleKeyword style) {
        this.style = style;
    }

    @Override
    public FontStyle computeValue() {
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
        KeywordFontStyle other = (KeywordFontStyle) obj;
        return style == other.style;
    }

    public FontStyleKeyword getStyle() {
        return style;
    }

    @Override
    public int hashCode() {
        return Objects.hash(style);
    }

    @Override
    public boolean isComputedValue() {
        return true;
    }

    @Override
    public String toString() {
        return "KeywordFontStyle [style=" + style + "]";
    }

}
