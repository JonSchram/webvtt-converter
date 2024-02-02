package com.jonathanschram.vttconverter.lib.vtt.css.cascade.decoration;

import com.jonathanschram.vttconverter.lib.vtt.css.CssProperty;
import com.jonathanschram.vttconverter.lib.vtt.css.CssShorthand;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.decoration.TextDecoration;

public class CssTextDecoration implements CssShorthand<TextDecoration, CssProperty<TextDecoration>> {

    private CssDecorationColor color;
    private CssDecorationLine line;
    private CssDecorationStyle style;

    public CssTextDecoration() {
        color = new CssDecorationColor();
        line = new CssDecorationLine();
        style = new CssDecorationStyle();
    }

    @Override
    public TextDecoration getInitialValue() {
        return new TextDecoration(color.getInitialValue(), line.getInitialValue(), style.getInitialValue());
    }

}
