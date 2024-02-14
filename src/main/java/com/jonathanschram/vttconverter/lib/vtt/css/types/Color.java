package com.jonathanschram.vttconverter.lib.vtt.css.types;

import com.jonathanschram.vttconverter.lib.vtt.css.CssValue;

/***
 * Interface for colors set through CSS. Allows for absolute values (whose RGB
 * value is known) or the 'currentcolor' keyword.
 * 
 * @param <T> The type of value returned as the computed value.
 */
public interface Color extends CssValue<Color> {

}
