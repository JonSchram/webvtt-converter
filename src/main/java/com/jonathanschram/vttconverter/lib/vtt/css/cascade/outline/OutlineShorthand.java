package com.jonathanschram.vttconverter.lib.vtt.css.cascade.outline;

import java.util.Objects;

import com.jonathanschram.vttconverter.lib.vtt.css.CssProperty;
import com.jonathanschram.vttconverter.lib.vtt.css.CssShorthand;
import com.jonathanschram.vttconverter.lib.vtt.css.RenderParameters;
import com.jonathanschram.vttconverter.lib.vtt.css.UncomputedValueException;
import com.jonathanschram.vttconverter.lib.vtt.css.UnresolvedPropertyException;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadeValueReference;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.ConcreteProperty;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.Font;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.outline.Outline;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.outline.OutlineStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.outline.OutlineWidth;
import com.jonathanschram.vttconverter.lib.vtt.css.types.Color;

public class OutlineShorthand implements CssShorthand<Outline, OutlineShorthand> {

    public static class Builder {

        public static Builder createUnset() {
            Builder b = new Builder();
            b.color = new CssOutlineColor();
            b.style = new CssOutlineStyle();
            b.width = new CssOutlineWidth();
            return b;
        }

        public static Builder createUpdate() {
            return new Builder();
        }

        private CssProperty<Color> color = null;
        private CssProperty<OutlineStyle> style = null;
        private CssProperty<OutlineWidth> width = null;

        public OutlineShorthand build() {
            return new OutlineShorthand(this);
        }

        public Builder setColor(Color color) {
            this.color = new ConcreteProperty<Color>(color);
            return this;
        }

        public Builder setColor(CssOutlineColor color) {
            this.color = color;
            return this;
        }

        public Builder setStyle(CssOutlineStyle style) {
            this.style = style;
            return this;
        }

        public Builder setStyle(OutlineStyle style) {
            this.style = new ConcreteProperty<>(style);
            return this;
        }

        public Builder setWidth(CssOutlineWidth width) {
            this.width = width;
            return this;
        }

        public Builder setWidth(OutlineWidth width) {
            this.width = new ConcreteProperty<>(width);
            return this;
        }
    }

    private CssProperty<Color> color;
    private CssProperty<OutlineStyle> style;
    private CssProperty<OutlineWidth> width;

    public OutlineShorthand() {
        this(new CssOutlineColor(), new CssOutlineStyle(), new CssOutlineWidth());
    }

    public OutlineShorthand(Builder builder) {
        this.color = builder.color;
        this.style = builder.style;
        this.width = builder.width;
    }

    public OutlineShorthand(Color color, OutlineStyle style, OutlineWidth width) {
        this(new ConcreteProperty<>(color), new ConcreteProperty<>(style), new ConcreteProperty<>(width));
    }

    public OutlineShorthand(CssProperty<Color> color, CssProperty<OutlineStyle> style,
            CssProperty<OutlineWidth> width) {
        this.color = color;
        this.style = style;
        this.width = width;
    }

    @Override
    public void cascadeFrom(OutlineShorthand parent, CascadeValueReference<Color> colorReference,
            CascadeValueReference<Font> fontReference, RenderParameters parameters)
            throws UnresolvedPropertyException, UncomputedValueException {
        color = CssProperty.cascade(parent.color, color, colorReference, fontReference, parameters);
        style = CssProperty.cascade(parent.style, style, colorReference, fontReference, parameters);
        width = CssProperty.cascade(parent.width, width, colorReference, fontReference, parameters);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OutlineShorthand other = (OutlineShorthand) obj;
        return Objects.equals(color, other.color) && Objects.equals(style, other.style)
                && Objects.equals(width, other.width);
    }

    @Override
    public Outline getInitialValue() {
        return new Outline(CssOutlineColor.INITIAL_VALUE, CssOutlineStyle.INITIAL_VALUE, CssOutlineWidth.INITIAL_VALUE);
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
    public void updateStyle(OutlineShorthand newValue) {
        if (newValue == null) {
            return;
        }

        color = CssShorthand.newPropertyIfNotNull(color, newValue.color);
        style = CssShorthand.newPropertyIfNotNull(style, newValue.style);
        width = CssShorthand.newPropertyIfNotNull(width, newValue.width);
    }
}
