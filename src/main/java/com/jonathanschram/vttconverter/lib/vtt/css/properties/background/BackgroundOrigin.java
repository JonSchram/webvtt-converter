package com.jonathanschram.vttconverter.lib.vtt.css.properties.background;

import com.jonathanschram.vttconverter.lib.vtt.css.CssValue;

public enum BackgroundOrigin implements CssValue<BackgroundOrigin> {
    BORDER_BOX, PADDING_BOX, CONTENT_BOX;

    @Override
    public boolean isComputedValue() {
        return true;
    }

    @Override
    public BackgroundOrigin computeValue(BackgroundOrigin parentValue) {
        return this;
    }

}
