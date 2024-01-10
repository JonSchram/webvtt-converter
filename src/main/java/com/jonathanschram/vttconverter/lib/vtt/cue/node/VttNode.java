package com.jonathanschram.vttconverter.lib.vtt.cue.node;

public abstract class VttNode {

    public static abstract class Builder {

        public abstract VttNode build();
    }
}
