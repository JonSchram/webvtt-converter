package com.jonathanschram.vttconverter.lib.vtt.cue.node;

/***
 * An ordered collection of ruby base text and ruby text.
 */
public class RubyNode extends InternalNode {
    public static class Builder extends InternalNode.Builder {

        @Override
        public RubyNode build() {
            return new RubyNode(this);
        }
    }

    public RubyNode(Builder builder) {
        super(builder);
    }
}
