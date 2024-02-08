package com.jonathanschram.vttconverter.lib.vtt.css.properties.font;

import java.util.Objects;

public class KeywordFontSize implements FontSize {

    private final FontSizeKeyword size;

    public KeywordFontSize(FontSizeKeyword size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        KeywordFontSize other = (KeywordFontSize) obj;
        return size == other.size;
    }

    public FontSizeKeyword getSize() {
        return size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size);
    }

    @Override
    public String toString() {
        return "KeywordFontSize [size=" + size + "]";
    }

}
