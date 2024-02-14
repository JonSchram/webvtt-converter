package com.jonathanschram.vttconverter.lib.vtt.css.cascade.background;

import com.jonathanschram.vttconverter.lib.vtt.css.GlobalValue;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingProperty;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.background.BackgroundClip;

public class CssBackgroundClip extends CascadingProperty<BackgroundClip> {
    public static final BackgroundClip INITIAL_VALUE = BackgroundClip.BORDER_BOX;

    public CssBackgroundClip() {
    }

    public CssBackgroundClip(GlobalValue currentValue) {
        super(currentValue);
    }

    @Override
    public BackgroundClip getInitialValue() {
        return INITIAL_VALUE;
    }

    @Override
    public boolean isInherited() {
        return false;
    }

    @Override
    public String toString() {
        return "CssBackgroundClip [globalValue=" + globalValue + "]";
    }

}
