package com.jonathanschram.vttconverter.lib.vtt.css.cascade;

import com.jonathanschram.vttconverter.lib.vtt.css.types.Color;

public class CssColor extends CascadingStyle<Color> {

    public CssColor() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public Color getInitialValue() {
        // TODO: Implement system colors. This should be canvas text, a system color that looks like it is black.
        return Color.ALICE_BLUE;
    }
}
