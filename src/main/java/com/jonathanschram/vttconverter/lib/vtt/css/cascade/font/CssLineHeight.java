package com.jonathanschram.vttconverter.lib.vtt.css.cascade.font;

import com.jonathanschram.vttconverter.lib.vtt.css.GlobalValue;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingProperty;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.LineHeight;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.NormalLineHeight;

public class CssLineHeight extends CascadingProperty<LineHeight> {
    public static final LineHeight INITIAL_VALUE = NormalLineHeight.getInstance();

    public CssLineHeight() {
    }

    public CssLineHeight(GlobalValue currentValue) {
        super(currentValue);
    }

    @Override
    public LineHeight getInitialValue() {
        return INITIAL_VALUE;
    }

    @Override
    public boolean isInherited() {
        return true;
    }

    @Override
    public String toString() {
        return "CssLineHeight [globalValue=" + globalValue + "]";
    }
}
