package com.jonathanschram.vttconverter.lib.vtt.css.cascade.font;

import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.FontStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.FontStyleKeyword;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.KeywordFontStyle;

public class CssFontStyle extends CascadingStyle<FontStyle> {

    public CssFontStyle() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public FontStyle getInitialValue() {
        return new KeywordFontStyle(FontStyleKeyword.NORMAL);
    }

}
