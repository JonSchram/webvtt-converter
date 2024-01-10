package com.jonathanschram.vttconverter.lib.vtt.cue.node;

public class TextNode extends VttNode {
    public static class Builder extends VttNode.Builder {

        private String text;

        @Override
        public TextNode build() {
            return new TextNode(this);
        }

        public Builder setText(String text) {
            this.text = text;
            return this;
        }

    }

    private String text;

    public TextNode(Builder builder) {
        super();
        this.text = builder.text;
    }

    public String getText() {
        return text;
    }

}
