package com.jonathanschram.vttconverter.lib.vtt.css.cascade.font;

import com.jonathanschram.vttconverter.lib.vtt.css.GlobalValue;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.FontVariant;

public class CssFontVariant extends CascadingStyle<FontVariant> {

    public CssFontVariant() {
    }

    public CssFontVariant(FontVariant currentValue) {
        super(currentValue);
    }

    public CssFontVariant(GlobalValue currentValue) {
        super(currentValue);
    }

    @Override
    public FontVariant getInitialValue() {
        return FontVariant.NORMAL;
    }

    @Override
    public String toString() {
        return "CssFontVariant [globalValue=" + globalValue + ", wrappedValue=" + wrappedValue + "]";
    }

}
