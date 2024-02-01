package com.jonathanschram.vttconverter.lib.vtt.cue.node;

import java.util.Objects;

import com.jonathanschram.vttconverter.lib.vtt.cue.NodeVisitor;

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

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visitTextNode(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TextNode other = (TextNode) obj;
        return Objects.equals(text, other.text);
    }

    public String getText() {
        return text;
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }

}
