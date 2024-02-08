package com.jonathanschram.vttconverter.lib.vtt.cue.node;

import com.jonathanschram.vttconverter.lib.vtt.cue.NodeVisitor;

public class LanguageNode extends InternalNode {
    public static class Builder extends InternalNode.Builder<LanguageNode, Builder> {
        @Override
        public LanguageNode build() {
            return new LanguageNode(this);
        }

        @Override
        public Builder getThis() {
            return this;
        }
    }

    public LanguageNode(Builder builder) {
        super(builder);
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visitLanguageNode(this);
        super.accept(visitor);
    }
}
