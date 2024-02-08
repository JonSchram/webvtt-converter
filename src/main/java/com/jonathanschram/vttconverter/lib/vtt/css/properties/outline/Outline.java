package com.jonathanschram.vttconverter.lib.vtt.css.properties.outline;

import java.util.Objects;

import com.jonathanschram.vttconverter.lib.vtt.css.types.Color;

public class Outline {
    private final Color color;
    private final OutlineStyle style;
    private final OutlineWidth width;

    public Outline(Color color, OutlineStyle style, OutlineWidth width) {
        super();
        this.color = color;
        this.style = style;
        this.width = width;
    }

    public Color getColor() {
        return color;
    }

    public OutlineStyle getStyle() {
        return style;
    }

    public OutlineWidth getWidth() {
        return width;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, style, width);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Outline other = (Outline) obj;
        return Objects.equals(color, other.color) && style == other.style && Objects.equals(width, other.width);
    }

    @Override
    public String toString() {
        return "Outline [color=" + color + ", style=" + style + ", width=" + width + "]";
    }

}
