package com.jonathanschram.vttconverter.lib.vtt.css.cascade.decoration;

import java.util.Set;

import com.jonathanschram.vttconverter.lib.vtt.css.GlobalValue;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.decoration.LineType;

public class CssDecorationLine extends CascadingStyle<Set<LineType>> {

    public CssDecorationLine() {
    }

    @Override
    public Set<LineType> getInitialValue() {
        return Set.of(LineType.NONE);
    }

    public CssDecorationLine(GlobalValue currentValue) {
        super(currentValue);
    }

    public CssDecorationLine(Set<LineType> currentValue) {
        // Defensively copy input value.
        super(Set.copyOf(currentValue));
    }

    @Override
    public boolean isInherited() {
        return false;
    }

    @Override
    public String toString() {
        return "CssDecorationLine [globalValue=" + globalValue + ", wrappedValue=" + wrappedValue + "]";
    }

}
