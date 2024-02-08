package com.jonathanschram.vttconverter.lib.vtt.css.cascade.font;

import com.jonathanschram.vttconverter.lib.vtt.css.GlobalValue;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.FontStretch;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.FontStretchKeyword;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.KeywordFontStretch;

public class CssFontStretch extends CascadingStyle<FontStretch> {

    public CssFontStretch() {
    }

    public CssFontStretch(FontStretch currentValue) {
        super(currentValue);
    }

    public CssFontStretch(GlobalValue currentValue) {
        super(currentValue);
    }

    @Override
    public FontStretch getInitialValue() {
        return new KeywordFontStretch(FontStretchKeyword.NORMAL);
    }

    @Override
    public String toString() {
        return "CssFontStretch [globalValue=" + globalValue + ", wrappedValue=" + wrappedValue + "]";
    }
}
