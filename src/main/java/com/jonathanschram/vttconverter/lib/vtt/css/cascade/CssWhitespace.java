package com.jonathanschram.vttconverter.lib.vtt.css.cascade;

import com.jonathanschram.vttconverter.lib.vtt.css.GlobalValue;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.WhiteSpace;

public class CssWhitespace extends CascadingProperty<WhiteSpace> {

    public CssWhitespace() {
    }

    public CssWhitespace(GlobalValue currentValue) {
        super(currentValue);
    }

    @Override
    public WhiteSpace getInitialValue() {
        return WhiteSpace.NORMAL;
    }

    @Override
    public boolean isInherited() {
        return true;
    }

    @Override
    public String toString() {
        return "CssWhitespace [globalValue=" + globalValue + "]";
    }

}
