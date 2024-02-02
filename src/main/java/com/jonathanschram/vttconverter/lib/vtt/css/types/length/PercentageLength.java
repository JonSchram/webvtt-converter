package com.jonathanschram.vttconverter.lib.vtt.css.types.length;

import com.jonathanschram.vttconverter.lib.vtt.css.types.Percentage;

/***
 * An implementation of {@link Length} that specifies distance by percent of
 * another element's size.
 */
public class PercentageLength implements Length {
    private final Percentage percent;

    public PercentageLength(Percentage percent) {
        this.percent = percent;
    }

    public Percentage getPercent() {
        return percent;
    }

}
