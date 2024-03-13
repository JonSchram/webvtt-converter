package com.jonathanschram.vttconverter.lib.vtt.css.properties.font;

import com.jonathanschram.vttconverter.lib.vtt.css.CssValue;
import com.jonathanschram.vttconverter.lib.vtt.css.types.Percentage;
import com.jonathanschram.vttconverter.lib.vtt.css.types.length.Length;

/***
 * An interface for representing a font size. Allows for setting a
 * {@link FontSizeKeyword} (absolute size like "large" or relative like
 * "larger"), a {@link Length}, or a {@link Percentage}.
 */
public interface FontSize extends CssValue<FontSize> {
    /***
     * Calculates the next font size smaller than this font size.
     * 
     * @return
     */
    FontSize getNextSmaller();

    /**
     * Calculates the next font size larger than this font size.
     * 
     * @return
     */
    FontSize getNextLarger();

    
}
