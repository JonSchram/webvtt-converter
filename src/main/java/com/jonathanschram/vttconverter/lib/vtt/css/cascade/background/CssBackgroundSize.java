package com.jonathanschram.vttconverter.lib.vtt.css.cascade.background;

import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.background.size.AutoDimension;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.background.size.BackgroundSize;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.background.size.MeasuredSize;

public class CssBackgroundSize extends CascadingStyle<BackgroundSize> {
    public static final BackgroundSize INITIAL_VALUE = new MeasuredSize(AutoDimension.getInstance(),
            AutoDimension.getInstance());

    public CssBackgroundSize() {
    }

    @Override
    public BackgroundSize getInitialValue() {
        return INITIAL_VALUE;
    }

    @Override
    public String toString() {
        return "CssBackgroundSize [globalValue=" + globalValue + ", wrappedValue=" + wrappedValue + "]";
    }

}
