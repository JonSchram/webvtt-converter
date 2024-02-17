package com.jonathanschram.vttconverter.lib.vtt.css.properties.font;

import java.util.Objects;

import com.jonathanschram.vttconverter.lib.vtt.css.UncomputedValueException;

public class KeywordFontWeight implements FontWeight {
    private final FontWeightKeyword weight;

    public KeywordFontWeight(FontWeightKeyword weight) {
        this.weight = weight;
    }

    @Override
    public FontWeight computeValue(FontWeight parentValue) throws UncomputedValueException {
        int numericWeight;
        // An absolute keyword is valid as a computed value, but calculate the numeric
        // value just to make inheritance easier.
        if (isRelativeKeyword()) {
            numericWeight = resolveRelativeKeyword(parentValue.getAbsoluteWeight());
        } else {
            numericWeight = resolveAbsoluteKeyword();
        }
        return new NumericFontWeight(numericWeight);
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
    public int getAbsoluteWeight() throws UncomputedValueException {
        if (isRelativeKeyword()) {
            throw new UncomputedValueException("Font weight is a relative weight, cannot get absolute weight.");
        }
        return resolveAbsoluteKeyword();
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight);
    }

    @Override
    public boolean isComputedValue() {
        // Keywords are allowed as a computed value as long as they are absolute.
        return !isRelativeKeyword();
    }

    @Override
    public String toString() {
        return "KeywordFontWeight [weight=" + weight + "]";
    }

    private boolean isRelativeKeyword() {
        return weight == FontWeightKeyword.BOLDER || weight == FontWeightKeyword.LIGHTER;
    }

    private int resolveAbsoluteKeyword() {
        switch (weight) {
        case NORMAL:
            return 400;
        case BOLD:
            return 700;
        default:
            // This was not an absolute keyword, invalid.
            return -1;
        }
    }

    private int resolveRelativeKeyword(int inheritedWeight) {
        switch (weight) {
        case BOLDER:
            if (inheritedWeight <= 300) {
                return 400;
            } else if (inheritedWeight <= 500) {
                return 700;
            } else if (inheritedWeight <= 900) {
                return 900;
            }
        case LIGHTER:
            if (inheritedWeight <= 500) {
                return 100;
            } else if (inheritedWeight <= 700) {
                return 400;
            } else if (inheritedWeight <= 900) {
                return 700;
            }
        default:
            // This was not a relative keyword, invalid.
            return -1;
        }
    }

}
