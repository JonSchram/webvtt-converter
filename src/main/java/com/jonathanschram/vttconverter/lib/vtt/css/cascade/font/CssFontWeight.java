package com.jonathanschram.vttconverter.lib.vtt.css.cascade.font;

import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.FontWeight;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.NumericFontWeight;

public class CssFontWeight extends CascadingStyle<FontWeight> {

    public CssFontWeight() {
    }

    @Override
    public FontWeight getInitialValue() {
        // Normal font weight.
        return new NumericFontWeight(400);
    }
}
