package com.jonathanschram.vttconverter.lib.vtt.cue.node;

/***
 * The node wrapping the entire text node.
 * 
 * Required because we need a concrete instance of an internal node to wrap the
 * entire cue text.
 */
public class RootCueNode extends InternalNode {

    public static class Builder extends InternalNode.Builder {

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

}
