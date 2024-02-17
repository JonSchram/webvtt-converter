package com.jonathanschram.vttconverter.lib.vtt.css.properties.decoration;

import com.jonathanschram.vttconverter.lib.vtt.css.CssValue;

/** Style of line to be drawn. */
public enum LineStyle implements CssValue<LineStyle> {
    SOLID, DOUBLE, DOTTED, DASHED, WAVY;

    @Override
    public boolean isComputedValue() {
        return true;
    }

    @Override
    public LineStyle computeValue(LineStyle parentValue) {
        return this;
    }
}
