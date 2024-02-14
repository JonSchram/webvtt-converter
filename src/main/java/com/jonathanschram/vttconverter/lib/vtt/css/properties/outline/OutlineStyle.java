package com.jonathanschram.vttconverter.lib.vtt.css.properties.outline;

import com.jonathanschram.vttconverter.lib.vtt.css.CssValue;

public enum OutlineStyle implements CssValue<OutlineStyle> {
    AUTO, NONE, DOTTED, DASHED, SOLID, DOUBLE, GROOVE, RIDGE, INSET, OUTSET;

    @Override
    public boolean isComputedValue() {
        return true;
    }

    @Override
    public OutlineStyle computeValue() {
        return this;
    }
}
