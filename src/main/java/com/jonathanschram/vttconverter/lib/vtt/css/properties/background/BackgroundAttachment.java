package com.jonathanschram.vttconverter.lib.vtt.css.properties.background;

import com.jonathanschram.vttconverter.lib.vtt.css.CssValue;

public enum BackgroundAttachment implements CssValue<BackgroundAttachment> {
    SCROLL, FIXED, LOCAL;

    @Override
    public boolean isComputedValue() {
        return true;
    }

    @Override
    public BackgroundAttachment computeValue(BackgroundAttachment parentValue) {
        return this;
    }

}
