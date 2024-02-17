package com.jonathanschram.vttconverter.lib.vtt.css.cascade;

import java.util.Objects;

import com.jonathanschram.vttconverter.lib.vtt.css.UnresolvedPropertyException;
import com.jonathanschram.vttconverter.lib.vtt.css.CssProperty;
import com.jonathanschram.vttconverter.lib.vtt.css.CssValue;
import com.jonathanschram.vttconverter.lib.vtt.css.UncomputedValueException;

/***
 * A CSS property whose value is set to a known, single value. It may be a
 * relative property (such as relative length like "em") but it is not a global
 * value like INITIAL.
 */
public class ConcreteProperty<T extends CssValue<T>> implements CssProperty<T> {

    private final T value;

    public ConcreteProperty(T value) {
        this.value = value;
    }

    @Override
    public CssProperty<T> cascadeFrom(CssProperty<T> parent)
            throws UnresolvedPropertyException, UncomputedValueException {
        // A concrete property is always a set value. It might not always be acceptable
        // as a computed value.
        if (value.isComputedValue()) {
            return this;
        }
        T parentValue = parent == null ? null : parent.getResolvedValue();
        // If not, ask it to convert itself to a computed value. The result is a regular
        // CSS value, so we can always store it in a ConcreteProperty.
        return new ConcreteProperty<>(value.computeValue(parentValue));
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

    public T getCurrentValue() {
        return value;
    }

    @Override
    public T getResolvedValue() throws UnresolvedPropertyException {
        return value;
    }

    public T getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public boolean isResolved() {
        return true;
    }

    @Override
    public String toString() {
        return "ConcreteProperty [value=" + value + "]";
    }

}
