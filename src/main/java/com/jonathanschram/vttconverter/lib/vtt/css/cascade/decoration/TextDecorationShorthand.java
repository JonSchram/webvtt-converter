package com.jonathanschram.vttconverter.lib.vtt.css.cascade.decoration;

import java.util.Objects;

import com.jonathanschram.vttconverter.lib.vtt.css.CssProperty;
import com.jonathanschram.vttconverter.lib.vtt.css.CssShorthand;
import com.jonathanschram.vttconverter.lib.vtt.css.UncomputedValueException;
import com.jonathanschram.vttconverter.lib.vtt.css.UnresolvedPropertyException;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.ConcreteProperty;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.decoration.LineStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.decoration.LineTypeSet;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.decoration.TextDecoration;
import com.jonathanschram.vttconverter.lib.vtt.css.types.Color;

public class TextDecorationShorthand implements CssShorthand<TextDecoration, TextDecorationShorthand> {

    public static class Builder {
        public static Builder createUnset() {
            Builder builder = new Builder();
            builder.color = new CssDecorationColor();
            builder.line = new CssDecorationLine();
            builder.style = new CssDecorationStyle();
            return builder;
        }

        public static Builder createUpdate() {
            return new Builder();
        }

        private CssProperty<Color> color = null;
        private CssProperty<LineTypeSet> line = null;
        private CssProperty<LineStyle> style = null;

        public TextDecorationShorthand build() {
            return new TextDecorationShorthand(color, line, style);
        }

        public Builder setColor(Color color) {
            this.color = new ConcreteProperty<Color>(color);
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

        public Builder setLine(LineTypeSet values) {
            this.line = new ConcreteProperty<>(values);
            return this;
        }

        public Builder setStyle(CssDecorationStyle style) {
            this.style = style;
            return this;
        }

        public Builder setStyle(LineStyle style) {
            this.style = new ConcreteProperty<LineStyle>(style);
            return this;
        }
    }

    private CssProperty<Color> color;
    private CssProperty<LineTypeSet> line;
    private CssProperty<LineStyle> style;

    public TextDecorationShorthand() {
        this(new CssDecorationColor(), new CssDecorationLine(), new CssDecorationStyle());
    }

    public TextDecorationShorthand(Builder builder) {
        this.color = builder.color;
        this.line = builder.line;
        this.style = builder.style;
    }

    public TextDecorationShorthand(
            CssProperty<Color> color,
            CssProperty<LineTypeSet> line, CssProperty<LineStyle> style) {
        this.color = color;
        this.line = line;
        this.style = style;
    }

    @Override
    public void cascadeFrom(TextDecorationShorthand parent) throws UnresolvedPropertyException, UncomputedValueException {
        color = CssProperty.cascade(parent.color, color);
        line = CssProperty.cascade(parent.line, line);
        style = CssProperty.cascade(parent.style, style);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TextDecorationShorthand other = (TextDecorationShorthand) obj;
        return Objects.equals(color, other.color) && Objects.equals(line, other.line)
                && Objects.equals(style, other.style);
    }

    @Override
    public TextDecoration getInitialValue() {
        return new TextDecoration(CssDecorationColor.INITIAL_VALUE, CssDecorationLine.INITIAL_VALUE,
                CssDecorationStyle.INITIAL_VALUE);
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
    public void updateStyle(TextDecorationShorthand newValue) {
        if (newValue == null) {
            return;
        }

        color = CssShorthand.newPropertyIfNotNull(color, newValue.color);
        line = CssShorthand.newPropertyIfNotNull(line, newValue.line);
        style = CssShorthand.newPropertyIfNotNull(style, newValue.style);
    }

}
