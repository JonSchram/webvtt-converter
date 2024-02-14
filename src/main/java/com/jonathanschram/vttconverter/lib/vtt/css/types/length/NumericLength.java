package com.jonathanschram.vttconverter.lib.vtt.css.types.length;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        return Objects.hash(unit, value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        NumericLength other = (NumericLength) obj;
        return unit == other.unit && Double.doubleToLongBits(value) == Double.doubleToLongBits(other.value);
    }

    @Override
    public String toString() {
        return "NumericLength [value=" + value + ", unit=" + unit + "]";
    }

    @Override
    public boolean isAbsoluteLength() {
        return Unit.ABSOLUTE_UNITS.contains(unit);
    }

}
