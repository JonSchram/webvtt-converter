package com.jonathanschram.vttconverter.lib.vtt.css.properties;

import com.jonathanschram.vttconverter.lib.vtt.css.CssValue;
import com.jonathanschram.vttconverter.lib.vtt.css.RenderParameters;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadeValueReference;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.Font;
import com.jonathanschram.vttconverter.lib.vtt.css.types.Color;

public enum Visibility implements CssValue<Visibility> {
    VISIBLE, HIDDEN, COLLAPSE;

    @Override
    public boolean isComputedValue() {
        return true;
    }

    @Override
    public Visibility computeValue(CascadeValueReference<Color> colorReference, CascadeValueReference<Font> fontReference, RenderParameters parameters) {
        return this;
    }
}
