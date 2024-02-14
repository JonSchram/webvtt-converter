package com.jonathanschram.vttconverter.lib.vtt.css.cascade.decoration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.jonathanschram.vttconverter.lib.vtt.css.properties.decoration.LineStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.decoration.LineType;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.decoration.LineTypeSet;

class TextDecorationShorthandTest {

    @Test
    void testUpdateStyle() {
        TextDecorationShorthand style = TextDecorationShorthand.Builder.createUnset().setStyle(LineStyle.SOLID).build();
        TextDecorationShorthand updateStyle = TextDecorationShorthand.Builder.createUpdate().setStyle(LineStyle.DOTTED)
                .setLine(new LineTypeSet(LineType.UNDERLINE)).build();

        style.updateStyle(updateStyle);

        TextDecorationShorthand expectedDecoration = new TextDecorationShorthand.Builder()
                .setColor(new CssDecorationColor())
                .setLine(new LineTypeSet(LineType.UNDERLINE)).setStyle(LineStyle.DOTTED).build();

        assertEquals(expectedDecoration, style);
    }

}
