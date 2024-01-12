package com.jonathanschram.vttconverter.lib.vtt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jonathanschram.vttconverter.lib.vtt.css.RawCssBlock;
import com.jonathanschram.vttconverter.lib.vtt.cue.Cue;
import com.jonathanschram.vttconverter.lib.vtt.region.Region;

public class VttObject {
    public static class Builder {
        private List<RawCssBlock> styleSheet = new ArrayList<>();
        private Map<String, Region> regions = new HashMap<>();
        private List<Cue> cues = new ArrayList<>();

        public Builder addRawCss(RawCssBlock rawCss) {
            styleSheet.add(rawCss);
            return this;
        }

        public Builder addCue(Cue cue) {
            cues.add(cue);
            return this;
        }

        public Builder addRegion(Region region) {
            regions.put(region.getIdentifier(), region);
            return this;
        }

        public VttObject build() {
            return new VttObject(this);
        }
    }

    // TODO: Parse CSS styles. Parsing can be quite complicated and matching CSS
    // selectors to nodes is really complicated, so this is not needed right away.
    private final List<RawCssBlock> cssBlocks;
    private final Map<String, Region> regions;

    private final List<Cue> cues;

    public VttObject(Builder builder) {
        this.cssBlocks = List.copyOf(builder.styleSheet);
        this.regions = Map.copyOf(builder.regions);
        this.cues = List.copyOf(builder.cues);
    }

    /***
     * Returns an unmodifiable list of the css blocks in this VTT object.
     * 
     * @return
     */
    public List<RawCssBlock> getCssBlocks() {
        return cssBlocks;
    }

    /***
     * Returns an unmodifiable list of the regions in this VTT object.
     * 
     * @return
     */
    public Map<String, Region> getRegions() {
        return regions;
    }

    /***
     * Returns an unmodifiable list of the cues in this VTT object.
     * 
     * @return
     */
    public List<Cue> getCues() {
        return cues;
    }
}
