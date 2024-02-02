package com.jonathanschram.vttconverter.lib.vtt.css.cascade.decoration;

import java.util.HashSet;
import java.util.Set;

import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.decoration.LineType;

public class CssDecorationLine extends CascadingStyle<Set<LineType>> {

    private final Set<LineType> values;

    public CssDecorationLine() {
        this.values = new HashSet<>();
    }

    @Override
    public Set<LineType> getInitialValue() {
        return Set.of(LineType.NONE);
    }

}
