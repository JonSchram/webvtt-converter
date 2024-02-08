package com.jonathanschram.vttconverter.lib.vtt.cue.node;

import com.jonathanschram.vttconverter.lib.vtt.cue.NodeVisitor;

/***
 * The node wrapping the entire text node.
 * 
 * Required because we need a concrete instance of an internal node to wrap the
 * entire cue text.
 */
public class RootCueNode extends InternalNode {

    public static class Builder extends InternalNode.Builder<RootCueNode, Builder> {
        @Override
        public Builder getThis() {
            return this;
        }

        @Override
        public RootCueNode build() {
            return new RootCueNode(this);
        }

    }

    public RootCueNode(Builder builder) {
        super(builder);
    }

    public RootCueNode() {
        super();
    }

    @Override
    public void accept(NodeVisitor visitor) {
        super.accept(visitor);
    }

}
