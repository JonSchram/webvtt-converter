package com.jonathanschram.vttconverter.lib.vtt.css.cascade.font;

import com.jonathanschram.vttconverter.lib.vtt.css.GlobalValue;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.LineHeight;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.NormalLineHeight;

public class CssLineHeight extends CascadingStyle<LineHeight> {

    public CssLineHeight() {
    }

    public CssLineHeight(GlobalValue currentValue) {
        super(currentValue);
    }

    public CssLineHeight(LineHeight currentValue) {
        super(currentValue);
    }

    @Override
    public LineHeight getInitialValue() {
        return NormalLineHeight.getInstance();
    }

    @Override
    public boolean isInherited() {
        return true;
    }

    @Override
    public String toString() {
        return "CssLineHeight [globalValue=" + globalValue + ", wrappedValue=" + wrappedValue + "]";
    }
}
