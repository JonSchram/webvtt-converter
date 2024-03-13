package com.jonathanschram.vttconverter.lib.vtt.css.properties;

import com.jonathanschram.vttconverter.lib.vtt.css.CssValue;
import com.jonathanschram.vttconverter.lib.vtt.css.RenderParameters;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadeValueReference;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.Font;
import com.jonathanschram.vttconverter.lib.vtt.css.types.Color;

public enum WhiteSpace implements CssValue<WhiteSpace> {
    NORMAL, NOWRAP, PRE, PRE_WRAP, PRE_LINE, BREAK_SPACES;

    @Override
    public boolean isComputedValue() {
        return true;
    }

    @Override
    public WhiteSpace computeValue(CascadeValueReference<Color> colorReference, CascadeValueReference<Font> fontReference, RenderParameters parameters) {
        return this;
    }

}
