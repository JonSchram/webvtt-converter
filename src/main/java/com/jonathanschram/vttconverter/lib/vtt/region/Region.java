package com.jonathanschram.vttconverter.lib.vtt.region;

/***
 * A named screen region that cues can be placed into instead of rendering over
 * the entire video.
 */
public class Region {
	private String identifier;
	private int widthPercent;
	private int lineCount;
	/***
	 * The location in the region that should stay in the same place on screen.
	 */
	private Location regionAnchor;
	
	/***
	 * The location in the video that the region anchor should be rendered at.
	 */
	private Location viewportAnchor;
	
	private boolean scroll;
}
