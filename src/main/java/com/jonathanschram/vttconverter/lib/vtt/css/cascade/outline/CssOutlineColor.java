package com.jonathanschram.vttconverter.lib.vtt.css.cascade.outline;

import com.jonathanschram.vttconverter.lib.vtt.css.GlobalValue;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingProperty;
import com.jonathanschram.vttconverter.lib.vtt.css.types.Color;
import com.jonathanschram.vttconverter.lib.vtt.css.types.CurrentColor;

public class CssOutlineColor extends CascadingProperty<Color> {
    // The real value is 'auto' but this evaluates to 'currentcolor.'
    public static final Color INITIAL_VALUE = CurrentColor.getInstance();

    public CssOutlineColor() {
    }

    public CssOutlineColor(GlobalValue currentValue) {
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
        return "CssOutlineColor [globalValue=" + globalValue + "]";
    }
}
