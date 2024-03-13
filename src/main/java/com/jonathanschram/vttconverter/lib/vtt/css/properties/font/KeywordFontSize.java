package com.jonathanschram.vttconverter.lib.vtt.css.properties.font;

import java.util.Objects;

import com.jonathanschram.vttconverter.lib.vtt.css.RenderParameters;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadeValueReference;
import com.jonathanschram.vttconverter.lib.vtt.css.types.Color;
import com.jonathanschram.vttconverter.lib.vtt.css.types.Unit;
import com.jonathanschram.vttconverter.lib.vtt.css.types.length.Length;
import com.jonathanschram.vttconverter.lib.vtt.css.types.length.NumericLength;

public class KeywordFontSize implements FontSize {
    private static final NumericLength MEDIUM_FONT_HEIGHT = new NumericLength(16, Unit.PIXELS);

    private final FontSizeKeyword size;

    public KeywordFontSize(FontSizeKeyword size) {
        this.size = size;
    }

    @Override
    public FontSize computeValue(CascadeValueReference<Color> colorReference,
            CascadeValueReference<Font> fontReference, RenderParameters parameters) {
        if (isComputedValue()) {
            return this;
        }

        Font parentFont = fontReference.getParentValue();
        FontSize parentSize = parentFont.getSize();

        if (size == FontSizeKeyword.LARGER) {
            return parentSize.getNextLarger();
        } else if (size == FontSizeKeyword.SMALLER) {
            return parentSize.getNextSmaller();
        }
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
    public boolean isComputedValue() {
        return FontSizeKeyword.ABSOLUTE_SIZES.contains(size);
    }

    @Override
    public String toString() {
        return "KeywordFontSize [size=" + size + "]";
    }

    // Size conversions from official spec at
    // https://www.w3.org/TR/css-fonts-3/#absolute-size-value
    @Override
    public FontSize getNextSmaller() {
        switch (size) {
        case XX_SMALL:
            // Assume the shrink from XX_SMALL to a smaller size is the same as from X_SMALL
            // to XX_SMALL.
            Length smallestLength = new NumericLength(MEDIUM_FONT_HEIGHT.getValue() * 12 / 25,
                    MEDIUM_FONT_HEIGHT.getUnit());
            return new NumericFontSize(smallestLength);
        case X_SMALL:
            return new KeywordFontSize(FontSizeKeyword.XX_SMALL);
        case SMALL:
            return new KeywordFontSize(FontSizeKeyword.X_SMALL);
        case MEDIUM:
            return new KeywordFontSize(FontSizeKeyword.SMALL);
        case LARGE:
            return new KeywordFontSize(FontSizeKeyword.MEDIUM);
        case X_LARGE:
            return new KeywordFontSize(FontSizeKeyword.LARGE);
        case XX_LARGE:
            return new KeywordFontSize(FontSizeKeyword.X_LARGE);
        case XXX_LARGE:
            return new KeywordFontSize(FontSizeKeyword.XX_LARGE);
        default:
            return new KeywordFontSize(FontSizeKeyword.MEDIUM);
        }
    }

    @Override
    public FontSize getNextLarger() {
        switch (size) {
        case XX_SMALL:
            return new KeywordFontSize(FontSizeKeyword.X_SMALL);
        case X_SMALL:
            return new KeywordFontSize(FontSizeKeyword.SMALL);
        case SMALL:
            return new KeywordFontSize(FontSizeKeyword.MEDIUM);
        case MEDIUM:
            return new KeywordFontSize(FontSizeKeyword.LARGE);
        case LARGE:
            return new KeywordFontSize(FontSizeKeyword.X_LARGE);
        case X_LARGE:
            return new KeywordFontSize(FontSizeKeyword.XX_LARGE);
        case XX_LARGE:
            return new KeywordFontSize(FontSizeKeyword.XXX_LARGE);
        case XXX_LARGE:
            // Assume the growth from XX_LARGE to XXX_LARGE is the same as the growth after
            // XXX_LARGE.
            Length largestLength = new NumericLength(MEDIUM_FONT_HEIGHT.getValue() * 8 / 3,
                    MEDIUM_FONT_HEIGHT.getUnit());
            return new NumericFontSize(largestLength);
        default:
            return new KeywordFontSize(FontSizeKeyword.MEDIUM);
        }
    }

}
