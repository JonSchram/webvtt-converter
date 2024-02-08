package com.jonathanschram.vttconverter.lib.vtt.cue.node;

import com.jonathanschram.vttconverter.lib.vtt.css.NodeStyle;
import com.jonathanschram.vttconverter.lib.vtt.cue.NodeVisitor;

public abstract class VttNode {

    /***
     * 
     * @param <T> Type of built node.
     * @param <B> Type of builder.
     */
    public static abstract class Builder<T extends VttNode> {

        public abstract T build();
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
