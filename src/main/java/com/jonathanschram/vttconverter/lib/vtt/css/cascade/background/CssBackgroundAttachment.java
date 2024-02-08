package com.jonathanschram.vttconverter.lib.vtt.css.cascade.background;

import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.background.BackgroundAttachment;

public class CssBackgroundAttachment extends CascadingStyle<BackgroundAttachment> {
    public static final BackgroundAttachment INITIAL_VALUE = BackgroundAttachment.SCROLL;

    public CssBackgroundAttachment() {
    }

    public CssBackgroundAttachment(BackgroundAttachment attachment) {
        super(attachment);
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
        return "CssBackgroundAttachment [globalValue=" + globalValue + ", wrappedValue=" + wrappedValue + "]";
    }

}
