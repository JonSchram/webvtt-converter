package com.jonathanschram.vttconverter.lib.vtt.region;

/***
 * A location within a bounding box, expressed as a percentage of the bounding
 * box's dimensions.
 */
public record Location(double xPercent, double yPercent) {
};
