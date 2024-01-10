package com.jonathanschram.vttconverter.lib.vtt.cue.node;

public class ClassNode extends InternalNode {

    public static class Builder extends InternalNode.Builder {

        @Override
        public ClassNode build() {
            return new ClassNode(this);
        }

    }

    public ClassNode(Builder builder) {
        super(builder);
    }
}
