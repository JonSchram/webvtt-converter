package com.jonathanschram.vttconverter.lib.vtt.cue.node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import com.jonathanschram.vttconverter.lib.vtt.cue.NodeVisitor;

public abstract class InternalNode extends VttNode {
    /***
     * 
     * @param <T> Type of node being built.
     * @param <B> Type of builder returned by method chaining.
     */
    public static abstract class Builder<T extends InternalNode, B extends InternalNode.Builder<T, B>>
            extends VttNode.Builder<T> {
        protected List<VttNode> children = new ArrayList<>();
        protected List<String> classes = null;
        protected String applicableLanguage;

        /***
         * Returns a reference to the current builder type, to allow builder methods to
         * return a type-safe reference to <code>this</code>.
         * 
         * <p>
         * Strategy from
         * <a href="https://stackoverflow.com/users/3114959/stepan-vavra">Stepan
         * Vavra</a> on this
         * <a href="https://stackoverflow.com/a/34741836">StackOverflow answer</a>
         */
        public abstract B getThis();

        public B appendChild(VttNode.Builder<? extends VttNode> child) {
            this.children.add(child.build());
            return getThis();
        }

        public B appendChild(VttNode child) {
            this.children.add(child);
            return getThis();
        }

        public B setApplicableLanguage(String applicableLanguage) {
            this.applicableLanguage = applicableLanguage;
            return getThis();
        }

        public B setClasses(List<String> classes) {
            this.classes = classes;
            return getThis();
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

    public <B extends InternalNode.Builder<? extends VttNode, B>> InternalNode(B builder) {
        if (builder.children != null) {
            this.children = Collections.unmodifiableList(builder.children);
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
        // Children is already an unmodifiable list.
        return children;
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
