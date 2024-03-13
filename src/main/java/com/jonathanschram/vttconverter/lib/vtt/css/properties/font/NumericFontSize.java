package com.jonathanschram.vttconverter.lib.vtt.css.properties.font;

import com.jonathanschram.vttconverter.lib.vtt.css.RenderParameters;
import com.jonathanschram.vttconverter.lib.vtt.css.UncomputedValueException;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadeValueReference;
import com.jonathanschram.vttconverter.lib.vtt.css.types.Color;
import com.jonathanschram.vttconverter.lib.vtt.css.types.length.Length;

public class NumericFontSize implements FontSize {
    /***
     * The factor by which font size increases or decreases when getting the next
     * larger or smaller font size.
     */
    private static final double SCALE_FACTOR = 1.2;
    private final Length size;

    public NumericFontSize(Length size) {
        this.size = size;
    }

    @Override
    public boolean isComputedValue() {
        return size.isAbsoluteLength();
    }

    @Override
    public FontSize computeValue(CascadeValueReference<Color> colorReference,
            CascadeValueReference<Font> fontReference, RenderParameters parameters)
            throws UncomputedValueException {
        if (isComputedValue()) {
            return this;
        }

        return new NumericFontSize(size.convertToAbsoluteLength(fontReference, null));
    }

    @Override
    public FontSize getNextSmaller() {
        return new NumericFontSize(size.multiply(1 / SCALE_FACTOR));
    }

    @Override
    public FontSize getNextLarger() {
        return new NumericFontSize(size.multiply(SCALE_FACTOR));
    }

}
