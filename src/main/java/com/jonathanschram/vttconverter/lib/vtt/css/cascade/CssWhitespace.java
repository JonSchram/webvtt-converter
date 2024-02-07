package com.jonathanschram.vttconverter.lib.vtt.css.cascade;

import com.jonathanschram.vttconverter.lib.vtt.css.properties.WhiteSpace;

public class CssWhitespace extends CascadingStyle<WhiteSpace> {

    public CssWhitespace() {
    }

    @Override
    public WhiteSpace getInitialValue() {
        return WhiteSpace.NORMAL;
    }

}
