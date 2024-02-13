package com.jonathanschram.vttconverter.lib.vtt.css.cascade.font;

import com.jonathanschram.vttconverter.lib.vtt.css.GlobalValue;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingProperty;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.FontStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.FontStyleKeyword;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.KeywordFontStyle;

public class CssFontStyle extends CascadingProperty<FontStyle> {
    public static final FontStyle INITIAL_VALUE = new KeywordFontStyle(FontStyleKeyword.NORMAL);

    public CssFontStyle() {
    }

    public CssFontStyle(GlobalValue currentValue) {
        super(currentValue);
    }

    @Override
    public FontStyle getInitialValue() {
        return INITIAL_VALUE;
    }

    @Override
    public boolean isInherited() {
        return true;
    }

    @Override
    public String toString() {
        return "CssFontStyle [globalValue=" + globalValue + "]";
    }

}
