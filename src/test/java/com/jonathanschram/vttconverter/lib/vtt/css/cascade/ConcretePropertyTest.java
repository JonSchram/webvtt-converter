package com.jonathanschram.vttconverter.lib.vtt.css.cascade;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.jonathanschram.vttconverter.lib.vtt.css.CssProperty;
import com.jonathanschram.vttconverter.lib.vtt.css.UncomputedValueException;
import com.jonathanschram.vttconverter.lib.vtt.css.UnresolvedPropertyException;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.Visibility;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.outline.AbsoluteOutlineWidth;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.outline.KeywordOutlineWidth;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.outline.OutlineWidth;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.outline.OutlineWidthKeyword;
import com.jonathanschram.vttconverter.lib.vtt.css.types.Unit;
import com.jonathanschram.vttconverter.lib.vtt.css.types.length.NumericLength;

class ConcretePropertyTest {

    @Test
    void testCascadeFrom_visibility() throws UnresolvedPropertyException, UncomputedValueException {
        ConcreteProperty<Visibility> value = new ConcreteProperty<Visibility>(Visibility.COLLAPSE);

        CssProperty<Visibility> result = value.cascadeFrom(null, null, null, null);

        assertEquals(value, result);
    }

    @Test
    void testCascadeFrom_outlineWidth() throws UnresolvedPropertyException, UncomputedValueException {
        ConcreteProperty<OutlineWidth> value = new ConcreteProperty<OutlineWidth>(
                new KeywordOutlineWidth(OutlineWidthKeyword.THICK));

        CssProperty<OutlineWidth> result = value.cascadeFrom(null, null, null, null);

        CssProperty<OutlineWidth> expected = new ConcreteProperty<OutlineWidth>(
                new AbsoluteOutlineWidth(new NumericLength(5, Unit.PIXELS)));
        assertEquals(expected, result);
    }

}
