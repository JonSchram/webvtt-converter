package com.jonathanschram.vttconverter.lib.vtt.css.properties.font;

import com.jonathanschram.vttconverter.lib.vtt.css.RenderParameters;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadeValueReference;
import com.jonathanschram.vttconverter.lib.vtt.css.types.Color;

/***
 * An implementation of {@link LineHeight} for normal height.
 */
public class NormalLineHeight implements LineHeight {
    private static NormalLineHeight instance;

    public static NormalLineHeight getInstance() {
        if (instance == null) {
            instance = new NormalLineHeight();
        }
        return instance;
    }

    private NormalLineHeight() {
    }

    @Override
    public LineHeight computeValue(CascadeValueReference<Color> colorReference, CascadeValueReference<Font> fontReference, RenderParameters parameters) {
        return this;
    }

    @Override
    public boolean isComputedValue() {
        return true;
    }

    @Override
    public String toString() {
        return "NormalLineHeight []";
    }

}
