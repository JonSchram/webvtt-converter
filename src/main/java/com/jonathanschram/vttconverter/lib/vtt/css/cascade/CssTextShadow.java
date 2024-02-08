package com.jonathanschram.vttconverter.lib.vtt.css.cascade;

import com.jonathanschram.vttconverter.lib.vtt.css.properties.TextShadow;

public class CssTextShadow extends CascadingStyle<TextShadow> {

    public CssTextShadow() {
    }

    @Override
    public TextShadow getInitialValue() {
        // Default is no shadow. Might want to revisit in the future if there should be
        // a different representation for this other than null.
        return null;
    }

    @Override
    public boolean isInherited() {
        return true;
    }

    @Override
    public String toString() {
        return "CssTextShadow [globalValue=" + globalValue + ", wrappedValue=" + wrappedValue + "]";
    }

}
