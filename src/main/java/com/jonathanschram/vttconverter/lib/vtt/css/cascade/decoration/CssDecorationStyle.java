package com.jonathanschram.vttconverter.lib.vtt.css.cascade.decoration;

import com.jonathanschram.vttconverter.lib.vtt.css.GlobalValue;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingProperty;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.decoration.LineStyle;

public class CssDecorationStyle extends CascadingProperty<LineStyle> {
    public static final LineStyle INITIAL_VALUE = LineStyle.SOLID;

    public CssDecorationStyle() {
    }

    public CssDecorationStyle(GlobalValue currentValue) {
        super(currentValue);
    }

    @Override
    public LineStyle getInitialValue() {
        return INITIAL_VALUE;
    }

    @Override
    public boolean isInherited() {
        return false;
    }

    @Override
    public String toString() {
        return "CssDecorationStyle [globalValue=" + globalValue + "]";
    }

}
