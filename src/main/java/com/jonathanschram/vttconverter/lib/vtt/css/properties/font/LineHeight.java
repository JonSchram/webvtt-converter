package com.jonathanschram.vttconverter.lib.vtt.css.properties.font;

import com.jonathanschram.vttconverter.lib.vtt.css.CssValue;

/***
 * An interface for specifying line height as either a number, length,
 * percentage, or the "normal" keyword.
 */
public interface LineHeight extends CssValue<LineHeight> {

    // LineHeight could need either the parent font (for EM units) or the current
    // font (for unitless values).
    // The solution is definitely to pass both values to the computeValue() method
    // and let it choose.
    // Having the 'parent' style pass the correct one in splits logic into two
    // places and is harder to understand.

    // TODO: Need a way to convert this into a length. This can be unitless, a
    // Length, or a Percentage. "Normal" could map to any of these, but unitless is
    // preferred because it avoids problems caused by length calculated based on
    // inherited font size.
}
