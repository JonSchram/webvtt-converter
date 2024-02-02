package com.jonathanschram.vttconverter.lib.vtt.css.cascade.outline;

import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.outline.KeywordOutlineWidth;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.outline.OutlineWidth;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.outline.OutlineWidthKeyword;

public class CssOutlineWidth extends CascadingStyle<OutlineWidth> {

    public CssOutlineWidth() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public OutlineWidth getInitialValue() {
        return new KeywordOutlineWidth(OutlineWidthKeyword.MEDIUM);
    }

}
