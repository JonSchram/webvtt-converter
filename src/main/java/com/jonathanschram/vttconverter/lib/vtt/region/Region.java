package com.jonathanschram.vttconverter.lib.vtt.region;

/***
 * A named screen region that cues can be placed into instead of rendering over
 * the entire video.
 */
public class Region {
    public static class Builder {
        private String identifier = "";
        private double widthPercent = 100;
        private int lineCount = 3;
        private Location regionAnchor = new Location(0, 100);
        private Location viewportAnchor = new Location(0, 100);
        private boolean scroll = false;

        public Builder() {
        }

        public Region build() {
            return new Region(this);
        }

        public void setIdentifier(String identifier) {
            this.identifier = identifier;
        }

        public void setLineCount(int lineCount) {
            this.lineCount = lineCount;
        }

        public void setRegionAnchor(Location regionAnchor) {
            this.regionAnchor = regionAnchor;
        }

        public void setScroll(boolean scroll) {
            this.scroll = scroll;
        }

        public void setViewportAnchor(Location viewportAnchor) {
            this.viewportAnchor = viewportAnchor;
        }

        public void setWidthPercent(double widthPercent) {
            this.widthPercent = widthPercent;
        }
    }

    private final String identifier;
    private final double widthPercent;
    private final int lineCount;

    /***
     * The location in the region that should stay in the same place on screen.
     */
    private final Location regionAnchor;

    /***
     * The location in the video that the region anchor should be rendered at.
     */
    private final Location viewportAnchor;

    private final boolean scroll;

    public Region(Builder builder) {
        this.identifier = builder.identifier;
        this.widthPercent = builder.widthPercent;
        this.lineCount = builder.lineCount;
        this.regionAnchor = builder.regionAnchor;
        this.viewportAnchor = builder.viewportAnchor;
        this.scroll = builder.scroll;
    }

    public String getIdentifier() {
        return identifier;
    }

    public int getLineCount() {
        return lineCount;
    }

    public Location getRegionAnchor() {
        return regionAnchor;
    }

    public Location getViewportAnchor() {
        return viewportAnchor;
    }

    public double getWidthPercent() {
        return widthPercent;
    }

    public boolean isScroll() {
        return scroll;
    }
}
