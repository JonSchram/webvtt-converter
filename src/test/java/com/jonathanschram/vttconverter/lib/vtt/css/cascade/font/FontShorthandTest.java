package com.jonathanschram.vttconverter.lib.vtt.css.cascade.font;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.FontSizeKeyword;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.FontWeightKeyword;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.GenericFamilyName;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.GenericFontFamily;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.KeywordFontSize;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.KeywordFontWeight;

class FontShorthandTest {

    @Test
    void testUpdateStyle() {
        FontShorthand initialStyle = FontShorthand.Builder.createUnset()
                .setFamily(List.of(new GenericFontFamily(GenericFamilyName.MATH)))
                .setWeight(new KeywordFontWeight(FontWeightKeyword.LIGHTER))
                .build();

        FontShorthand update = FontShorthand.Builder.createUpdate()
                .setWeight(new KeywordFontWeight(FontWeightKeyword.BOLD))
                .setSize(new KeywordFontSize(FontSizeKeyword.X_LARGE)).build();

        initialStyle.updateStyle(update);

        FontShorthand expectedStyle = new FontShorthand.Builder()
                .setFamily(List.of(new GenericFontFamily(GenericFamilyName.MATH)))
                .setWeight(new KeywordFontWeight(FontWeightKeyword.BOLD))
                .setSize(new KeywordFontSize(FontSizeKeyword.X_LARGE))
                .setStretch(new CssFontStretch())
                .setStyle(new CssFontStyle())
                .setVariant(new CssFontVariant())
                .setLineHeight(new CssLineHeight())
                .build();

        assertEquals(expectedStyle, initialStyle);
    }

}
