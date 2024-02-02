package com.jonathanschram.vttconverter.lib.vtt.css.cascade;

import com.jonathanschram.vttconverter.lib.vtt.css.properties.Opacity;

public class CssOpacity extends CascadingStyle<Opacity> {

    public CssOpacity() {
    }

    public CssOpacity(double value) {
    }

    @Override
    public Opacity getInitialValue() {
        return new Opacity(1);
    }

}
