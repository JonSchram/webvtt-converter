package com.jonathanschram.vttconverter.lib.vtt.css.cascade.font;

import com.jonathanschram.vttconverter.lib.vtt.css.CssProperty;
import com.jonathanschram.vttconverter.lib.vtt.css.CssShorthand;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.Font;

public class CssFont implements CssShorthand<Font, CssProperty<Font>> {

    private CssFontFamily family;
    private CssFontSize size;
    private CssFontStretch stretch;
    private CssFontStyle style;
    private CssFontVariant variant;
    private CssFontWeight weight;
    private CssLineHeight lineHeight;

    public CssFont() {
        family = new CssFontFamily();
        size = new CssFontSize();
        stretch = new CssFontStretch();
        style = new CssFontStyle();
        variant = new CssFontVariant();
        weight = new CssFontWeight();
        lineHeight = new CssLineHeight();
    }

    @Override
    public Font getInitialValue() {
        return new Font(family.getInitialValue(), size.getInitialValue(), stretch.getInitialValue(),
                style.getInitialValue(), variant.getInitialValue(), weight.getInitialValue(),
                lineHeight.getInitialValue());
    }

}
