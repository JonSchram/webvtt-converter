package com.jonathanschram.vttconverter.lib.vtt.cue.node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import com.jonathanschram.vttconverter.lib.vtt.cue.NodeVisitor;

public abstract class InternalNode extends VttNode {
    public static abstract class Builder extends VttNode.Builder {
        protected List<VttNode.Builder> children = new ArrayList<>();
        protected List<String> classes = null;
        protected String applicableLanguage;

        public Builder appendChild(VttNode.Builder child) {
            this.children.add(child);
            return this;
        }

        public Builder setApplicableLanguage(String applicableLanguage) {
            this.applicableLanguage = applicableLanguage;
            return this;
        }

        public Builder setClasses(List<String> classes) {
            this.classes = classes;
            return this;
        }

    }

    protected final List<VttNode> children;

    protected final List<String> classes;

    protected final String applicableLanguage;

    public InternalNode() {
        this.classes = new ArrayList<>();
        this.children = new ArrayList<>();
        this.applicableLanguage = "";
    }

    public InternalNode(Builder builder) {
        if (builder.children != null) {
            this.children = new ArrayList<>();
            for (VttNode.Builder childBuilder : builder.children) {
                this.children.add(childBuilder.build());
            }
        } else {
            this.children = new ArrayList<>();
        }

        this.classes = new ArrayList<>();
        if (builder.classes != null) {
            for (String c : builder.classes) {
                if (!"".equals(c)) {
                    this.classes.add(c);
                }
            }
        }
        this.applicableLanguage = builder.applicableLanguage;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        InternalNode other = (InternalNode) obj;
        return Objects.equals(applicableLanguage, other.applicableLanguage) && Objects.equals(children, other.children)
                && Objects.equals(classes, other.classes);
    }

    @Override
    public void accept(NodeVisitor visitor) {
        for (VttNode vttNode : children) {
            vttNode.accept(visitor);
        }
    }

    public String getApplicableLanguage() {
        return applicableLanguage;
    }

    /***
     * Returns an unmodifiable view of the child nodes.
     * 
     * @return
     */
    public List<VttNode> getChildren() {
        return Collections.unmodifiableList(children);
    }

    /***
     * Returns an unmodifiable view of the classes on this node.
     * 
     * @return
     */
    public List<String> getClasses() {
        return Collections.unmodifiableList(classes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(applicableLanguage, children, classes);
    }

}
