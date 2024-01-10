package com.jonathanschram.vttconverter.lib.vtt.cue.node;

public class LanguageNode extends InternalNode {
    public static class Builder extends InternalNode.Builder {
        @Override
        public LanguageNode build() {
            return new LanguageNode(this);
        }
    }

    public LanguageNode(Builder builder) {
        super(builder);
    }
}
