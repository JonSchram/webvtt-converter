package com.jonathanschram.vttconverter.lib.vtt.css.properties.background;

import com.jonathanschram.vttconverter.lib.vtt.css.CssValue;

public enum BackgroundClip implements CssValue<BackgroundClip> {
    BORDER_BOX, PADDING_BOX, CONTENT_BOX, TEXT;

    @Override
    public boolean isComputedValue() {
        return true;
    }

    @Override
    public BackgroundClip computeValue(BackgroundClip parentValue) {
        return this;
    }

}
