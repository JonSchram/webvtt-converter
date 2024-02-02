package com.jonathanschram.vttconverter.lib.vtt.css.cascade.outline;

import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.types.Color;
import com.jonathanschram.vttconverter.lib.vtt.css.types.CurrentColor;

public class CssOutlineColor extends CascadingStyle<Color> {

    public CssOutlineColor() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public Color getInitialValue() {
        // The real value is 'auto' but this evaluates to 'currentcolor.'
        return CurrentColor.getInstance();
    }
}
