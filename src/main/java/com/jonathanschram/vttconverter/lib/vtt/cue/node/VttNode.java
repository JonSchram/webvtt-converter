package com.jonathanschram.vttconverter.lib.vtt.cue.node;

import com.jonathanschram.vttconverter.lib.vtt.css.NodeStyle;
import com.jonathanschram.vttconverter.lib.vtt.cue.NodeVisitor;

public abstract class VttNode {

    public static abstract class Builder {

        public abstract VttNode build();
    }

    private final NodeStyle style;

    public VttNode() {
        this.style = new NodeStyle();
    }

    public abstract void accept(NodeVisitor visitor);

    public NodeStyle getStyle() {
        return style;
    }
}
