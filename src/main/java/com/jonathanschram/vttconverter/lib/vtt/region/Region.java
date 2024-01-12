package com.jonathanschram.vttconverter.lib.vtt.region;

import java.util.Objects;

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

        public Builder setIdentifier(String identifier) {
            this.identifier = identifier;
            return this;
        }

        public Builder setLineCount(int lineCount) {
            this.lineCount = lineCount;
            return this;
        }

        public Builder setRegionAnchor(Location regionAnchor) {
            this.regionAnchor = regionAnchor;
            return this;
        }

        public Builder setScroll(boolean scroll) {
            this.scroll = scroll;
            return this;
        }

        public Builder setViewportAnchor(Location viewportAnchor) {
            this.viewportAnchor = viewportAnchor;
            return this;
        }

        public Builder setWidthPercent(double widthPercent) {
            this.widthPercent = widthPercent;
            return this;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Region other = (Region) obj;
        return Objects.equals(identifier, other.identifier) && lineCount == other.lineCount
                && Objects.equals(regionAnchor, other.regionAnchor) && scroll == other.scroll
                && Objects.equals(viewportAnchor, other.viewportAnchor)
                && Double.doubleToLongBits(widthPercent) == Double.doubleToLongBits(other.widthPercent);
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

    @Override
    public int hashCode() {
        return Objects.hash(identifier, lineCount, regionAnchor, scroll, viewportAnchor, widthPercent);
    }

    public boolean isScroll() {
        return scroll;
    }
}
