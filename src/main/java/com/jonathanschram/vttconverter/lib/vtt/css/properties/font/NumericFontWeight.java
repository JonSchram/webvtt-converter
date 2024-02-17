package com.jonathanschram.vttconverter.lib.vtt.css.properties.font;

import java.util.Objects;

public class NumericFontWeight implements FontWeight {
    private final int weight;

    public NumericFontWeight(int weight) {
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
        NumericFontWeight other = (NumericFontWeight) obj;
        return weight == other.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight);
    }

    @Override
    public String toString() {
        return "NumericFontWeight [weight=" + weight + "]";
    }

    @Override
    public boolean isComputedValue() {
        return true;
    }

    @Override
    public FontWeight computeValue(FontWeight parentValue) {
        return this;
    }

    @Override
    public int getAbsoluteWeight() {
        return weight;
    }

}
