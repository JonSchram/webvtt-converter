package com.jonathanschram.vttconverter.lib.vtt.css.properties.outline;

import com.jonathanschram.vttconverter.lib.vtt.css.types.AbsoluteColor;

public class Outline {
    private final AbsoluteColor color;
    private final OutlineStyle style;
    private final OutlineWidth width;

    public Outline(AbsoluteColor color, OutlineStyle style, OutlineWidth width) {
        super();
        this.color = color;
        this.style = style;
        this.width = width;
    }

    public AbsoluteColor getColor() {
        return color;
    }

    public OutlineStyle getStyle() {
        return style;
    }

    public OutlineWidth getWidth() {
        return width;
    }

}
