package com.jonathanschram.vttconverter.lib.vtt.css.cascade.background;

import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.background.BackgroundImage;

public class CssImage extends CascadingStyle<BackgroundImage> {

    public CssImage() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public BackgroundImage getInitialValue() {
        // TODO Might want a "none" keyword instead.
        return null;
    }

}
