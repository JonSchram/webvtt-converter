package com.jonathanschram.vttconverter.lib.vtt.css.properties.background.size;

import java.util.Objects;

/***
 * An interface for background sizing that calculates the dimensions based on a
 * {@link SizeKeyword}.
 */
public class KeywordSize implements BackgroundSize {

    private final SizeKeyword value;

    public KeywordSize(SizeKeyword value) {
        this.value = value;
    }

    @Override
    public BackgroundSize computeValue() {
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
        KeywordSize other = (KeywordSize) obj;
        return value == other.value;
    }

    public SizeKeyword getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public boolean isComputedValue() {
        return true;
    }

    @Override
    public String toString() {
        return "KeywordSize [value=" + value + "]";
    }

}
