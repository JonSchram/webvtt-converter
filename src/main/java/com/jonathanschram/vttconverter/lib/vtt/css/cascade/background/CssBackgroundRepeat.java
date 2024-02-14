package com.jonathanschram.vttconverter.lib.vtt.css.cascade.background;

import com.jonathanschram.vttconverter.lib.vtt.css.GlobalValue;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingProperty;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.background.BackgroundRepeat;

public class CssBackgroundRepeat extends CascadingProperty<BackgroundRepeat> {
    public static final BackgroundRepeat INITIAL_VALUE = BackgroundRepeat.REPEAT;

    public CssBackgroundRepeat() {
    }

    public CssBackgroundRepeat(GlobalValue currentValue) {
        super(currentValue);
    }

    @Override
    public BackgroundRepeat getInitialValue() {
        return BackgroundRepeat.REPEAT;
    }

    @Override
    public boolean isInherited() {
        return false;
    }

    @Override
    public String toString() {
        return "CssBackgroundRepeat [globalValue=" + globalValue + "]";
    }

}
