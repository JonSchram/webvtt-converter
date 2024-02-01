package com.jonathanschram.vttconverter.lib.vtt.cue.node;

import com.jonathanschram.vttconverter.lib.vtt.cue.NodeVisitor;

public abstract class VttNode {
    
    public abstract void accept(NodeVisitor visitor);

    public static abstract class Builder {

        public abstract VttNode build();
    }
}
