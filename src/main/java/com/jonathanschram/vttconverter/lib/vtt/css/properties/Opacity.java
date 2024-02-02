package com.jonathanschram.vttconverter.lib.vtt.css.properties;

import com.jonathanschram.vttconverter.lib.vtt.css.types.Percentage;

public class Opacity {
    private final Percentage value;

    public Opacity(double value) {
        this.value = new Percentage(100.0 * value);
    }

    public Opacity(Percentage value) {
        this.value = value;
    }

    public Percentage getValue() {
        return value;
    }

}
