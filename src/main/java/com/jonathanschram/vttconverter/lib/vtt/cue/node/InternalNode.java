package com.jonathanschram.vttconverter.lib.vtt.cue.node;

import java.util.ArrayList;
import java.util.List;

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

    public List<VttNode> getChildren() {
        return children;
    }

    public List<String> getClasses() {
        return classes;
    }

    public String getApplicableLanguage() {
        return applicableLanguage;
    }

}
