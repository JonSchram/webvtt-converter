package com.jonathanschram.vttconverter.lib.vtt.css.cascade.background;

import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.background.BackgroundPosition;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.background.SimpleBackgroundPosition;
import com.jonathanschram.vttconverter.lib.vtt.css.types.LengthPosition;
import com.jonathanschram.vttconverter.lib.vtt.css.types.Percentage;
import com.jonathanschram.vttconverter.lib.vtt.css.types.length.Length;
import com.jonathanschram.vttconverter.lib.vtt.css.types.length.PercentageLength;

public class CssPosition extends CascadingStyle<BackgroundPosition> {

    public CssPosition() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public BackgroundPosition getInitialValue() {
        Length zero = new PercentageLength(new Percentage(0));
        return new SimpleBackgroundPosition(new LengthPosition(zero, zero));
    }

}
