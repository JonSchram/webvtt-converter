package com.jonathanschram.vttconverter.lib.vtt.css.cascade.decoration;

import java.util.Set;

import com.jonathanschram.vttconverter.lib.vtt.css.GlobalValue;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingProperty;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.decoration.LineType;

public class CssDecorationLine extends CascadingProperty<Set<LineType>> {
    public static final Set<LineType> INITIAL_VALUE = Set.of(LineType.NONE);

    public CssDecorationLine() {
    }

    @Override
    public Set<LineType> getInitialValue() {
        return INITIAL_VALUE;
    }

    public CssDecorationLine(GlobalValue currentValue) {
        super(currentValue);
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
