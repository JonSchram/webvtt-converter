package com.jonathanschram.vttconverter.lib.vtt.css.cascade.font;

import java.util.Objects;

import com.jonathanschram.vttconverter.lib.vtt.css.CssProperty;
import com.jonathanschram.vttconverter.lib.vtt.css.CssShorthand;
import com.jonathanschram.vttconverter.lib.vtt.css.RenderParameters;
import com.jonathanschram.vttconverter.lib.vtt.css.UncomputedValueException;
import com.jonathanschram.vttconverter.lib.vtt.css.UnresolvedPropertyException;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadeValueReference;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.ConcreteProperty;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.Font;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.FontFamilyList;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.FontSize;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.FontStretch;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.FontStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.FontVariant;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.FontWeight;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.LineHeight;
import com.jonathanschram.vttconverter.lib.vtt.css.types.Color;

public class FontShorthand implements CssShorthand<Font, FontShorthand> {

    public static class Builder {
        public static Builder createUnset() {
            Builder builder = new Builder();
            builder.family = new CssFontFamily();
            builder.size = new CssFontSize();
            builder.stretch = new CssFontStretch();
            builder.style = new CssFontStyle();
            builder.variant = new CssFontVariant();
            builder.weight = new CssFontWeight();
            builder.lineHeight = new CssLineHeight();
            return builder;
        }

        public static Builder createUpdate() {
            return new Builder();
        }

        private CssProperty<FontFamilyList> family = null;
        private CssProperty<FontSize> size = null;
        private CssProperty<FontStretch> stretch = null;
        private CssProperty<FontStyle> style = null;
        private CssProperty<FontVariant> variant = null;
        private CssProperty<FontWeight> weight = null;
        private CssProperty<LineHeight> lineHeight = null;

        public FontShorthand build() {
            return new FontShorthand(this);
        }

        public Builder setFamily(CssFontFamily family) {
            this.family = family;
            return this;
        }

        public Builder setFamily(FontFamilyList values) {
            this.family = new ConcreteProperty<FontFamilyList>(values);
            return this;
        }

        public Builder setLineHeight(CssLineHeight lineHeight) {
            this.lineHeight = lineHeight;
            return this;
        }

        public Builder setLineHeight(LineHeight height) {
            this.lineHeight = new ConcreteProperty<LineHeight>(height);
            return this;
        }

        public Builder setSize(CssFontSize size) {
            this.size = size;
            return this;
        }

        public Builder setSize(FontSize size) {
            this.size = new ConcreteProperty<FontSize>(size);
            return this;
        }

        public Builder setStretch(CssFontStretch stretch) {
            this.stretch = stretch;
            return this;
        }

        public Builder setStretch(FontStretch stretch) {
            this.stretch = new ConcreteProperty<FontStretch>(stretch);
            return this;
        }

        public Builder setStyle(CssFontStyle style) {
            this.style = style;
            return this;
        }

        public Builder setStyle(FontStyle style) {
            this.style = new ConcreteProperty<FontStyle>(style);
            return this;
        }

        public Builder setVariant(CssFontVariant variant) {
            this.variant = variant;
            return this;
        }

        public Builder setVariant(FontVariant variant) {
            this.variant = new ConcreteProperty<FontVariant>(variant);
            return this;
        }

        // TODO: Consider adding builder methods for concrete properties. They may not
        // be needed, because they would accomplish the same thing as the value-based
        // ones.
        public Builder setWeight(CssFontWeight weight) {
            this.weight = weight;
            return this;
        }

        public Builder setWeight(FontWeight weight) {
            this.weight = new ConcreteProperty<FontWeight>(weight);
            return this;
        }
    }

    private CssProperty<FontFamilyList> family;
    private CssProperty<FontSize> size;
    private CssProperty<FontStretch> stretch;
    private CssProperty<FontStyle> style;
    private CssProperty<FontVariant> variant;
    private CssProperty<FontWeight> weight;
    private CssProperty<LineHeight> lineHeight;

