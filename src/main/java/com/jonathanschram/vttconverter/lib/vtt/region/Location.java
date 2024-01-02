package com.jonathanschram.vttconverter.lib.vtt.region;

/***
 * A location within a bounding box, expressed as a percentage of the bounding
 * box's dimensions.
 */
public class Location {
	private double xPercent;
	private double yPercent;

	public Location(double x, double y) {
		xPercent = x;
		yPercent = y;
	}
}
