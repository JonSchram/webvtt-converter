package com.jonathanschram.vttconverter.lib.vtt.css.properties.decoration;

import java.awt.Color;
import java.util.Set;

public class TextDecoration {
    private final Color color;
    private final Set<LineType> lines;
    private final LineStyle style;

    public TextDecoration(Color color, LineType line, LineStyle style) {
        this(color, Set.of(line), style);
    }

    public TextDecoration(Color color, Set<LineType> lines, LineStyle style) {
        this.color = color;
        this.lines = Set.copyOf(lines);
        this.style = style;
    }
    public Color getColor() {
        return color;
    }

    public Set<LineType> getLines() {
        return lines;
    }
    
    public LineStyle getStyle() {
        return style;
    }

}
