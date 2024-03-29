package com.jonathanschram.vttconverter.lib.vtt.css.properties.font;

import com.jonathanschram.vttconverter.lib.vtt.css.CssValue;
import com.jonathanschram.vttconverter.lib.vtt.css.UncomputedValueException;

/***
 * An interface for specifying font weight as either a keyword or a numeric
 * value.
 */
public interface FontWeight extends CssValue<FontWeight> {
    int getAbsoluteWeight() throws UncomputedValueException;

}
