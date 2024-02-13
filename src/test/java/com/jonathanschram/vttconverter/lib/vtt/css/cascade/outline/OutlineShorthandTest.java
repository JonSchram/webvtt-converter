package com.jonathanschram.vttconverter.lib.vtt.css.cascade.outline;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.jonathanschram.vttconverter.lib.vtt.css.properties.outline.KeywordOutlineWidth;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.outline.OutlineStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.outline.OutlineWidthKeyword;

class OutlineShorthandTest {

    @Test
    void test() {
        OutlineShorthand style = OutlineShorthand.Builder.createUnset()
                .setWidth(new KeywordOutlineWidth(OutlineWidthKeyword.THICK)).build();
        OutlineShorthand update = OutlineShorthand.Builder.createUpdate()
                .setWidth(new CssOutlineWidth())
                .setStyle(OutlineStyle.GROOVE)
                .build();

        style.updateStyle(update);

        OutlineShorthand expectedStyle = OutlineShorthand.Builder.createUnset()
                .setColor(new CssOutlineColor())
                .setStyle(OutlineStyle.GROOVE)
                .setWidth(new CssOutlineWidth())
                .build();

        assertEquals(expectedStyle, style);
    }

}
