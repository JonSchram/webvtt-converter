package com.jonathanschram.vttconverter.lib.vtt.css.cascade.background;

import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.background.BackgroundOrigin;

public class CssBackgroundOrigin extends CascadingStyle<BackgroundOrigin> {

    public CssBackgroundOrigin() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public BackgroundOrigin getInitialValue() {
        return BackgroundOrigin.PADDING_BOX;
    }

}
