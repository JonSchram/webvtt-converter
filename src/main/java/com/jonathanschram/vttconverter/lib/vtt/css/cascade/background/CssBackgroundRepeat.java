package com.jonathanschram.vttconverter.lib.vtt.css.cascade.background;

import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.background.BackgroundRepeat;

public class CssBackgroundRepeat extends CascadingStyle<BackgroundRepeat> {
    public static final BackgroundRepeat INITIAL_VALUE = BackgroundRepeat.REPEAT;

    public CssBackgroundRepeat() {
    }

    @Override
    public BackgroundRepeat getInitialValue() {
        return BackgroundRepeat.REPEAT;
    }

}
