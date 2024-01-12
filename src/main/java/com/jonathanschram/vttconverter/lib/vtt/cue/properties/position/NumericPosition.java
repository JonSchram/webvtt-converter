package com.jonathanschram.vttconverter.lib.vtt.cue.properties.position;

/***
 * A numeric line position. The value represents a percent of the video's width
 * (or of the height if the text is vertical).
 */
public record NumericPosition(double percent) implements Position {}
