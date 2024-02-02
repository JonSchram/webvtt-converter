package com.jonathanschram.vttconverter.lib.vtt.css.cascade.decoration;

import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.types.Color;
import com.jonathanschram.vttconverter.lib.vtt.css.types.CurrentColor;

public class CssDecorationColor extends CascadingStyle<Color> {

    public CssDecorationColor() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public Color getInitialValue() {
        return CurrentColor.getInstance();
    }
}
