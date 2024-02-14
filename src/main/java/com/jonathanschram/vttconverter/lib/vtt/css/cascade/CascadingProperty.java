package com.jonathanschram.vttconverter.lib.vtt.css.cascade;

import java.util.Objects;

import com.jonathanschram.vttconverter.lib.vtt.css.CssProperty;
import com.jonathanschram.vttconverter.lib.vtt.css.CssValue;
import com.jonathanschram.vttconverter.lib.vtt.css.GlobalValue;

/***
 * A superclass for a property whose value is a global value. These require
 * either referencing another node in the DOM or a default property value, and
 * thus require special handling.
 * <p>
 * These properties are only useful during the CSS cascade and must be replaced
 * with an appropriate {@link ConcreteProperty} before layout.
 */
public abstract class CascadingProperty<T extends CssValue<T>> implements CssProperty<T> {

    /***
     * A special global value that indicates how this object will determine its
     * value.
     */
    protected final GlobalValue globalValue;

    public CascadingProperty() {
        globalValue = GlobalValue.UNSET;
    }

    public CascadingProperty(GlobalValue currentValue) {
        globalValue = currentValue;
    }

    @Override
    public CssProperty<T> cascadeFrom(CssProperty<T> parent) {
        if (parent == null) {
            throw new IllegalArgumentException("Parent property must not be null");
        }
        // Cascade must use resolved property values.
        assert parent.isResolved();

        switch (globalValue) {
        case INHERIT:
            return parent;
        case INITIAL:
            return new ConcreteProperty<>(getInitialValue());
        case UNSET:
            if (isInherited()) {
                return parent;
            } else {
                return new ConcreteProperty<>(getInitialValue());
            }
        default:
            /*
             * TODO: Implement remaining cascade logic.
             * 
             * REVERT reverts back to the user's custom style. This program doesn't support
             * custom styles, so it should use the user agent's style. This program doesn't
             * really have those either, so there isn't much else to do.
             * 
             * Without layer support, REVERT_LAYER acts like REVERT.
             * 
             */
            return parent;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CascadingProperty<?> other = (CascadingProperty<?>) obj;
        return globalValue == other.globalValue;
    }

    public GlobalValue getGlobalValue() {
        return globalValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(globalValue);
    }

    /***
     * Whether this CSS property is inherited from the parent element.
     * <p>
     * If true, this property inherit their value from the computed value of the
     * parent's property during the cascade. If false, this property is set to its
     * initial value.
     * 
     * @return
     */
    public abstract boolean isInherited();

    @Override
    public boolean isResolved() {
        return false;
    }

    /***
     * Gets the initial value that this property type should have, according to the
     * CSS spec.
     * 
     * @return
     */
    protected abstract T getInitialValue();
}
