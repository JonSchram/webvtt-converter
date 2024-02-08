package com.jonathanschram.vttconverter.lib.vtt.css.cascade.outline;

import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.outline.OutlineStyle;

public class CssOutlineStyle extends CascadingStyle<OutlineStyle> {
    public static final OutlineStyle INITIAL_VALUE = OutlineStyle.NONE;

    public CssOutlineStyle() {
    }

    public CssOutlineStyle(OutlineStyle style) {
        super(style);
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
        return "CssOutlineStyle [globalValue=" + globalValue + ", wrappedValue=" + wrappedValue + "]";
    }
}
