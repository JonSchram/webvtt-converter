package com.jonathanschram.vttconverter.lib.vtt.cue.node;

public class BoldNode extends InternalNode {

    public static class Builder extends InternalNode.Builder {

        @Override
        public BoldNode build() {
            return new BoldNode(this);
        }

    }

    public BoldNode(Builder builder) {
        super(builder);
    }

}
