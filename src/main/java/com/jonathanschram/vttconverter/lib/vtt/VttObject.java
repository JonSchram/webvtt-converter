package com.jonathanschram.vttconverter.lib.vtt;

import java.util.Dictionary;
import java.util.List;

import com.jonathanschram.vttconverter.lib.vtt.css.Rule;
import com.jonathanschram.vttconverter.lib.vtt.cue.Cue;
import com.jonathanschram.vttconverter.lib.vtt.region.Region;

public class VttObject {
	private List<Rule> styleSheet;
	private Dictionary<String, Region> regions;
	private List<Cue> cues;

}
