package com.jonathanschram.vttconverter.lib.vtt.css.cascade.outline;

import com.jonathanschram.vttconverter.lib.vtt.css.CssProperty;
import com.jonathanschram.vttconverter.lib.vtt.css.CssShorthand;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.outline.Outline;

public class CssOutline implements CssShorthand<Outline, CssProperty<Outline>> {

    private CssOutlineColor color;
    private CssOutlineStyle style;
    private CssOutlineWidth width;

    public CssOutline() {
        color = new CssOutlineColor();
        style = new CssOutlineStyle();
        width = new CssOutlineWidth();
    }

    @Override
    public Outline getInitialValue() {
        return new Outline(color.getInitialValue(), style.getInitialValue(), width.getInitialValue());
    }

}
