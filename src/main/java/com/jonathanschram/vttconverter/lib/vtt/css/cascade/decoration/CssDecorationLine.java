package com.jonathanschram.vttconverter.lib.vtt.css.cascade.decoration;

import com.jonathanschram.vttconverter.lib.vtt.css.GlobalValue;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingProperty;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.decoration.LineType;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.decoration.LineTypeSet;

public class CssDecorationLine extends CascadingProperty<LineTypeSet> {
    public static final LineTypeSet INITIAL_VALUE = new LineTypeSet(LineType.NONE);

    public CssDecorationLine() {
    }

    public CssDecorationLine(GlobalValue currentValue) {
        super(currentValue);
    }

    @Override
    public LineTypeSet getInitialValue() {
        return INITIAL_VALUE;
    }

    @Override
    public boolean isInherited() {
        return false;
    }

    @Override
    public String toString() {
        return "CssDecorationLine [globalValue=" + globalValue + "]";
    }

}
