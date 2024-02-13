package com.jonathanschram.vttconverter.lib.vtt.css.cascade.font;

import com.jonathanschram.vttconverter.lib.vtt.css.GlobalValue;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingProperty;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.FontStretch;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.FontStretchKeyword;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.KeywordFontStretch;

public class CssFontStretch extends CascadingProperty<FontStretch> {
    public static final FontStretch INITIAL_VALUE = new KeywordFontStretch(FontStretchKeyword.NORMAL);

    public CssFontStretch() {
    }

    public CssFontStretch(GlobalValue currentValue) {
        super(currentValue);
    }

    @Override
    public FontStretch getInitialValue() {
        return INITIAL_VALUE;
    }

    @Override
    public boolean isInherited() {
        return true;
    }

    @Override
    public String toString() {
        return "CssFontStretch [globalValue=" + globalValue + "]";
    }
}
