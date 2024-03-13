package com.jonathanschram.vttconverter.lib.vtt.css.properties.decoration;

import com.jonathanschram.vttconverter.lib.vtt.css.CssValue;
import com.jonathanschram.vttconverter.lib.vtt.css.RenderParameters;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadeValueReference;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.Font;
import com.jonathanschram.vttconverter.lib.vtt.css.types.Color;

/** Style of line to be drawn. */
public enum LineStyle implements CssValue<LineStyle> {
    SOLID, DOUBLE, DOTTED, DASHED, WAVY;

    @Override
    public boolean isComputedValue() {
        return true;
    }

    @Override
    public LineStyle computeValue(CascadeValueReference<Color> colorReference, CascadeValueReference<Font> fontReference, RenderParameters parameters) {
        return this;
    }
}
