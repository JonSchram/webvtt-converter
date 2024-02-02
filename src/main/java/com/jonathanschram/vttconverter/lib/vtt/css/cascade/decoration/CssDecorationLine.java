package com.jonathanschram.vttconverter.lib.vtt.css.cascade.decoration;

import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.decoration.LineType;

public class CssDecorationLine extends CascadingStyle<LineType> {

    public CssDecorationLine() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public LineType getInitialValue() {
        return LineType.NONE;
    }

}
