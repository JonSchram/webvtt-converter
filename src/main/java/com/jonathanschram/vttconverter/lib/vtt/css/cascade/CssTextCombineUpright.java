package com.jonathanschram.vttconverter.lib.vtt.css.cascade;

import com.jonathanschram.vttconverter.lib.vtt.css.GlobalValue;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.TextCombineUpright;

public class CssTextCombineUpright extends CascadingProperty<TextCombineUpright> {

    public CssTextCombineUpright() {
    }

    public CssTextCombineUpright(GlobalValue currentValue) {
        super(currentValue);
    }

    @Override
    public TextCombineUpright getInitialValue() {
        // Default is to not combine. May want to revisit returning null.
        return null;
    }

    @Override
    public boolean isInherited() {
        return true;
    }

    @Override
    public String toString() {
        return "CssTextCombineUpright [globalValue=" + globalValue + "]";
    }
}
