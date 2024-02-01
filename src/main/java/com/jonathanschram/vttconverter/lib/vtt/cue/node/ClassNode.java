package com.jonathanschram.vttconverter.lib.vtt.cue.node;

import com.jonathanschram.vttconverter.lib.vtt.cue.NodeVisitor;

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

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visitClassNode(this);
        super.accept(visitor);
    }
}
