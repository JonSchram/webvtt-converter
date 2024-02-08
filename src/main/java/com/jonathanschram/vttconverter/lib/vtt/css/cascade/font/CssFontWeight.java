package com.jonathanschram.vttconverter.lib.vtt.css.cascade.font;

import com.jonathanschram.vttconverter.lib.vtt.css.GlobalValue;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.FontWeight;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.FontWeightKeyword;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.KeywordFontWeight;

public class CssFontWeight extends CascadingStyle<FontWeight> {

    public CssFontWeight() {
    }

    public CssFontWeight(FontWeight currentValue) {
        super(currentValue);
    }

    public CssFontWeight(GlobalValue currentValue) {
        super(currentValue);
    }

    @Override
    public FontWeight getInitialValue() {
        return new KeywordFontWeight(FontWeightKeyword.NORMAL);
    }

    @Override
    public String toString() {
        return "CssFontWeight [globalValue=" + globalValue + ", wrappedValue=" + wrappedValue + "]";
    }
}
