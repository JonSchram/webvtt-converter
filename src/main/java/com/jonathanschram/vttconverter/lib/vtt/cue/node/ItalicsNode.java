package com.jonathanschram.vttconverter.lib.vtt.cue.node;

import com.jonathanschram.vttconverter.lib.vtt.cue.NodeVisitor;

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

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visitItalicsNode(this);
        super.accept(visitor);
    }
}
