package com.jonathanschram.vttconverter.lib.vtt.css.properties.outline;

import com.jonathanschram.vttconverter.lib.vtt.css.types.Unit;
import com.jonathanschram.vttconverter.lib.vtt.css.types.length.Length;
import com.jonathanschram.vttconverter.lib.vtt.css.types.length.NumericLength;

public class KeywordOutlineWidth implements OutlineWidth {
    private final OutlineWidthKeyword width;

    public KeywordOutlineWidth(OutlineWidthKeyword width) {
        this.width = width;
    }

    @Override
    public Length getMeasuredSize() {
        switch (width) {
        case THIN:
            return new NumericLength(1, Unit.PIXELS);
        case MEDIUM:
            return new NumericLength(3, Unit.PIXELS);
        case THICK:
            return new NumericLength(5, Unit.PIXELS);
        default:
            // Default to medium.
            return new NumericLength(3, Unit.PIXELS);
        }
    }

}
