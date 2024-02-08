package com.jonathanschram.vttconverter.lib.vtt.css.cascade.outline;

import java.util.Objects;

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
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CssOutline other = (CssOutline) obj;
        return Objects.equals(color, other.color) && Objects.equals(style, other.style)
                && Objects.equals(width, other.width);
    }

    @Override
    public Outline getInitialValue() {
        return new Outline(color.getInitialValue(), style.getInitialValue(), width.getInitialValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, style, width);
    }

    @Override
    public String toString() {
        return "CssOutline [color=" + color + ", style=" + style + ", width=" + width + "]";
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
