package com.jonathanschram.vttconverter.lib.vtt.css.cascade.font;

import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.LineHeight;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.NormalLineHeight;

public class CssLineHeight extends CascadingStyle<LineHeight> {

    public CssLineHeight() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public LineHeight getInitialValue() {
        return NormalLineHeight.getInstance();
    }
}
