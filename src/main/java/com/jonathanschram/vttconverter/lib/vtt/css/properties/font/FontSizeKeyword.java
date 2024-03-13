package com.jonathanschram.vttconverter.lib.vtt.css.properties.font;

import java.util.Set;

/***
 * Valid keywords for font sizes.
 */
public enum FontSizeKeyword {
    // Absolute sizes.
    XX_SMALL, X_SMALL, SMALL, MEDIUM, LARGE, X_LARGE, XX_LARGE, XXX_LARGE,
    // Relative sizes
    LARGER, SMALLER;

    public static final Set<FontSizeKeyword> ABSOLUTE_SIZES = Set.of(XX_SMALL, X_SMALL, SMALL, MEDIUM, LARGE, X_LARGE,
            XX_LARGE, XXX_LARGE);
    public static final Set<FontSizeKeyword> RELATIVE_SIZES = Set.of(LARGER, SMALLER);
}
