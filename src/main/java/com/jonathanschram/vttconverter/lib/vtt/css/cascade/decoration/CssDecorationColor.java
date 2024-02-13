package com.jonathanschram.vttconverter.lib.vtt.css.cascade.decoration;

import com.jonathanschram.vttconverter.lib.vtt.css.GlobalValue;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingProperty;
import com.jonathanschram.vttconverter.lib.vtt.css.types.Color;
import com.jonathanschram.vttconverter.lib.vtt.css.types.CurrentColor;

public class CssDecorationColor extends CascadingProperty<Color> {
    public static final Color INITIAL_VALUE = CurrentColor.getInstance();

    public CssDecorationColor() {
    }

    public CssDecorationColor(GlobalValue currentValue) {
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
        return "CssDecorationColor [globalValue=" + globalValue + "]";
    }
}
