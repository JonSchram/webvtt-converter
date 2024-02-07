package com.jonathanschram.vttconverter.lib.vtt.css.cascade;

import com.jonathanschram.vttconverter.lib.vtt.css.GlobalValue;
import com.jonathanschram.vttconverter.lib.vtt.css.types.AbsoluteColor;
import com.jonathanschram.vttconverter.lib.vtt.css.types.Color;

public class CssColor extends CascadingStyle<Color> {
    private static final Color INITIAL_VALUE = AbsoluteColor.CANVAS_TEXT;

    public CssColor() {
    }

    public CssColor(Color value) {
        super(value);
    }

    public CssColor(GlobalValue value) {
        super(value);
    }

    @Override
    public Color getInitialValue() {
        return INITIAL_VALUE;
    }
}
