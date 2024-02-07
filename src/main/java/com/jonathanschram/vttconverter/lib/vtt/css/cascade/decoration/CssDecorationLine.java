package com.jonathanschram.vttconverter.lib.vtt.css.cascade.decoration;

import java.util.Set;

import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.decoration.LineType;

public class CssDecorationLine extends CascadingStyle<Set<LineType>> {

    public CssDecorationLine() {
    }

    @Override
    public Set<LineType> getInitialValue() {
        return Set.of(LineType.NONE);
    }

}
