package com.jonathanschram.vttconverter.lib.vtt.cue;

public class TimeCode {
	private int hours;
	private int minutes;
	private int seconds;
	private int milliseconds;

	public TimeCode(int hours, int minutes, int seconds, int milliseconds) {
		super();
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
		this.milliseconds = milliseconds;
	}

	public int getHours() {
		return hours;
	}

	public int getMilliseconds() {
		return milliseconds;
	}

	public int getMinutes() {
		return minutes;
	}

	public int getSeconds() {
		return seconds;
	}

	@Override
	public String toString() {
		return String.format("%d:%02d:%02d.%03d", hours, minutes, seconds, milliseconds);
	}

}
