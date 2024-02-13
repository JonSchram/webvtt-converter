package com.jonathanschram.vttconverter.lib.vtt.css.cascade.font;

import com.jonathanschram.vttconverter.lib.vtt.css.GlobalValue;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingProperty;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.FontSize;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.FontSizeKeyword;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.KeywordFontSize;

public class CssFontSize extends CascadingProperty<FontSize> {
    public static final FontSize INITIAL_VALUE = new KeywordFontSize(FontSizeKeyword.MEDIUM);

    public CssFontSize() {
    }

    public CssFontSize(GlobalValue currentValue) {
        super(currentValue);
    }

    @Override
    public FontSize getInitialValue() {
        return INITIAL_VALUE;
    }

    @Override
    public boolean isInherited() {
        return true;
    }

    @Override
    public String toString() {
        return "CssFontSize [globalValue=" + globalValue + "]";
    }

}
