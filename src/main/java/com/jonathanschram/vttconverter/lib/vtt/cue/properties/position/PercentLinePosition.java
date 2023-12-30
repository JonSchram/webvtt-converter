package com.jonathanschram.vttconverter.lib.vtt.cue.properties.position;

/***
 * A line position whose position is a percent of the video's width (or of the
 * height if the text is vertical).
 */
public class PercentLinePosition implements Position {
	private int percent;

	public PercentLinePosition(int percent) {
		super();
		this.percent = percent;
	}

	public int getPercent() {
		return percent;
	}

}
