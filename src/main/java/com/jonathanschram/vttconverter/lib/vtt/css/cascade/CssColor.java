package com.jonathanschram.vttconverter.lib.vtt.css.cascade;

import com.jonathanschram.vttconverter.lib.vtt.css.GlobalValue;
import com.jonathanschram.vttconverter.lib.vtt.css.types.AbsoluteColor;
import com.jonathanschram.vttconverter.lib.vtt.css.types.Color;

public class CssColor extends CascadingProperty<Color> {
    private static final Color INITIAL_VALUE = AbsoluteColor.CANVAS_TEXT;

    public CssColor() {
    }

    public CssColor(GlobalValue value) {
        super(value);
    }

    @Override
    public Color getInitialValue() {
        return INITIAL_VALUE;
    }

    @Override
    public boolean isInherited() {
        return true;
    }

    @Override
    public String toString() {
        return "CssColor [globalValue=" + globalValue + "]";
    }
}
