package com.jonathanschram.vttconverter.lib.vtt.css.cascade.decoration;

import com.jonathanschram.vttconverter.lib.vtt.css.GlobalValue;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.types.Color;
import com.jonathanschram.vttconverter.lib.vtt.css.types.CurrentColor;

public class CssDecorationColor extends CascadingStyle<Color> {

    public CssDecorationColor() {
    }

    public CssDecorationColor(Color currentValue) {
        super(currentValue);
    }

    public CssDecorationColor(GlobalValue currentValue) {
        super(currentValue);
    }

    @Override
    public Color getInitialValue() {
        return CurrentColor.getInstance();
    }

    @Override
    public String toString() {
        return "CssDecorationColor [globalValue=" + globalValue + ", wrappedValue=" + wrappedValue + "]";
    }
}
