package com.jonathanschram.vttconverter.lib.vtt.css.properties.font;

import java.util.Objects;

public class KeywordFontWeight implements FontWeight {
    private final FontWeightKeyword weight;

    public KeywordFontWeight(FontWeightKeyword weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        KeywordFontWeight other = (KeywordFontWeight) obj;
        return weight == other.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight);
    }

    @Override
    public String toString() {
        return "KeywordFontWeight [weight=" + weight + "]";
    }

    @Override
    public boolean isComputedValue() {
        // Keywords are allowed as a computed value as long as they are absolute.
        return weight != FontWeightKeyword.BOLDER && weight != FontWeightKeyword.LIGHTER;
    }

    @Override
    public FontWeight computeValue() {
        if (isComputedValue()) {
            return this;
        }
        // TODO Convert bolder / lighter to absolute amounts.
        return null;
    }

}
