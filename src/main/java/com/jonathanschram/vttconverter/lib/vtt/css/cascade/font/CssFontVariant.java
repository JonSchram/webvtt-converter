package com.jonathanschram.vttconverter.lib.vtt.css.cascade.font;

import com.jonathanschram.vttconverter.lib.vtt.css.GlobalValue;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingProperty;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.FontVariant;

public class CssFontVariant extends CascadingProperty<FontVariant> {
    public static final FontVariant INITIAL_VALUE = FontVariant.NORMAL;

    public CssFontVariant() {
    }

    public CssFontVariant(GlobalValue currentValue) {
        super(currentValue);
    }

    @Override
    public FontVariant getInitialValue() {
        return INITIAL_VALUE;
    }

    @Override
    public boolean isInherited() {
        return true;
    }

    @Override
    public String toString() {
        return "CssFontVariant [globalValue=" + globalValue + "]";
    }

}
