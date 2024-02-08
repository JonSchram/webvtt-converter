package com.jonathanschram.vttconverter.lib.vtt.css.cascade.font;

import com.jonathanschram.vttconverter.lib.vtt.css.GlobalValue;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.FontSize;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.FontSizeKeyword;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.KeywordFontSize;

public class CssFontSize extends CascadingStyle<FontSize> {

    public CssFontSize() {
    }

    public CssFontSize(FontSize currentValue) {
        super(currentValue);
    }

    public CssFontSize(GlobalValue currentValue) {
        super(currentValue);
    }

    @Override
    public FontSize getInitialValue() {
        return new KeywordFontSize(FontSizeKeyword.MEDIUM);
    }

    @Override
    public boolean isInherited() {
        return true;
    }

    @Override
    public String toString() {
        return "CssFontSize [globalValue=" + globalValue + ", wrappedValue=" + wrappedValue + "]";
    }

}
