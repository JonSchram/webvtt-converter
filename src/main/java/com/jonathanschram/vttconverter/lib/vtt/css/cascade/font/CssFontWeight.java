package com.jonathanschram.vttconverter.lib.vtt.css.cascade.font;

import com.jonathanschram.vttconverter.lib.vtt.css.GlobalValue;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingProperty;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.FontWeight;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.FontWeightKeyword;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.KeywordFontWeight;

public class CssFontWeight extends CascadingProperty<FontWeight> {
    public static final FontWeight INITIAL_VALUE = new KeywordFontWeight(FontWeightKeyword.NORMAL);

    public CssFontWeight() {
    }

    public CssFontWeight(GlobalValue currentValue) {
        super(currentValue);
    }

    @Override
    public FontWeight getInitialValue() {
        return INITIAL_VALUE;
    }

    @Override
    public boolean isInherited() {
        return true;
    }

    @Override
    public String toString() {
        return "CssFontWeight [globalValue=" + globalValue + "]";
    }
}
