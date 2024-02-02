package com.jonathanschram.vttconverter.lib.vtt.css.cascade.font;

import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.FontFamily;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.GenericFamilyName;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.GenericFontFamily;

public class CssFontFamily extends CascadingStyle<FontFamily> {

    public CssFontFamily() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public FontFamily getInitialValue() {
        // This value depends on user agent (this program).
        // Arbitrarily chosen, sources indicate sans-serif is easier to read on screens.
        return new GenericFontFamily(GenericFamilyName.SANS_SERIF);
    }
}
