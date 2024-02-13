package com.jonathanschram.vttconverter.lib.vtt.css.cascade.background;

import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingProperty;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.background.BackgroundAttachment;

public class CssBackgroundAttachment extends CascadingProperty<BackgroundAttachment> {
    public static final BackgroundAttachment INITIAL_VALUE = BackgroundAttachment.SCROLL;

    public CssBackgroundAttachment() {
    }

    @Override
    public BackgroundAttachment getInitialValue() {
        return INITIAL_VALUE;
    }

    @Override
    public boolean isInherited() {
        return false;
    }

    @Override
    public String toString() {
        return "CssBackgroundAttachment [globalValue=" + globalValue + "]";
    }

}
