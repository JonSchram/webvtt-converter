package com.jonathanschram.vttconverter.lib.vtt.css.properties.font;

import com.jonathanschram.vttconverter.lib.vtt.css.CssValue;

/***
 * All font variants supported. This doesn't include any new variants or the
 * shorthands like font-variant-alternatives or font-variant-caps.
 */
public enum FontVariant implements CssValue<FontVariant> {
    NORMAL, SMALL_CAPS;

    @Override
    public boolean isComputedValue() {
        return true;
    }

    @Override
    public FontVariant computeValue() {
        return this;
    }
}
