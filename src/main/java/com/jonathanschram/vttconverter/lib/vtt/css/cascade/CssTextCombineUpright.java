package com.jonathanschram.vttconverter.lib.vtt.css.cascade;

import com.jonathanschram.vttconverter.lib.vtt.css.properties.TextCombineUpright;

public class CssTextCombineUpright extends CascadingStyle<TextCombineUpright> {

    public CssTextCombineUpright() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public TextCombineUpright getInitialValue() {
        // Default is to not combine. May want to revisit returning null.
        return null;
    }
}
