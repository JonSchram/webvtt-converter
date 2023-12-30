package com.jonathanschram.vttconverter.lib.vtt.cue.properties.line;

/***
 * An implementation of {@link LineProperties} that specifies a line number on
 * screen.
 */
public class AbsoluteLine implements LineProperties {
	private int lineNumber;
	private boolean fromBottom;

	public AbsoluteLine(int lineNumber, boolean fromBottom) {
		super();
		this.lineNumber = lineNumber;
		this.fromBottom = fromBottom;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public boolean isFromBottom() {
		return fromBottom;
	}
}
