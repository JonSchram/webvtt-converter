package com.jonathanschram.vttconverter.lib.vtt.css.properties.background;

import com.jonathanschram.vttconverter.lib.vtt.css.CssValue;
import com.jonathanschram.vttconverter.lib.vtt.css.types.Position;

/***
 * An interface for setting the position of a background image. Beyond a regular
 * position, this allows specifying an offset from a position.
 * 
 * TODO: Now that Position is a data type, this may not be needed
 */
public interface BackgroundPosition extends Position, CssValue<BackgroundPosition> {

}
