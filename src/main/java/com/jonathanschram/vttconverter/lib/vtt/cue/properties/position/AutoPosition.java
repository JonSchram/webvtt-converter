package com.jonathanschram.vttconverter.lib.vtt.cue.properties.position;

public class AutoPosition implements Position {
    // TODO: Make a singleton instance to reduce object instantiations.

    @Override
    public boolean equals(Object obj) {
        // All auto positions are equal to each other.
        return obj instanceof AutoPosition;
    }
}
