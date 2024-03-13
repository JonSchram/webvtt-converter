package com.jonathanschram.vttconverter.lib.vtt.css.properties.font;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.jonathanschram.vttconverter.lib.vtt.css.UncomputedValueException;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadeValueReference;

class KeywordFontWeightTest {

    @Test
    void testComputeValue_LighterThan700() throws UncomputedValueException {
        KeywordFontWeight fontWeight = new KeywordFontWeight(FontWeightKeyword.LIGHTER);
        CascadeValueReference<Font> fontReference = buildFontReference(new NumericFontWeight(700));
        FontWeight result = fontWeight.computeValue(null, fontReference, null);

        assertEquals(400, result.getAbsoluteWeight());
    }

    @Test
    void testComputeValue_LighterThanNormal() throws UncomputedValueException {
        KeywordFontWeight fontWeight = new KeywordFontWeight(FontWeightKeyword.LIGHTER);
        CascadeValueReference<Font> fontReference = buildFontReference(new KeywordFontWeight(FontWeightKeyword.NORMAL));
        FontWeight result = fontWeight.computeValue(null, fontReference, null);

        assertEquals(100, result.getAbsoluteWeight());
    }

    @Test
    void testComputeValue_Normal() throws UncomputedValueException {
        KeywordFontWeight fontWeight = new KeywordFontWeight(FontWeightKeyword.NORMAL);
        CascadeValueReference<Font> fontReference = buildFontReference(new NumericFontWeight(1));
        FontWeight result = fontWeight.computeValue(null, fontReference, null);

        assertEquals(400, result.getAbsoluteWeight());
    }

    private CascadeValueReference<Font> buildFontReference(FontWeight weight) {
        Font parentFont = new Font(null, null, null, null, null, weight, null);
        return new CascadeValueReference<Font>(parentFont, null);
    }

    @Test
    void testGetAbsoluteWeight_Bold() throws UncomputedValueException {
        KeywordFontWeight fontWeight = new KeywordFontWeight(FontWeightKeyword.BOLD);

        assertEquals(700, fontWeight.getAbsoluteWeight());
    }

    @Test
    void testGetAbsoluteWeight_Bolder_Throws() {
        KeywordFontWeight fontWeight = new KeywordFontWeight(FontWeightKeyword.BOLDER);
        assertThrows(UncomputedValueException.class, () -> fontWeight.getAbsoluteWeight());
    }

    @Test
    void testGetAbsoluteWeight_Normal() throws UncomputedValueException {
        KeywordFontWeight fontWeight = new KeywordFontWeight(FontWeightKeyword.NORMAL);

        assertEquals(400, fontWeight.getAbsoluteWeight());
    }

}
