package com.jonathanschram.vttconverter.lib.vtt.css.properties;

import com.jonathanschram.vttconverter.lib.vtt.css.CssValue;

public enum Visibility implements CssValue<Visibility> {
    VISIBLE, HIDDEN, COLLAPSE;

    @Override
    public boolean isComputedValue() {
        return true;
    }

    @Override
    public Visibility computeValue(Visibility parentValue) {
        return this;
    }
}
