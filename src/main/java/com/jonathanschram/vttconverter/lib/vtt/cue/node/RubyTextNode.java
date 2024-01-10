package com.jonathanschram.vttconverter.lib.vtt.cue.node;

public class RubyTextNode extends InternalNode {

    public static class Builder extends InternalNode.Builder {
        @Override
        public RubyTextNode build() {
            return new RubyTextNode(this);
        }
    }

    public RubyTextNode(Builder builder) {
        super(builder);
    }
}
