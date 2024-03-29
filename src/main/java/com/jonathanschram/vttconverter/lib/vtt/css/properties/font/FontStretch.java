package com.jonathanschram.vttconverter.lib.vtt.css.properties.font;

import com.jonathanschram.vttconverter.lib.vtt.css.CssValue;
import com.jonathanschram.vttconverter.lib.vtt.css.types.Percentage;

/***
 * An interface that allows specifying a {@link FontStretchKeyword} or a
 * {@link Percentage}.
 */
public interface FontStretch extends CssValue<FontStretch> {

    Percentage getStretchPercent();
}
