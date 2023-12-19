package com.jonathanschram.vttconverter.lib.vtt.cue;

import java.util.List;

import com.jonathanschram.vttconverter.lib.vtt.cue.node.VttNode;

public class Cue {
	private TimeCode start;
	private TimeCode end;
	private List<VttLine> lines;

	private class VttLine {
		private List<VttNode> spans;
	}
}
