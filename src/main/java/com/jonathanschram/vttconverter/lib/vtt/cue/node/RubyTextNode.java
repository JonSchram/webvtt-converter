package com.jonathanschram.vttconverter.lib.vtt.cue.node;

import com.jonathanschram.vttconverter.lib.vtt.cue.NodeVisitor;

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

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visitRubyTextNode(this);
        super.accept(visitor);
    }
}
