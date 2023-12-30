package com.jonathanschram.vttconverter.lib.vtt.cue.properties.line;

/***
 * A line property that specifies the alignment of a line as a percentage of the
 * video height (or if the line is vertical, the video width).
 */
public class PercentageLine implements LineProperties {
	private int percent;

	public PercentageLine(int percent) {
		super();
		this.percent = percent;
	}

	public int getPercent() {
		return percent;
	}
}
