package com.jonathanschram.vttconverter.lib.vtt.css.cascade.background;

import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.types.AbsoluteColor;
import com.jonathanschram.vttconverter.lib.vtt.css.types.Color;

public class CssBackgroundColor extends CascadingStyle<Color> {

    public CssBackgroundColor() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public Color getInitialValue() {
        return AbsoluteColor.TRANSPARENT;
    }

}
