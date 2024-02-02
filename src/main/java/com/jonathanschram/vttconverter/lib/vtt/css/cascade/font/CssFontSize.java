package com.jonathanschram.vttconverter.lib.vtt.css.cascade.font;

import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.FontSize;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.FontSizeKeyword;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.KeywordFontSize;

public class CssFontSize extends CascadingStyle<FontSize> {

    public CssFontSize() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public FontSize getInitialValue() {
        return new KeywordFontSize(FontSizeKeyword.MEDIUM);
    }

}
