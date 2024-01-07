package com.jonathanschram.vttconverter.lib.vtt.parsing.cuetext;

import com.jonathanschram.vttconverter.lib.vtt.cue.node.VttNode;

/***
 * Parser for cue text. This works a lot like HTML, but it only supports a
 * subset of HTML tags, and there is no explicit root tag around the entire
 * text.
 */
public class CueTextParser {
	public CueTextParser() {

	}

	public VttNode parse() {

		
		
		return null;
	}
	
	private static class RawTag {
		private String tagName;
		private String attribute;
		
	}

}
