package com.jonathanschram.vttconverter.lib.vtt.css.properties.font;

import java.util.List;
import java.util.Objects;

public class Font {
    private final List<FontFamily> families;
    private final FontSize size;
    private final FontStretch stretch;
    private final FontStyle style;
    private final FontVariant variant;
    private final FontWeight weight;
    private final LineHeight lineHeight;

    public Font(List<FontFamily> families, FontSize size, FontStretch stretch, FontStyle style, FontVariant variant,
            FontWeight weight, LineHeight lineHeight) {
        super();
        this.families = families;
        this.size = size;
        this.stretch = stretch;
        this.style = style;
        this.variant = variant;
        this.weight = weight;
        this.lineHeight = lineHeight;
    }

    public List<FontFamily> getFamilies() {
        return families;
    }

    public FontSize getSize() {
        return size;
    }

    public FontStretch getStretch() {
        return stretch;
    }

    public FontStyle getStyle() {
        return style;
    }

    public FontVariant getVariant() {
        return variant;
    }

    public FontWeight getWeight() {
        return weight;
    }

    public LineHeight getLineHeight() {
        return lineHeight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(families, lineHeight, size, stretch, style, variant, weight);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Font other = (Font) obj;
        return Objects.equals(families, other.families) && Objects.equals(lineHeight, other.lineHeight)
                && Objects.equals(size, other.size) && Objects.equals(stretch, other.stretch)
                && Objects.equals(style, other.style) && variant == other.variant
                && Objects.equals(weight, other.weight);
    }

    @Override
    public String toString() {
        return "Font [families=" + families + ", size=" + size + ", stretch=" + stretch + ", style=" + style
                + ", variant=" + variant + ", weight=" + weight + ", lineHeight=" + lineHeight + "]";
    }

}
