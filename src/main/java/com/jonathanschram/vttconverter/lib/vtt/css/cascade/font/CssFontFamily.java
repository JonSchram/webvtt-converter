package com.jonathanschram.vttconverter.lib.vtt.css.cascade.font;

import java.util.List;

import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.FontFamily;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.GenericFamilyName;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.GenericFontFamily;

public class CssFontFamily extends CascadingStyle<List<FontFamily>> {

    public CssFontFamily() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public List<FontFamily> getInitialValue() {
        // This value depends on user agent (this program).
        // Arbitrarily chosen, sources indicate sans-serif is easier to read on screens.
        return List.of(new GenericFontFamily(GenericFamilyName.SANS_SERIF));
    }
}
