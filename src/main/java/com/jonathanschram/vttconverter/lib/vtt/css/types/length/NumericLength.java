package com.jonathanschram.vttconverter.lib.vtt.css.types.length;

import com.jonathanschram.vttconverter.lib.vtt.css.types.Unit;

public class NumericLength implements Length {

    private final double value;
    private final Unit unit;

    public NumericLength(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public Unit getUnit() {
        return unit;
    }

}
