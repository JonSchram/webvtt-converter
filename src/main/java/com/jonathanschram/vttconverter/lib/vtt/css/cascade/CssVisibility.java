package com.jonathanschram.vttconverter.lib.vtt.css.cascade;

import com.jonathanschram.vttconverter.lib.vtt.css.properties.Visibility;

public class CssVisibility extends CascadingProperty<Visibility> {

    @Override
    public Visibility getInitialValue() {
        return Visibility.VISIBLE;
    }

    @Override
    public boolean isInherited() {
        return true;
    }

    @Override
    public String toString() {
        return "CssVisibility [globalValue=" + globalValue + "]";
    }
}
