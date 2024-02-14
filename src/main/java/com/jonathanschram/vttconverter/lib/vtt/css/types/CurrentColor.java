package com.jonathanschram.vttconverter.lib.vtt.css.types;

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
    public AbsoluteColor computeValue() {
        // TODO (Somehow) find the correct color.
        return null;
    }

    // TODO: resolve against a node to get the color. Needs to be on the Color
    // interface so this can work without an instanceOf check.

}