package com.jonathanschram.vttconverter.lib.vtt.css.cascade.decoration;

import com.jonathanschram.vttconverter.lib.vtt.css.GlobalValue;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.decoration.LineStyle;

public class CssDecorationStyle extends CascadingStyle<LineStyle> {

    public CssDecorationStyle() {
    }

    public CssDecorationStyle(GlobalValue currentValue) {
        super(currentValue);
    }

    public CssDecorationStyle(LineStyle currentValue) {
        super(currentValue);
    }

    @Override
    public LineStyle getInitialValue() {
        return LineStyle.SOLID;
    }

    @Override
    public String toString() {
        return "CssDecorationStyle [globalValue=" + globalValue + ", wrappedValue=" + wrappedValue + "]";
    }

}
