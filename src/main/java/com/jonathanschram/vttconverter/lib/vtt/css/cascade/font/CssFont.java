package com.jonathanschram.vttconverter.lib.vtt.css.cascade.font;

import java.util.List;
import java.util.Objects;

import com.jonathanschram.vttconverter.lib.vtt.css.CssShorthand;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.Font;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.FontFamily;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.FontSize;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.FontStretch;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.FontStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.FontVariant;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.FontWeight;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.LineHeight;

public class CssFont implements CssShorthand<Font, CssFont> {

    public static class Builder {
        private CssFontFamily family = new CssFontFamily();
        private CssFontSize size = new CssFontSize();
        private CssFontStretch stretch = new CssFontStretch();
        private CssFontStyle style = new CssFontStyle();
        private CssFontVariant variant = new CssFontVariant();
        private CssFontWeight weight = new CssFontWeight();
        private CssLineHeight lineHeight = new CssLineHeight();

        public CssFont build() {
            return new CssFont(family, size, stretch, style, variant, weight, lineHeight);
        }

        public Builder setFamily(CssFontFamily family) {
            this.family = family;
            return this;
        }

        public Builder setFamily(List<FontFamily> values) {
            this.family = new CssFontFamily(values);
            return this;
        }

        public Builder setLineHeight(CssLineHeight lineHeight) {
            this.lineHeight = lineHeight;
            return this;
        }

        public Builder setLineHeight(LineHeight height) {
            this.lineHeight = new CssLineHeight(height);
            return this;
        }

        public Builder setSize(CssFontSize size) {
            this.size = size;
            return this;
        }

        public Builder setSize(FontSize size) {
            this.size = new CssFontSize(size);
            return this;
        }

        public Builder setStretch(CssFontStretch stretch) {
            this.stretch = stretch;
            return this;
        }

        public Builder setStretch(FontStretch stretch) {
            this.stretch = new CssFontStretch(stretch);
            return this;
        }

        public Builder setStyle(CssFontStyle style) {
            this.style = style;
            return this;
        }

        public Builder setStyle(FontStyle style) {
            this.style = new CssFontStyle(style);
            return this;
        }

        public Builder setVariant(CssFontVariant variant) {
            this.variant = variant;
            return this;
        }

        public Builder setVariant(FontVariant variant) {
            this.variant = new CssFontVariant(variant);
            return this;
        }

        public Builder setWeight(CssFontWeight weight) {
            this.weight = weight;
            return this;
        }

        public Builder setWeight(FontWeight weight) {
            this.weight = new CssFontWeight(weight);
            return this;
        }
    }

    private CssFontFamily family;
    private CssFontSize size;
    private CssFontStretch stretch;
    private CssFontStyle style;
    private CssFontVariant variant;
    private CssFontWeight weight;
    private CssLineHeight lineHeight;

    public CssFont() {
        this(new CssFontFamily(), new CssFontSize(), new CssFontStretch(), new CssFontStyle(), new CssFontVariant(),
                new CssFontWeight(), new CssLineHeight());
    }

    public CssFont(CssFontFamily family, CssFontSize size, CssFontStretch stretch,
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
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CssFont other = (CssFont) obj;
        return Objects.equals(family, other.family) && Objects.equals(lineHeight, other.lineHeight)
                && Objects.equals(size, other.size) && Objects.equals(stretch, other.stretch)
                && Objects.equals(style, other.style) && Objects.equals(variant, other.variant)
                && Objects.equals(weight, other.weight);
    }

    @Override
    public Font getInitialValue() {
        return new Font(family.getInitialValue(), size.getInitialValue(), stretch.getInitialValue(),
                style.getInitialValue(), variant.getInitialValue(), weight.getInitialValue(),
                lineHeight.getInitialValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(family, lineHeight, size, stretch, style, variant, weight);
    }

    @Override
    public void updateStyle(CssFont newValue) {
        family.updateStyle(newValue.family);
        size.updateStyle(newValue.size);
        stretch.updateStyle(newValue.stretch);
        style.updateStyle(newValue.style);
        variant.updateStyle(newValue.variant);
        weight.updateStyle(newValue.weight);
        lineHeight.updateStyle(newValue.lineHeight);
    }

    @Override
    public String toString() {
        return "CssFont [family=" + family + ", size=" + size + ", stretch=" + stretch + ", style=" + style
                + ", variant=" + variant + ", weight=" + weight + ", lineHeight=" + lineHeight + "]";
    }

}
