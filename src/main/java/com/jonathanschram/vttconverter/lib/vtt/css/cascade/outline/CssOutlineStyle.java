package com.jonathanschram.vttconverter.lib.vtt.css.cascade.outline;

import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.outline.OutlineStyle;

public class CssOutlineStyle extends CascadingStyle<OutlineStyle> {
    @Override
    public OutlineStyle getInitialValue() {
        return OutlineStyle.NONE;
    }
}
