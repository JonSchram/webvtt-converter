package com.jonathanschram.vttconverter.lib.vtt.css.cascade.background;

import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingProperty;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.background.BackgroundImage;

public class CssBackgroundImage extends CascadingProperty<BackgroundImage> {
    public static final BackgroundImage INITIAL_VALUE = null;

    public CssBackgroundImage() {
    }

    @Override
    public BackgroundImage getInitialValue() {
        // TODO Might want a "none" keyword instead.
        return INITIAL_VALUE;
    }

    @Override
    public boolean isInherited() {
        return false;
    }

    @Override
    public String toString() {
        return "CssBackgroundImage [globalValue=" + globalValue + "]";
    }

}
