package com.jonathanschram.vttconverter.lib.vtt.parsing;

import com.jonathanschram.vttconverter.lib.vtt.cue.TimeCode;
import com.jonathanschram.vttconverter.lib.vtt.cue.properties.TextAlignment;
import com.jonathanschram.vttconverter.lib.vtt.cue.properties.WritingDirection;
import com.jonathanschram.vttconverter.lib.vtt.cue.properties.line.AutoLine;
import com.jonathanschram.vttconverter.lib.vtt.cue.properties.line.LineAlignment;
import com.jonathanschram.vttconverter.lib.vtt.cue.properties.line.LineProperties;
import com.jonathanschram.vttconverter.lib.vtt.cue.properties.position.AutoPosition;
import com.jonathanschram.vttconverter.lib.vtt.cue.properties.position.Position;
import com.jonathanschram.vttconverter.lib.vtt.cue.properties.position.PositionAlignment;

public class RawCue {

	public static class Builder {
		/*** A string uniquely naming this cue. */
		private String identifier = null;

		/*** The start time of the cue. */
		private TimeCode start;
		/*** The end time of the cue. */
		private TimeCode end;

		/*** The text to display in this cue, before parsing HTML tags. */
		private String rawText;

		/*** Whether playback will pause at the end of this cue. */
		private boolean pauseOnExit = false;

		/*** The ID of the region to display this cue in. */
		private String regionId = null;

		/*** The writing direction for the cue text. */
		private WritingDirection direction = WritingDirection.HORIZONTAL;

		/***
		 * Whether the cue position is specified by an integer number of lines, or if it
		 * is displayed as a percentage of the video size.
		 */
		private boolean snapToLines = true;
		/*** How to position the cue's line. */
		private LineProperties line = new AutoLine();
		/*** Where the line is displayed on the cross-axis to the text direction. */
		private LineAlignment lineAlign = LineAlignment.START;

		/*** Where the cue box is indented along the cue direction. */
		private Position position = new AutoPosition();
		/***
		 * The cue box's alignment along the cue direction.
		 * 
		 * Position alignment isn't supported by most browsers, so this isn't a high
		 * priority.
		 */
		private PositionAlignment positionAlign = PositionAlignment.AUTO;

		/*** The percent of the video width that the cue box occupies. */
		private int size = 100;
		/*** How the text should be aligned within the cue box. */
		private TextAlignment textAlign = TextAlignment.CENTER;

		public Builder(TimeCode start, TimeCode end) {
			this.start = start;
			this.end = end;
		}

		public RawCue build() {
			return new RawCue(this);
		}

		public void setDirection(WritingDirection direction) {
			this.direction = direction;
		}

		public void setIdentifier(String identifier) {
			this.identifier = identifier;
		}

		public void setLine(LineProperties line) {
			this.line = line;
		}

		public void setLineAlign(LineAlignment lineAlign) {
			this.lineAlign = lineAlign;
		}

		public void setPauseOnExit(boolean pauseOnExit) {
			this.pauseOnExit = pauseOnExit;
		}

		public void setPosition(Position position) {
			this.position = position;
		}

		public void setPositionAlign(PositionAlignment positionAlign) {
			this.positionAlign = positionAlign;
		}

		public void setRawText(String rawText) {
			this.rawText = rawText;
		}

		public void setRegionId(String regionId) {
			this.regionId = regionId;
		}

		public void setSize(int size) {
			this.size = size;
		}

		public void setSnapToLines(boolean snapToLines) {
			this.snapToLines = snapToLines;
		}

		public void setTextAlign(TextAlignment textAlign) {
			this.textAlign = textAlign;
		}
	}

	/***
	 * Cue text before it has been converted to a node tree.
	 */
	private String rawText;

	private TimeCode start;


	private TimeCode end;


	private String identifier;


	private boolean pauseOnExit;


	private String regionId;


	private WritingDirection direction;


	private boolean snapToLines;


	private LineProperties line;


	private LineAlignment lineAlign;


	// PositionAlign isn't supported by most browsers, so this isn't a high
	// priority.
	private Position position;


	private PositionAlignment positionAlign;


	private TextAlignment textAlign;


	private int size;


	public RawCue(Builder builder) {
		this.rawText = builder.rawText;
		this.start = builder.start;
		this.end = builder.end;

		this.identifier = builder.identifier;
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
	public LineProperties getLine() {
		return line;
	}
	public LineAlignment getLineAlign() {
		return lineAlign;
	}
	public Position getPosition() {
		return position;
	}
	public PositionAlignment getPositionAlign() {
		return positionAlign;
	}
	public String getRawText() {
		return rawText;
	}
	public String getRegionId() {
		return regionId;
	}
	public int getSize() {
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
