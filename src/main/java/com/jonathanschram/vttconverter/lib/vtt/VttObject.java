package com.jonathanschram.vttconverter.lib.vtt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jonathanschram.vttconverter.lib.vtt.css.RawCssBlock;
import com.jonathanschram.vttconverter.lib.vtt.css.Rule;
import com.jonathanschram.vttconverter.lib.vtt.cue.Cue;
import com.jonathanschram.vttconverter.lib.vtt.region.Region;

public class VttObject {
	// TODO: Parse CSS styles. Parsing can be quite complicated and matching CSS
	// selectors to nodes is really complicated, so this is not needed right away.
	private List<RawCssBlock> cssBlocks;
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
