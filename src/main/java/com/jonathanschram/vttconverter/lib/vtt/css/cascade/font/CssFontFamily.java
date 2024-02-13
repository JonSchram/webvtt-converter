package com.jonathanschram.vttconverter.lib.vtt.css.cascade.font;

import java.util.List;

import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingProperty;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.FontFamily;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.GenericFamilyName;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.GenericFontFamily;

public class CssFontFamily extends CascadingProperty<List<FontFamily>> {
    public static final List<FontFamily> INITIAL_VALUE = List.of(new GenericFontFamily(GenericFamilyName.SANS_SERIF));

    public CssFontFamily() {
    }

    @Override
    public List<FontFamily> getInitialValue() {
        // This value depends on user agent (this program).
        // Arbitrarily chosen, sources indicate sans-serif is easier to read on screens.
        return INITIAL_VALUE;
    }

    @Override
    public boolean isInherited() {
        return true;
    }

    @Override
    public String toString() {
        return "CssFontFamily [globalValue=" + globalValue + "]";
    }
}
