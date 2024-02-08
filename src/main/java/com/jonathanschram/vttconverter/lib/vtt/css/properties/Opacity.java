package com.jonathanschram.vttconverter.lib.vtt.css.properties;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        return Objects.hash(value);
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

    @Override
    public String toString() {
        return "Opacity [value=" + value + "]";
    }

}
