package com.jonathanschram.vttconverter.lib.vtt.cue;

public record TimeCode(int hours, int minutes, int seconds, int milliseconds) {

    @Override
    public String toString() {
        return String.format("%d:%02d:%02d.%03d", hours, minutes, seconds, milliseconds);
    }

}
