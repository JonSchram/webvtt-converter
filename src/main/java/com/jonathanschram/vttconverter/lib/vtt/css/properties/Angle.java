package com.jonathanschram.vttconverter.lib.vtt.css.properties;

/***
 * A representation of an angle value. Allows representing in terms of degrees,
 * radians, or turns.
 */
public interface Angle {

    /***
     * Converts this angle to degrees.
     * 
     * @return
     */
    double getAsDegrees();

}
