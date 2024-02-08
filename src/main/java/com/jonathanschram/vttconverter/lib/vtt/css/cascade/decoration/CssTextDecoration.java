package com.jonathanschram.vttconverter.lib.vtt.css.cascade.decoration;

import java.util.Objects;
import java.util.Set;

import com.jonathanschram.vttconverter.lib.vtt.css.CssShorthand;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.decoration.LineStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.decoration.LineType;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.decoration.TextDecoration;
import com.jonathanschram.vttconverter.lib.vtt.css.types.Color;

public class CssTextDecoration implements CssShorthand<TextDecoration, CssTextDecoration> {

    public static class Builder {
        private CssDecorationColor color = new CssDecorationColor();
        private CssDecorationLine line = new CssDecorationLine();
        private CssDecorationStyle style = new CssDecorationStyle();

        public CssTextDecoration build() {
            return new CssTextDecoration(color, line, style);
        }

        public Builder setColor(Color color) {
            this.color = new CssDecorationColor(color);
            return this;
        }

        public Builder setColor(CssDecorationColor color) {
            this.color = color;
            return this;
        }

        public Builder setLine(CssDecorationLine line) {
            this.line = line;
            return this;
        }

        public Builder setLine(Set<LineType> values) {
            this.line = new CssDecorationLine(values);
            return this;
        }

        public Builder setStyle(CssDecorationStyle style) {
            this.style = style;
            return this;
        }

        public Builder setStyle(LineStyle style) {
            this.style = new CssDecorationStyle(style);
            return this;
        }
    }

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
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CssTextDecoration other = (CssTextDecoration) obj;
        return Objects.equals(color, other.color) && Objects.equals(line, other.line)
                && Objects.equals(style, other.style);
    }

    @Override
    public TextDecoration getInitialValue() {
        return new TextDecoration(color.getInitialValue(), line.getInitialValue(), style.getInitialValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, line, style);
    }

    @Override
    public String toString() {
        return "CssTextDecoration [color=" + color + ", line=" + line + ", style=" + style + "]";
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
