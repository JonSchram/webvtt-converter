package com.jonathanschram.vttconverter.lib.vtt.css.cascade;

import java.util.Objects;

import com.jonathanschram.vttconverter.lib.vtt.css.CssProperty;

/***
 * A CSS property whose value is set to a known, single value. It may be a
 * relative property (such as relative length like "em") but it is not a global
 * value like INITIAL.
 */
public class ConcreteProperty<T> implements CssProperty<T> {

    private final T value;

    public ConcreteProperty(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ConcreteProperty<?> other = (ConcreteProperty<?>) obj;
        return Objects.equals(value, other.value);
    }

    public T getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "ConcreteProperty [value=" + value + "]";
    }

    public T getCurrentValue() {
        return value;
    }

}
