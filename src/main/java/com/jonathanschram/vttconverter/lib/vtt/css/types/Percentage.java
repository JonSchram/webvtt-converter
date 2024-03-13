package com.jonathanschram.vttconverter.lib.vtt.css.types;

import java.util.Objects;

/***
 * A size measurement representing a percentage of another element's size (often
 * the parent element).
 */
public class Percentage {

    /***
     * Creates a new Percentage value from a double, where 1 represents 100%.
     * 
     * @param value
     * @return
     */
    public static Percentage createFromDecimal(double value) {
        return new Percentage(100 * value);
    }

    /***
     * Creates a new Percentage value from a double, where 100 represents 100%.
     * 
     * @param value
     * @return
     */
    public static Percentage createFromPercent(double value) {
        return new Percentage(value);
    }

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

    /***
     * Returns the percentage value, where 100% is represented as 1.
     * 
     * @return
     */
    public double getAsDecimal() {
        return value / 100;
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
     * Creates a new Percentage object by multiplying this percentage by the given
     * value.
     * 
     * @param scalar
     * @return
     */
    public Percentage multiply(double scalar) {
        return new Percentage(value * scalar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Percentage [value=" + value + "]";
    }

}
