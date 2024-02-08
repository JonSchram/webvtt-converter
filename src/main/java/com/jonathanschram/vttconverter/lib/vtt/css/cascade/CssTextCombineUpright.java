package com.jonathanschram.vttconverter.lib.vtt.css.cascade;

import com.jonathanschram.vttconverter.lib.vtt.css.properties.TextCombineUpright;

public class CssTextCombineUpright extends CascadingStyle<TextCombineUpright> {

    public CssTextCombineUpright() {
    }

    @Override
    public TextCombineUpright getInitialValue() {
        // Default is to not combine. May want to revisit returning null.
        return null;
    }

    @Override
    public String toString() {
        return "CssTextCombineUpright [globalValue=" + globalValue + ", wrappedValue=" + wrappedValue + "]";
    }
}
