package com.jonathanschram.vttconverter.lib.vtt.css.cascade.font;

import com.jonathanschram.vttconverter.lib.vtt.css.CssShorthand;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.Font;

public class CssFont implements CssShorthand<Font, CssFont> {

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
    public Font getInitialValue() {
        return new Font(family.getInitialValue(), size.getInitialValue(), stretch.getInitialValue(),
                style.getInitialValue(), variant.getInitialValue(), weight.getInitialValue(),
                lineHeight.getInitialValue());
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

}
