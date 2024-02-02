package com.jonathanschram.vttconverter.lib.vtt.css.cascade.font;

import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.FontVariant;

public class CssFontVariant extends CascadingStyle<FontVariant> {

    public CssFontVariant() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public FontVariant getInitialValue() {
        return FontVariant.NORMAL;
    }

}
