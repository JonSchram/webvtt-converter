package com.jonathanschram.vttconverter.lib.vtt.cue.node;

public class ItalicsNode extends InternalNode {

    public static class Builder extends InternalNode.Builder {

        @Override
        public ItalicsNode build() {
            return new ItalicsNode(this);
        }
    }

    public ItalicsNode(Builder builder) {
        super(builder);
    }
}
