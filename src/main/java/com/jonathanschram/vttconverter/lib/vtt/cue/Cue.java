package com.jonathanschram.vttconverter.lib.vtt.cue;

import com.jonathanschram.vttconverter.lib.vtt.cue.node.RootCueNode;
import com.jonathanschram.vttconverter.lib.vtt.cue.properties.TextAlignment;
import com.jonathanschram.vttconverter.lib.vtt.cue.properties.WritingDirection;
import com.jonathanschram.vttconverter.lib.vtt.cue.properties.line.AutoLine;
import com.jonathanschram.vttconverter.lib.vtt.cue.properties.line.LineAlignment;
import com.jonathanschram.vttconverter.lib.vtt.cue.properties.line.LineSetting;
import com.jonathanschram.vttconverter.lib.vtt.cue.properties.position.AutoPosition;
import com.jonathanschram.vttconverter.lib.vtt.cue.properties.position.Position;
import com.jonathanschram.vttconverter.lib.vtt.cue.properties.position.PositionAlignment;

public class Cue {
    public static class Builder {
        protected String identifier;
        protected TimeCode start;
        protected TimeCode end;
        protected RootCueNode payload;

        // Default cue settings.
        protected boolean pauseOnExit = false;
        protected String regionId = null;
        protected WritingDirection direction = WritingDirection.HORIZONTAL;
        protected boolean snapToLines = true;
        protected LineSetting line = new AutoLine();
        protected LineAlignment lineAlign = LineAlignment.START;
        protected Position position = new AutoPosition();
        protected PositionAlignment positionAlign = PositionAlignment.AUTO;
        protected double size = 100;
        protected TextAlignment textAlign = TextAlignment.CENTER;

        public Cue build() {
            if (!(line instanceof AutoLine) || size == 100.0) {
                // An explicitly set line number or a resized line is incompatible with a
                // region, reset region id.
                // Yes comparing doubles is bad but this is the easiest way.
                this.regionId = null;
            }
            return new Cue(this);
        }

        public Builder setDirection(WritingDirection direction) {
            this.direction = direction;
            return this;
        }

        public Builder setEnd(TimeCode end) {
            this.end = end;
            return this;
        }

        public Builder setIdentifier(String identifier) {
            this.identifier = identifier;
            return this;
        }

        public Builder setLine(LineSetting line) {
            this.line = line;
            return this;
        }

        public Builder setLineAlign(LineAlignment lineAlign) {
            this.lineAlign = lineAlign;
            return this;
        }

        public Builder setPauseOnExit(boolean pauseOnExit) {
            this.pauseOnExit = pauseOnExit;
            return this;
        }

        public Builder setPayload(RootCueNode payload) {
            this.payload = payload;
            return this;
        }

        public Builder setPosition(Position position) {
            this.position = position;
            return this;
        }

        public Builder setPositionAlign(PositionAlignment positionAlign) {
            this.positionAlign = positionAlign;
            return this;
        }

        public Builder setRegionId(String regionId) {
            this.regionId = regionId;
            return this;
        }

        public Builder setSize(double size) {
            this.size = size;
            return this;
        }

        public Builder setSnapToLines(boolean snapToLines) {
            this.snapToLines = snapToLines;
            return this;
        }

        public Builder setStart(TimeCode start) {
            this.start = start;
            return this;
        }

        public Builder setTextAlign(TextAlignment textAlign) {
            this.textAlign = textAlign;
            return this;
        }

    }

    /*** A string uniquely naming this cue. */
    private final String identifier;

    /*** The {@link TimeCode} when this cue should start being displayed. */
    private final TimeCode start;
    /*** The {@link TimeCode} when this cue should stop being displayed. */
    private final TimeCode end;

    /*** Text payload of the cue, possibly containing HTML tags. */
    private final RootCueNode payload;

    /*** Whether playback will pause at the end of this cue. */
    private final boolean pauseOnExit;

    // TODO: May want to store the actual region in here. Would require refactoring
    // the builder.
    /*** The ID of the region to display this cue in. */
    private final String regionId;

    /*** The writing direction for the cue text. */
    private final WritingDirection direction;

    /*** How to position the cue's line. */
    private final LineSetting line;

    /***
     * Whether the cue will snap to a line position. False if the cue is rendered as
     * a percent of the viewport.
     */
    private final boolean snapToLines;

    /*** Where the line is displayed on the cross-axis to the text direction. */
    private final LineAlignment lineAlign;

    /*** Where the cue box is indented along the cue direction. */
    private final Position position;

    // TODO: Support position alignment. This isn't supported by most browsers, so
    // it isn't a high priority.
    /*** The cue box's alignment along the cue direction. */
    private final PositionAlignment positionAlign;

    /*** The percent of the video width that the cue box occupies. */
    private final double size;

    /*** How the text should be aligned within the cue box. */
    private final TextAlignment textAlign;

    public Cue(Builder builder) {
        this.identifier = builder.identifier;
        this.start = builder.start;
        this.end = builder.end;
        this.payload = builder.payload;
        this.pauseOnExit = builder.pauseOnExit;
        this.regionId = builder.regionId;
        this.direction = builder.direction;
        this.snapToLines = builder.snapToLines;
        this.line = builder.line;
        this.lineAlign = builder.lineAlign;
        this.position = builder.position;
        this.positionAlign = builder.positionAlign;
        this.size = builder.size;
        this.textAlign = builder.textAlign;
    }

    public WritingDirection getDirection() {
        return direction;
    }

    public TimeCode getEnd() {
        return end;
    }

    public String getIdentifier() {
        return identifier;
    }

    public LineSetting getLine() {
        return line;
    }

    public LineAlignment getLineAlign() {
        return lineAlign;
    }

    public RootCueNode getPayload() {
        return payload;
    }

    public Position getPosition() {
        return position;
    }

    public PositionAlignment getPositionAlign() {
        return positionAlign;
    }

    public String getRegionId() {
        return regionId;
    }

    public double getSize() {
        return size;
    }

    public TimeCode getStart() {
        return start;
    }

    public TextAlignment getTextAlign() {
        return textAlign;
    }

    public boolean isPauseOnExit() {
        return pauseOnExit;
    }

    public boolean isSnapToLines() {
        return snapToLines;
    }
}
