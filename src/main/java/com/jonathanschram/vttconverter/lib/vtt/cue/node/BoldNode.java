package com.jonathanschram.vttconverter.lib.vtt.cue.node;

import com.jonathanschram.vttconverter.lib.vtt.cue.NodeVisitor;

public class BoldNode extends InternalNode {

    public static class Builder extends InternalNode.Builder<BoldNode, Builder> {

        @Override
        public BoldNode build() {
            return new BoldNode(this);
        }

        @Override
        public Builder getThis() {
            return this;
        }

    }

    public BoldNode(Builder builder) {
        super(builder);
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visitBoldNode(this);
        super.accept(visitor);
    }

}
