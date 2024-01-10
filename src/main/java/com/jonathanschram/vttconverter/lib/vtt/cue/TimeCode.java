package com.jonathanschram.vttconverter.lib.vtt.cue;

import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TimeCode other = (TimeCode) obj;
        return hours == other.hours && milliseconds == other.milliseconds && minutes == other.minutes
                && seconds == other.seconds;
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
    public int hashCode() {
        return Objects.hash(hours, milliseconds, minutes, seconds);
    }

    @Override
    public String toString() {
        return String.format("%d:%02d:%02d.%03d", hours, minutes, seconds, milliseconds);
    }

}
