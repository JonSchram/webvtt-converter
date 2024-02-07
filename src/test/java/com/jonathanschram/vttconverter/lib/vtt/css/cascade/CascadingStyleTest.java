package com.jonathanschram.vttconverter.lib.vtt.css.cascade;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.jonathanschram.vttconverter.lib.vtt.css.GlobalValue;
import com.jonathanschram.vttconverter.lib.vtt.css.types.AbsoluteColor;

/***
 * Tests common cascading style methods.
 */
class CascadingStyleTest {

    @Test
    void testUpdateStyle_newColor() {
        CssColor color = new CssColor(new AbsoluteColor(100, 0, 0));
        color.updateStyle(new CssColor(new AbsoluteColor(0, 200, 0)));

        assertEquals(new AbsoluteColor(0, 200, 0), color.getCurrentValue());
        assertEquals(null, color.getGlobalValue());
    }

    @Test
    void testUpdateStyle_unset() {
        CssColor color = new CssColor(new AbsoluteColor(0, 0, 3));
        color.updateStyle(new CssColor());

        assertEquals(new AbsoluteColor(0, 0, 3), color.getCurrentValue());
    }

    @Test
    void testUpdateStyle_updateUnset() {
        CssColor color = new CssColor();

        color.updateStyle(new CssColor(new AbsoluteColor(1, 2, 3)));

        assertEquals(new AbsoluteColor(1, 2, 3), color.getCurrentValue());
    }

    @Test
    void testUpdateStyle_updateGlobalValue() {
        CssColor color = new CssColor();
        color.updateStyle(new CssColor(GlobalValue.INHERIT));

        assertEquals(GlobalValue.INHERIT, color.getGlobalValue());
    }

    @Test
    void testUpdateStyle_overwriteStyleWithGlobalValue() {
        CssColor color = new CssColor(AbsoluteColor.BLACK);
        color.updateStyle(new CssColor(GlobalValue.INITIAL));

        assertEquals(GlobalValue.INITIAL, color.getGlobalValue());
        assertEquals(null, color.getCurrentValue());
    }

}
