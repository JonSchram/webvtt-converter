package com.jonathanschram.vttconverter.lib.vtt.css.cascade.background;

import com.jonathanschram.vttconverter.lib.vtt.css.GlobalValue;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingProperty;
import com.jonathanschram.vttconverter.lib.vtt.css.types.AbsoluteColor;
import com.jonathanschram.vttconverter.lib.vtt.css.types.Color;

public class CssBackgroundColor extends CascadingProperty<Color> {
    public static final Color INITIAL_VALUE = AbsoluteColor.TRANSPARENT;

    public CssBackgroundColor() {
    }

    public CssBackgroundColor(GlobalValue currentValue) {
        super(currentValue);
    }

    @Override
    public Color getInitialValue() {
        return INITIAL_VALUE;
    }

    @Override
    public boolean isInherited() {
        return false;
    }

    @Override
    public String toString() {
        return "CssBackgroundColor [globalValue=" + globalValue + "]";
    }

}
