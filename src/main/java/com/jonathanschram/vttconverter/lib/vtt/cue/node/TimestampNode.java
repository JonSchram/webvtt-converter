package com.jonathanschram.vttconverter.lib.vtt.cue.node;

import com.jonathanschram.vttconverter.lib.vtt.cue.TimeCode;

/***
 * A node that indicates a time at which the text that follows it should appear.
 */
public class TimestampNode extends VttNode {
	private TimeCode time;
}
