package com.jonathanschram.vttconverter.lib.vtt.css.cascade.outline;

import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingProperty;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.outline.KeywordOutlineWidth;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.outline.OutlineWidth;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.outline.OutlineWidthKeyword;

public class CssOutlineWidth extends CascadingProperty<OutlineWidth> {
    public static final OutlineWidth INITIAL_VALUE = new KeywordOutlineWidth(OutlineWidthKeyword.MEDIUM);

    public CssOutlineWidth() {
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
        return "CssOutlineWidth [globalValue=" + globalValue + "]";
    }

}
