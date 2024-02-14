package com.jonathanschram.vttconverter.lib.vtt.css.properties;

import com.jonathanschram.vttconverter.lib.vtt.css.CssValue;

public enum WhiteSpace implements CssValue<WhiteSpace> {
    NORMAL, NOWRAP, PRE, PRE_WRAP, PRE_LINE, BREAK_SPACES;

    @Override
    public boolean isComputedValue() {
        return true;
    }

    @Override
    public WhiteSpace computeValue() {
        return this;
    }

}
