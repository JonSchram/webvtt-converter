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

    public double getValue() {
        return value;
    }

}
