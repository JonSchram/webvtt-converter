package com.jonathanschram.vttconverter.lib.vtt.css.cascade;

import com.jonathanschram.vttconverter.lib.vtt.css.properties.TextShadow;

public class CssTextShadow extends CascadingStyle<TextShadow> {

    public CssTextShadow() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public TextShadow getInitialValue() {
        // Default is no shadow. Might want to revisit in the future if there should be
        // a different representation for this other than null.
        return null;
    }

}