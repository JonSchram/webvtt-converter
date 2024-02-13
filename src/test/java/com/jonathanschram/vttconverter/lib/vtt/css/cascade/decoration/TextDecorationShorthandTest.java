package com.jonathanschram.vttconverter.lib.vtt.css.cascade.decoration;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;

import com.jonathanschram.vttconverter.lib.vtt.css.properties.decoration.LineStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.decoration.LineType;

class TextDecorationShorthandTest {

    @Test
    void testUpdateStyle() {
        TextDecorationShorthand style = TextDecorationShorthand.Builder.createUnset().setStyle(LineStyle.SOLID).build();
        TextDecorationShorthand updateStyle = TextDecorationShorthand.Builder.createUpdate().setStyle(LineStyle.DOTTED)
                .setLine(Set.of(LineType.UNDERLINE)).build();

        style.updateStyle(updateStyle);

        TextDecorationShorthand expectedDecoration = new TextDecorationShorthand.Builder()
                .setColor(new CssDecorationColor())
                .setLine(Set.of(LineType.UNDERLINE)).setStyle(LineStyle.DOTTED).build();

        assertEquals(expectedDecoration, style);
    }

}
