package com.jonathanschram.vttconverter.lib.vtt.css.types;

/***
 * A size measurement representing a percentage of another element's size (often
 * the parent element).
 */
public class Percentage {

    /***
     * The percentage value, where 100 corresponds to 100%.
     */
    private final double value;

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

}
