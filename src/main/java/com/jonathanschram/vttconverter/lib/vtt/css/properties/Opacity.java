package com.jonathanschram.vttconverter.lib.vtt.css.properties;

import java.util.Objects;

import com.jonathanschram.vttconverter.lib.vtt.css.CssValue;
import com.jonathanschram.vttconverter.lib.vtt.css.types.Percentage;

public class Opacity implements CssValue<Opacity> {
    private static double clamp(double value) {
        if (value < 0) {
            return 0;
        }
        if (value > 1) {
            return 1;
        }
        return value;
    }

    private static Percentage clamp(Percentage value) {
        return Percentage.createFromDecimal(clamp(value.getAsDecimal()));
    }

    private final Percentage value;

    /***
     * Creates a new opacity object, with "1" equal to 100% opacity.
     * 
     * @param value
     */
    public Opacity(double value) {
        this.value = Percentage.createFromDecimal(clamp(value));
    }

    public Opacity(Percentage value) {
        this.value = clamp(value);
    }

    @Override
    public Opacity computeValue(Opacity parentValue) {
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Opacity other = (Opacity) obj;
        return Objects.equals(value, other.value);
    }

    public Percentage getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public boolean isComputedValue() {
        return true;
    }

    @Override
    public String toString() {
        return "Opacity [value=" + value + "]";
    }

}
