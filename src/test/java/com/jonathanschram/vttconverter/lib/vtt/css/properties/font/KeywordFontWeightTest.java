package com.jonathanschram.vttconverter.lib.vtt.css.properties.font;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.jonathanschram.vttconverter.lib.vtt.css.UncomputedValueException;

class KeywordFontWeightTest {

    @Test
    void testComputeValue_LighterThan700() throws UncomputedValueException {
        KeywordFontWeight fontWeight = new KeywordFontWeight(FontWeightKeyword.LIGHTER);
        FontWeight result = fontWeight.computeValue(new NumericFontWeight(700));

        assertEquals(400, result.getAbsoluteWeight());
    }

    @Test
    void testComputeValue_LighterThanNormal() throws UncomputedValueException {
        KeywordFontWeight fontWeight = new KeywordFontWeight(FontWeightKeyword.LIGHTER);
        FontWeight result = fontWeight.computeValue(new KeywordFontWeight(FontWeightKeyword.NORMAL));

        assertEquals(100, result.getAbsoluteWeight());
    }

    @Test
    void testComputeValue_Normal() throws UncomputedValueException {
        KeywordFontWeight fontWeight = new KeywordFontWeight(FontWeightKeyword.NORMAL);

        FontWeight result = fontWeight.computeValue(new NumericFontWeight(1));

        assertEquals(400, result.getAbsoluteWeight());
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
