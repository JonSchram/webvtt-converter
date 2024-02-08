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

}
