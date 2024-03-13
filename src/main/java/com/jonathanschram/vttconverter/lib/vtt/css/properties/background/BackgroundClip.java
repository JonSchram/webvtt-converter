package com.jonathanschram.vttconverter.lib.vtt.css.properties.background;

import com.jonathanschram.vttconverter.lib.vtt.css.CssValue;
import com.jonathanschram.vttconverter.lib.vtt.css.RenderParameters;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadeValueReference;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.Font;
import com.jonathanschram.vttconverter.lib.vtt.css.types.Color;

public enum BackgroundClip implements CssValue<BackgroundClip> {
    BORDER_BOX, PADDING_BOX, CONTENT_BOX, TEXT;

    @Override
    public boolean isComputedValue() {
        return true;
    }

    @Override
    public BackgroundClip computeValue(CascadeValueReference<Color> colorReference, CascadeValueReference<Font> fontReference, RenderParameters parameters) {
        return this;
    }

}