    public FontShorthand() {
        this(new CssFontFamily(), new CssFontSize(), new CssFontStretch(), new CssFontStyle(), new CssFontVariant(),
                new CssFontWeight(), new CssLineHeight());
    }

    public FontShorthand(Builder builder) {
        this.family = builder.family;
        this.size = builder.size;
        this.stretch = builder.stretch;
        this.style = builder.style;
        this.variant = builder.variant;
        this.weight = builder.weight;
        this.lineHeight = builder.lineHeight;
    }

    public FontShorthand(CssFontFamily family, CssFontSize size, CssFontStretch stretch,
            CssFontStyle style, CssFontVariant variant, CssFontWeight weight,
            CssLineHeight lineHeight) {
        this.family = family;
        this.size = size;
        this.stretch = stretch;
        this.style = style;
        this.variant = variant;
        this.weight = weight;
        this.lineHeight = lineHeight;
    }

    @Override
    public void cascadeFrom(FontShorthand parent, CascadeValueReference<Color> colorReference,
            CascadeValueReference<Font> fontReference, RenderParameters parameters)
            throws UnresolvedPropertyException, UncomputedValueException {
        family = CssProperty.cascade(parent.family, family, colorReference, fontReference, parameters);
        size = CssProperty.cascade(parent.size, size, colorReference, fontReference, parameters);
        stretch = CssProperty.cascade(parent.stretch, stretch, colorReference, fontReference, parameters);
        style = CssProperty.cascade(parent.style, style, colorReference, fontReference, parameters);
        variant = CssProperty.cascade(parent.variant, variant, colorReference, fontReference, parameters);
        weight = CssProperty.cascade(parent.weight, weight, colorReference, fontReference, parameters);
        lineHeight = CssProperty.cascade(parent.lineHeight, lineHeight, colorReference, fontReference, parameters);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FontShorthand other = (FontShorthand) obj;
        return Objects.equals(family, other.family) && Objects.equals(lineHeight, other.lineHeight)
                && Objects.equals(size, other.size) && Objects.equals(stretch, other.stretch)
                && Objects.equals(style, other.style) && Objects.equals(variant, other.variant)
                && Objects.equals(weight, other.weight);
    }

    public CssProperty<FontFamilyList> getFamily() {
        return family;
    }

    @Override
    public Font getInitialValue() {
        return new Font(CssFontFamily.INITIAL_VALUE, CssFontSize.INITIAL_VALUE, CssFontStretch.INITIAL_VALUE,
                CssFontStyle.INITIAL_VALUE, CssFontVariant.INITIAL_VALUE, CssFontWeight.INITIAL_VALUE,
                CssLineHeight.INITIAL_VALUE);
    }

    public CssProperty<LineHeight> getLineHeight() {
        return lineHeight;
    }

    public CssProperty<FontSize> getSize() {
        return size;
    }

    public CssProperty<FontStretch> getStretch() {
        return stretch;
    }

    public CssProperty<FontStyle> getStyle() {
        return style;
    }

    public CssProperty<FontVariant> getVariant() {
        return variant;
    }

    public CssProperty<FontWeight> getWeight() {
        return weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(family, lineHeight, size, stretch, style, variant, weight);
    }

    @Override
    public String toString() {
        return "CssFont [family=" + family + ", size=" + size + ", stretch=" + stretch + ", style=" + style
                + ", variant=" + variant + ", weight=" + weight + ", lineHeight=" + lineHeight + "]";
    }

    @Override
    public void updateStyle(FontShorthand newValue) {
        if (newValue == null) {
            return;
        }
        family = CssShorthand.newPropertyIfNotNull(family, newValue.family);
        size = CssShorthand.newPropertyIfNotNull(size, newValue.size);
        stretch = CssShorthand.newPropertyIfNotNull(stretch, newValue.stretch);
        style = CssShorthand.newPropertyIfNotNull(style, newValue.style);
        variant = CssShorthand.newPropertyIfNotNull(variant, newValue.variant);
        weight = CssShorthand.newPropertyIfNotNull(weight, newValue.weight);
        lineHeight = CssShorthand.newPropertyIfNotNull(lineHeight, newValue.lineHeight);
    }

}
