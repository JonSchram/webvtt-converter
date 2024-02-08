package com.jonathanschram.vttconverter.lib.vtt.css.cascade.background;

import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.background.BackgroundImage;

public class CssBackgroundImage extends CascadingStyle<BackgroundImage> {
    public static final BackgroundImage INITIAL_VALUE = null;

    public CssBackgroundImage() {
    }

    public CssBackgroundImage(BackgroundImage image) {
        super(image);
    }

    @Override
    public BackgroundImage getInitialValue() {
        // TODO Might want a "none" keyword instead.
        return INITIAL_VALUE;
    }

    @Override
    public String toString() {
        return "CssBackgroundImage [globalValue=" + globalValue + ", wrappedValue=" + wrappedValue + "]";
    }

}
