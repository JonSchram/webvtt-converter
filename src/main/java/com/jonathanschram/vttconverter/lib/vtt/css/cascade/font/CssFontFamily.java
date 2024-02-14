package com.jonathanschram.vttconverter.lib.vtt.css.cascade.font;

import com.jonathanschram.vttconverter.lib.vtt.css.GlobalValue;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingProperty;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.FontFamilyList;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.GenericFamilyName;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.GenericFontFamily;

public class CssFontFamily extends CascadingProperty<FontFamilyList> {
    public static final FontFamilyList INITIAL_VALUE = new FontFamilyList(
            new GenericFontFamily(GenericFamilyName.SANS_SERIF));

    public CssFontFamily() {
    }

    public CssFontFamily(GlobalValue currentValue) {
        super(currentValue);
    }

    @Override
    public FontFamilyList getInitialValue() {
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
