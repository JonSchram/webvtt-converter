package com.jonathanschram.vttconverter.lib.vtt.css.cascade;

import com.jonathanschram.vttconverter.lib.vtt.css.properties.ruby.OverUnderPosition;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.ruby.RubyPosition;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.ruby.RubyTextPosition;

public class CssRubyPosition extends CascadingStyle<RubyPosition> {

    public CssRubyPosition() {
    }

    @Override
    public RubyPosition getInitialValue() {
        return new OverUnderPosition(true, RubyTextPosition.OVER);
    }

    @Override
    public String toString() {
        return "CssRubyPosition [globalValue=" + globalValue + ", wrappedValue=" + wrappedValue + "]";
    }

}
