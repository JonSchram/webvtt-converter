package com.jonathanschram.vttconverter.lib.vtt.css.cascade;

import com.jonathanschram.vttconverter.lib.vtt.css.properties.ruby.OverUnderPosition;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.ruby.RubyPosition;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.ruby.RubyTextPosition;

public class CssRubyPosition extends CascadingStyle<RubyPosition> {

    public CssRubyPosition() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public RubyPosition getInitialValue() {
        return new OverUnderPosition(true, RubyTextPosition.OVER);
    }
}
