package com.jonathanschram.vttconverter.lib.vtt.css.cascade.outline;

import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.outline.KeywordOutlineWidth;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.outline.OutlineWidth;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.outline.OutlineWidthKeyword;

public class CssOutlineWidth extends CascadingStyle<OutlineWidth> {
    public static final OutlineWidth INITIAL_VALUE = new KeywordOutlineWidth(OutlineWidthKeyword.MEDIUM);

    public CssOutlineWidth() {
    }

    public CssOutlineWidth(OutlineWidth width) {
        super(width);
    }

    @Override
    public OutlineWidth getInitialValue() {
        return INITIAL_VALUE;
    }

    @Override
    public boolean isInherited() {
        return false;
    }

    @Override
    public String toString() {
        return "CssOutlineWidth [globalValue=" + globalValue + ", wrappedValue=" + wrappedValue + "]";
    }

}
