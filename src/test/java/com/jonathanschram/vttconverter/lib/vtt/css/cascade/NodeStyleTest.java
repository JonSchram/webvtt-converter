package com.jonathanschram.vttconverter.lib.vtt.css.cascade;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.jonathanschram.vttconverter.lib.vtt.css.GlobalValue;
import com.jonathanschram.vttconverter.lib.vtt.css.NodeStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.types.AbsoluteColor;

/***
 * Tests updating styles in NodeStyle.
 */
class NodeStyleTest {

    @Test
    void testUpdateColor_newColor() {
        NodeStyle nodeStyle = new NodeStyle.Builder()
                .setColor(new AbsoluteColor(100, 0, 0)).build();

        nodeStyle.updateColor(new ConcreteProperty<>(new AbsoluteColor(0, 200, 0)));

        assertEquals(new ConcreteProperty<>(new AbsoluteColor(0, 200, 0)), nodeStyle.getColor());
    }

    @Test
    void testUpdateColor_withNull() {
        NodeStyle style = new NodeStyle.Builder().setColor(new AbsoluteColor(0, 0, 3)).build();

        style.updateColor(null);

        assertEquals(new ConcreteProperty<>(new AbsoluteColor(0, 0, 3)), style.getColor());
    }

    @Test
    void testUpdateColor_withGlobalValue() {
        NodeStyle style = new NodeStyle.Builder().setColor(new AbsoluteColor(1, 2, 3)).build();

        style.updateColor(new CssColor(GlobalValue.INITIAL));

        assertEquals(new CssColor(GlobalValue.INITIAL), style.getColor());
    }

    @Test
    void testUpdateColor_updateGlobalValue() {
        NodeStyle style = new NodeStyle();

        style.updateColor(new CssColor(GlobalValue.INHERIT));

        assertEquals(new CssColor(GlobalValue.INHERIT), style.getColor());
    }

}
