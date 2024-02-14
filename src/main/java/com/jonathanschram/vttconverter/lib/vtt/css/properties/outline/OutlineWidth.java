package com.jonathanschram.vttconverter.lib.vtt.css.properties.outline;

import com.jonathanschram.vttconverter.lib.vtt.css.CssValue;
import com.jonathanschram.vttconverter.lib.vtt.css.types.length.Length;

/**
 * Allows specifying the width of an outline with either a CSS measurement or
 * with a keyword.
 */
public interface OutlineWidth extends CssValue<OutlineWidth> {

    Length getMeasuredSize();
}
