package com.jonathanschram.vttconverter.lib.vtt.css.cascade;

import com.jonathanschram.vttconverter.lib.vtt.css.GlobalValue;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.ruby.OverUnderPosition;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.ruby.RubyPosition;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.ruby.RubyTextPosition;

public class CssRubyPosition extends CascadingProperty<RubyPosition> {

    public CssRubyPosition() {
    }

    public CssRubyPosition(GlobalValue currentValue) {
        super(currentValue);
    }

    @Override
    public RubyPosition getInitialValue() {
        return new OverUnderPosition(true, RubyTextPosition.OVER);
    }

    @Override
    public boolean isInherited() {
        return true;
    }

    @Override
    public String toString() {
        return "CssRubyPosition [globalValue=" + globalValue + "]";
    }

}
