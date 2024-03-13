package com.jonathanschram.vttconverter.lib.vtt.css.cascade;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.jonathanschram.vttconverter.lib.vtt.css.CssProperty;
import com.jonathanschram.vttconverter.lib.vtt.css.GlobalValue;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.Opacity;
import com.jonathanschram.vttconverter.lib.vtt.css.types.AbsoluteColor;
import com.jonathanschram.vttconverter.lib.vtt.css.types.Color;

/***
 * Tests that various cascading properties cascade properly.
 */
class CascadingPropertyTest {

    @Test
    void testCascadeFrom_unsetColorInherits() {
        ConcreteProperty<Color> parentColor = new ConcreteProperty<>(AbsoluteColor.BLUE);
        CssColor childColor = new CssColor(GlobalValue.UNSET);

        CssProperty<Color> result = childColor.cascadeFrom(parentColor, null, null, null);

        assertEquals(parentColor, result);
    }

    @Test
    void testCascadeFrom_initialColor() {
        ConcreteProperty<Color> parentColor = new ConcreteProperty<>(AbsoluteColor.BLUE);
        CssColor childColor = new CssColor(GlobalValue.INITIAL);

        CssProperty<Color> result = childColor.cascadeFrom(parentColor, null, null, null);

        assertEquals(new ConcreteProperty<>(AbsoluteColor.CANVAS_TEXT), result);
    }

    @Test
    void testCascadeFrom_unsetOpacityDoesNotInherit() {
        ConcreteProperty<Opacity> parent = new ConcreteProperty<Opacity>(new Opacity(.5));
        CssOpacity child = new CssOpacity();

        CssProperty<Opacity> result = child.cascadeFrom(parent, null, null, null);

        CssProperty<Opacity> expected = new ConcreteProperty<Opacity>(new Opacity(1));
        assertEquals(expected, result);
    }

    @Test
    void testCascadeFrom_inheritOpacity() {
        ConcreteProperty<Opacity> parent = new ConcreteProperty<Opacity>(new Opacity(.5));
        CssOpacity child = new CssOpacity(GlobalValue.INHERIT);

        CssProperty<Opacity> result = child.cascadeFrom(parent, null, null, null);

        assertEquals(parent, result);
    }

}
