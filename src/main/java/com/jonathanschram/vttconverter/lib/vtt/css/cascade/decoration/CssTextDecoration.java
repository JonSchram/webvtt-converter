package com.jonathanschram.vttconverter.lib.vtt.css.cascade.decoration;

import com.jonathanschram.vttconverter.lib.vtt.css.CssShorthand;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.decoration.TextDecoration;

public class CssTextDecoration implements CssShorthand<TextDecoration, CssTextDecoration> {

    private CssDecorationColor color;
    private CssDecorationLine line;
    private CssDecorationStyle style;

    public CssTextDecoration() {
        this(new CssDecorationColor(), new CssDecorationLine(), new CssDecorationStyle());
    }

    public CssTextDecoration(CssDecorationColor color, CssDecorationLine line, CssDecorationStyle style) {
        if (color == null || line == null || style == null) {
            throw new IllegalArgumentException("CSS values may not be null.");
        }

        this.color = color;
        this.line = line;
        this.style = style;
    }

    @Override
    public TextDecoration getInitialValue() {
        return new TextDecoration(color.getInitialValue(), line.getInitialValue(), style.getInitialValue());
    }

    @Override
    public void updateStyle(CssTextDecoration newValue) {
        if (newValue == null) {
            return;
        }
        
        color.updateStyle(newValue.color);
        line.updateStyle(newValue.line);
        style.updateStyle(newValue.style);
    }

}
