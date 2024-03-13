package com.jonathanschram.vttconverter.lib.vtt.css.types;

import com.jonathanschram.vttconverter.lib.vtt.css.RenderParameters;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadeValueReference;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.Font;

/***
 * A special implementation of {@link Color} that references the current node's
 * color (or the initial color if this is used for the color property itself).
 */
public class CurrentColor implements Color {

    private static CurrentColor instance;

    public static CurrentColor getInstance() {
        if (instance == null) {
            instance = new CurrentColor();
        }
        return instance;
    }

    private CurrentColor() {
    }

    @Override
    public boolean isComputedValue() {
        // The current color refers to the inherited value (when used for 'color') or
        // the color property (when used for anything else).
        return false;
    }

    @Override
    public String toString() {
        return "CurrentColor []";
    }

    @Override
    public Color computeValue(CascadeValueReference<Color> colorReference, CascadeValueReference<Font> fontReference, RenderParameters parameters) {
        // TODO (Somehow) find the correct color. Might be able to add a parameter
        // indicating which property name is being computed.
        return null;
    }

    // TODO: resolve against a node to get the color. Needs to be on the Color
    // interface so this can work without an instanceOf check.

}