package com.jonathanschram.vttconverter.lib.vtt.css.cascade.decoration;

import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.decoration.LineStyle;

public class CssDecorationStyle extends CascadingStyle<LineStyle> {

    public CssDecorationStyle() {
    }

    @Override
    public LineStyle getInitialValue() {
        return LineStyle.SOLID;
    }

}
