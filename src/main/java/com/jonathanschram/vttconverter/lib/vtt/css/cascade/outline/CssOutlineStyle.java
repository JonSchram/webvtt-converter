package com.jonathanschram.vttconverter.lib.vtt.css.cascade.outline;

import com.jonathanschram.vttconverter.lib.vtt.css.GlobalValue;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingProperty;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.outline.OutlineStyle;

public class CssOutlineStyle extends CascadingProperty<OutlineStyle> {
    public static final OutlineStyle INITIAL_VALUE = OutlineStyle.NONE;

    public CssOutlineStyle() {
    }

    public CssOutlineStyle(GlobalValue currentValue) {
        super(currentValue);
    }

    @Override
    public OutlineStyle getInitialValue() {
        return INITIAL_VALUE;
    }

    @Override
    public boolean isInherited() {
        return false;
    }

    @Override
    public String toString() {
        return "CssOutlineStyle [globalValue=" + globalValue + "]";
    }
}
