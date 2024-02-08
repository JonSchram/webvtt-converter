package com.jonathanschram.vttconverter.lib.vtt.cue.node;

import com.jonathanschram.vttconverter.lib.vtt.cue.NodeVisitor;

public class UnderlineNode extends InternalNode {

    public static class Builder extends InternalNode.Builder<UnderlineNode, Builder> {
        @Override
        public UnderlineNode build() {
            return new UnderlineNode(this);
        }

        @Override
        public Builder getThis() {
            return this;
        }
    }

    public UnderlineNode(Builder builder) {
        super(builder);
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visitUnderlineNode(this);
        super.accept(visitor);
    }

}
