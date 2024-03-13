package com.jonathanschram.vttconverter.lib.vtt.css;

import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.Font;
import com.jonathanschram.vttconverter.lib.vtt.css.types.length.Length;

/**
 * A class that can measure distances for length calculation.
 */
public class LengthMeasurer {

    private Font referenceFont;
    // TODO: Have a render context or render parameter object for viewport.

    public LengthMeasurer() {
        // TODO Auto-generated constructor stub
    }

    public Length measureHeight(String s) {
        // TODO
        return null;
    }

    /*
     * Problem: Font and viewport don't have much in common at all, so this method
     * mixes dependencies even though it makes the NumericLength easier.
     * 
     * Phrased another way, what happens during layout when we want to measure the
     * width of text boxes? Those need font measurement but not viewport
     * measurement. That would probably benefit from either a factory to create a
     * font metrics object or something wrapping a font metrics.
     * 
     * Yet another way, this object would be constructed using both a font and a
     * viewport size. Even when there is no need to measure during cascade, this
     * would need to be created just so that the length object could reference it.
     * This would be a little inefficient, not enough to matter, but still a code
     * smell. Length is the only thing that cares about what the unit means, and it
     * should eventually convert even absolute units to a single unit such as points
     * or pixels. It will need the screen DPI for something as simple as converting
     * inches to pixels, so there could be many different ways to measure distances.
     * Cramming them all in here wouldn't make sense, so viewport size should follow
     * the same rule.
     */

    public Length measureViewportHeight() {
        // TODO
        return null;
    }

}
