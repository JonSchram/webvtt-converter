package com.jonathanschram.vttconverter.lib.vtt.cue.node;

public class UnderlineNode extends InternalNode {

    public static class Builder extends InternalNode.Builder {
        @Override
        public UnderlineNode build() {
            return new UnderlineNode(this);
        }
    }

    public UnderlineNode(Builder builder) {
        super(builder);
    }

}
