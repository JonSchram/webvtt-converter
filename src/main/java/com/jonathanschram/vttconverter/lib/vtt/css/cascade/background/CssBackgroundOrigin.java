package com.jonathanschram.vttconverter.lib.vtt.css.cascade.background;

import com.jonathanschram.vttconverter.lib.vtt.css.GlobalValue;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.background.BackgroundOrigin;

public class CssBackgroundOrigin extends CascadingStyle<BackgroundOrigin> {
    public static final BackgroundOrigin INITIAL_VALUE = BackgroundOrigin.PADDING_BOX;

    public CssBackgroundOrigin() {
    }

    public CssBackgroundOrigin(BackgroundOrigin currentValue) {
        super(currentValue);
    }

    public CssBackgroundOrigin(GlobalValue currentValue) {
        super(currentValue);
    }

    @Override
    public BackgroundOrigin getInitialValue() {
        return INITIAL_VALUE;
    }

    @Override
    public boolean isInherited() {
        return false;
    }

    @Override
    public String toString() {
        return "CssBackgroundOrigin [globalValue=" + globalValue + ", wrappedValue=" + wrappedValue + "]";
    }

}
