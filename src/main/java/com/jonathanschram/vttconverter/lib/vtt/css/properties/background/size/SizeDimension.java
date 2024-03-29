package com.jonathanschram.vttconverter.lib.vtt.css.properties.background.size;

/***
 * An interface for a single dimension of a background size. Allows for length,
 * percentage, or 'auto'.
 */
public interface SizeDimension {
    // TODO: Add methods to measure size based on some criteria (also TODO).

    /***
     * Returns whether the size is expressed in absolute terms. For lengths, this is
     * using absolute units. Keywords are considered absolute.
     * 
     * @return
     */
    boolean isAbsoluteLength();

}
