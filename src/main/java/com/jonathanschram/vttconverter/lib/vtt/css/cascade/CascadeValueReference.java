package com.jonathanschram.vttconverter.lib.vtt.css.cascade;

/**
 * A class that contains the current node's value and the parent node's value,
 * allowing a cascading value to choose an appropriate value.
 * 
 * @param <T>
 */
public class CascadeValueReference<T> {

    private final T parentValue;
    private final T selfValue;

    public CascadeValueReference(T parentValue, T selfValue) {
        this.parentValue = parentValue;
        this.selfValue = selfValue;
    }

    public T getParentValue() {
        return parentValue;
    }

    public T getSelfValue() {
        return selfValue;
    }

}
