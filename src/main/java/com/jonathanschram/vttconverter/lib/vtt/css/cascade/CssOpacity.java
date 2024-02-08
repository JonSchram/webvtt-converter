package com.jonathanschram.vttconverter.lib.vtt.css.cascade;

import com.jonathanschram.vttconverter.lib.vtt.css.properties.Opacity;

public class CssOpacity extends CascadingStyle<Opacity> {
    public static final Opacity INITIAL_VALUE = new Opacity(1);

    public CssOpacity() {
    }

    @Override
    public Opacity getInitialValue() {
        return INITIAL_VALUE;
    }

    @Override
    public String toString() {
        return "CssOpacity [globalValue=" + globalValue + ", wrappedValue=" + wrappedValue + "]";
    }

}
