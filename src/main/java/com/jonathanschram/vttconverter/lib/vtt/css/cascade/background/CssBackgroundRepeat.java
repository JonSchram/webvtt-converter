package com.jonathanschram.vttconverter.lib.vtt.css.cascade.background;

import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.background.BackgroundRepeat;

public class CssBackgroundRepeat extends CascadingStyle<BackgroundRepeat> {

    public CssBackgroundRepeat() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public BackgroundRepeat getInitialValue() {
        return BackgroundRepeat.REPEAT;
    }

}
