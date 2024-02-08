package com.jonathanschram.vttconverter.lib.vtt.css.types;

import java.util.Objects;

/***
 * A size measurement representing a percentage of another element's size (often
 * the parent element).
 */
public class Percentage {

    /***
     * The percentage value, where 100 corresponds to 100%.
     */
    private final double value;

    /***
     * Constructs a new Percentage object, where 100 corresponds to 100%.
     * 
     * @param value
     */
    public Percentage(double value) {
        this.value = value;
    }

    /***
     * Returns the percentage value, where 100% is represented as 100.
     * 
     * @return
     */
    public double getAsPercent() {
        return value;
    }

    /***
     * Returns the percentage value, where 100% is represented as 1.
     * 
     * @return
     */
    public double getAsDouble() {
        return value / 100;
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
        Percentage other = (Percentage) obj;
        return Double.doubleToLongBits(value) == Double.doubleToLongBits(other.value);
    }

    @Override
    public String toString() {
        return "Percentage [value=" + value + "]";
    }

}
