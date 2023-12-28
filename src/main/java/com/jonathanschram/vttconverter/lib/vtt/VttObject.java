package com.jonathanschram.vttconverter.lib.vtt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jonathanschram.vttconverter.lib.vtt.css.Rule;
import com.jonathanschram.vttconverter.lib.vtt.cue.Cue;
import com.jonathanschram.vttconverter.lib.vtt.region.Region;

public class VttObject {
	private List<Rule> styleSheet;
	private Map<String, Region> regions;
	private List<Cue> cues;

	
	public static class Builder {
		private List<Rule> styleSheet = new ArrayList<>();
		private Map<String, Region> regions = new HashMap<>();
		private List<Cue> cues = new ArrayList<>();
		
		public Builder addCssRule(Rule rule) {
			styleSheet.add(rule);
			return this;
		}
		
		public Builder addRegion(Region region) {
			regions.put(region.getIdentifier(), region);
			return this;
		}
		
		public Builder addCue(Cue cue) {
			cues.add(cue);
			return this;
		}
		
		public VttObject build() {
			// TODO
			return new VttObject();
		}
	}
}
