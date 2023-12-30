package com.jonathanschram.vttconverter.lib.vtt.cue.properties.line;

public enum LineAlignment {
	/***
	 * The cue box is at the top (horizontal cue), left side (vertical growing
	 * right), or right side (vertical growing left) of the screen.
	 */
	START,

	/*** The cue box is centered at the specified line. */
	CENTER,

	/***
	 * The cue box is at the bottom (horizontal cue), right side (vertical growing
	 * right), or left side (vertical growing left) of the screen.
	 */
	END
}
