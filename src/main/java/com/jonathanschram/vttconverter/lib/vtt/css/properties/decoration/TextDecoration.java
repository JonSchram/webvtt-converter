package com.jonathanschram.vttconverter.lib.vtt.css.properties.decoration;

import java.util.Objects;

import com.jonathanschram.vttconverter.lib.vtt.css.types.Color;

public class TextDecoration {
    private final Color color;
    private final LineTypeSet lines;
    private final LineStyle style;

    public TextDecoration(Color color, LineType line, LineStyle style) {
        this(color, new LineTypeSet(line), style);
    }

    public TextDecoration(Color color, LineTypeSet lines, LineStyle style) {
        this.color = color;
        this.lines = lines;
        this.style = style;
    }

    public Color getColor() {
        return color;
    }

    public LineTypeSet getLines() {
        return lines;
    }

    public LineStyle getStyle() {
        return style;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, lines, style);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TextDecoration other = (TextDecoration) obj;
        return Objects.equals(color, other.color) && Objects.equals(lines, other.lines) && style == other.style;
    }

    @Override
    public String toString() {
        return "TextDecoration [color=" + color + ", lines=" + lines + ", style=" + style + "]";
    }

}
