package com.jonathanschram.vttconverter.lib.vtt.css.cascade.outline;

import com.jonathanschram.vttconverter.lib.vtt.css.CssShorthand;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.outline.Outline;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.outline.OutlineStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.outline.OutlineWidth;
import com.jonathanschram.vttconverter.lib.vtt.css.types.Color;

public class CssOutline implements CssShorthand<Outline, CssOutline> {

    private CssOutlineColor color;
    private CssOutlineStyle style;
    private CssOutlineWidth width;

    public CssOutline() {
        this(new CssOutlineColor(), new CssOutlineStyle(), new CssOutlineWidth());
    }

    public CssOutline(Color color, OutlineStyle style, OutlineWidth width) {
        this(new CssOutlineColor(color), new CssOutlineStyle(style), new CssOutlineWidth(width));
    }

    public CssOutline(CssOutlineColor color, CssOutlineStyle style, CssOutlineWidth width) {
        if (color == null || style == null || width == null) {
            throw new IllegalArgumentException("CSS values may not be null.");
        }
        this.color = color;
        this.style = style;
        this.width = width;
    }

    @Override
    public Outline getInitialValue() {
        return new Outline(color.getInitialValue(), style.getInitialValue(), width.getInitialValue());
    }

    @Override
    public void updateStyle(CssOutline newValue) {
        if (newValue == null) {
            return;
        }
        
        color.updateStyle(newValue.color);
        style.updateStyle(newValue.style);
        width.updateStyle(newValue.width);
    }
}
