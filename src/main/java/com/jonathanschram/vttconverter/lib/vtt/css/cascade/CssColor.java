package com.jonathanschram.vttconverter.lib.vtt.css.cascade;

import com.jonathanschram.vttconverter.lib.vtt.css.types.AbsoluteColor;

public class CssColor extends CascadingStyle<AbsoluteColor> {

    public CssColor() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public AbsoluteColor getInitialValue() {
        return AbsoluteColor.CANVAS_TEXT;
    }
}
