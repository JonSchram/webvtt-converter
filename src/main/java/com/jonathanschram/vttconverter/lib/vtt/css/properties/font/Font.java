package com.jonathanschram.vttconverter.lib.vtt.css.properties.font;

import java.util.List;

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

}
