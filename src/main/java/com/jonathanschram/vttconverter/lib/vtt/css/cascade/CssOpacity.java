package com.jonathanschram.vttconverter.lib.vtt.css.cascade;

import com.jonathanschram.vttconverter.lib.vtt.css.GlobalValue;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.Opacity;

public class CssOpacity extends CascadingProperty<Opacity> {
    public static final Opacity INITIAL_VALUE = new Opacity(1);

    public CssOpacity() {
    }

    public CssOpacity(GlobalValue currentValue) {
        super(currentValue);
    }

    @Override
    public Opacity getInitialValue() {
        return INITIAL_VALUE;
    }

    @Override
    public boolean isInherited() {
        return false;
    }

    @Override
    public String toString() {
        return "CssOpacity [globalValue=" + globalValue + "]";
    }

}
