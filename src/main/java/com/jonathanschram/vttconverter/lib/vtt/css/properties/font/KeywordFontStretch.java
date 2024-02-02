package com.jonathanschram.vttconverter.lib.vtt.css.properties.font;

import com.jonathanschram.vttconverter.lib.vtt.css.types.Percentage;

public class KeywordFontStretch implements FontStretch {
    private final FontStretchKeyword stretch;

    public KeywordFontStretch(FontStretchKeyword stretch) {
        this.stretch = stretch;
    }

    @Override
    public Percentage getStretchPercent() {
        switch (stretch) {
        case ULTRA_CONDENSED:
            return new Percentage(50);
        case EXTRA_CONDENSED:
            return new Percentage(62.5);
        case CONDENSED:
            return new Percentage(75);
        case SEMI_CONDENSED:
            return new Percentage(87.5);
        case NORMAL:
            return new Percentage(100);
        case SEMI_EXPANDED:
            return new Percentage(112.5);
        case EXPANDED:
            return new Percentage(125);
        case EXTRA_EXPANDED:
            return new Percentage(150);
        case ULTRA_EXPANDED:
            return new Percentage(200);
        default:
            // Default to normal.
            return new Percentage(100);
        }
    }

}
