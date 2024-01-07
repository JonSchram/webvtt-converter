package com.jonathanschram.vttconverter.lib.vtt.cue;

import java.util.List;

import com.jonathanschram.vttconverter.lib.vtt.cue.node.VttNode;
import com.jonathanschram.vttconverter.lib.vtt.cue.properties.TextAlignment;
import com.jonathanschram.vttconverter.lib.vtt.cue.properties.WritingDirection;
import com.jonathanschram.vttconverter.lib.vtt.cue.properties.line.AutoLine;
import com.jonathanschram.vttconverter.lib.vtt.cue.properties.line.LineAlignment;
import com.jonathanschram.vttconverter.lib.vtt.cue.properties.line.LineProperties;
import com.jonathanschram.vttconverter.lib.vtt.cue.properties.position.AutoPosition;
import com.jonathanschram.vttconverter.lib.vtt.cue.properties.position.Position;
import com.jonathanschram.vttconverter.lib.vtt.cue.properties.position.PositionAlignment;

public class Cue {
	private TimeCode start;
	private TimeCode end;
	
	/*** Text payload of the cue, possibly containing HTML tags. */
	private VttNode payload;
	

	/*** Whether playback will pause at the end of this cue. */
	private boolean pauseOnExit = false;

	/*** The ID of the region to display this cue in. */
	private String regionId = null;

	/*** The writing direction for the cue text. */
	private WritingDirection direction = WritingDirection.HORIZONTAL;

	/***
	 * Whether the cue position is specified by an integer number of lines, or if it
	 * is displayed as a percentage of the video size.
	 */
	private boolean snapToLines = true;
	/*** How to position the cue's line. */
	private LineProperties line = new AutoLine();
	/*** Where the line is displayed on the cross-axis to the text direction. */
	private LineAlignment lineAlign = LineAlignment.START;

	/*** Where the cue box is indented along the cue direction. */
	private Position position = new AutoPosition();
	/***
	 * The cue box's alignment along the cue direction.
	 * 
	 * Position alignment isn't supported by most browsers, so this isn't a high
	 * priority.
	 */
	private PositionAlignment positionAlign = PositionAlignment.AUTO;

	/*** The percent of the video width that the cue box occupies. */
	private int size = 100;
	/*** How the text should be aligned within the cue box. */
	private TextAlignment textAlign = TextAlignment.CENTER;
}
