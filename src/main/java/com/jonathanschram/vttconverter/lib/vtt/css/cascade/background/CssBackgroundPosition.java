package com.jonathanschram.vttconverter.lib.vtt.css.cascade.background;

import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.background.BackgroundPosition;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.background.SimpleBackgroundPosition;
import com.jonathanschram.vttconverter.lib.vtt.css.types.LengthPosition;
import com.jonathanschram.vttconverter.lib.vtt.css.types.Percentage;
import com.jonathanschram.vttconverter.lib.vtt.css.types.length.Length;
import com.jonathanschram.vttconverter.lib.vtt.css.types.length.PercentageLength;

public class CssBackgroundPosition extends CascadingStyle<BackgroundPosition> {
    private static final Length ZERO_LENGTH = new PercentageLength(new Percentage(0));
    public static final BackgroundPosition INITIAL_VALUE = new SimpleBackgroundPosition(
            new LengthPosition(ZERO_LENGTH, ZERO_LENGTH));

    public CssBackgroundPosition() {
    }

    @Override
    public BackgroundPosition getInitialValue() {
        return INITIAL_VALUE;
    }

    @Override
    public boolean isInherited() {
        return false;
    }

    @Override
    public String toString() {
        return "CssBackgroundPosition [globalValue=" + globalValue + ", wrappedValue=" + wrappedValue + "]";
    }

}
