package com.jonathanschram.vttconverter.lib.vtt.css.cascade;

import java.util.Objects;

import com.jonathanschram.vttconverter.lib.vtt.css.CssProperty;
import com.jonathanschram.vttconverter.lib.vtt.css.GlobalValue;

/***
 * A superclass for any style that can cascade, i.e. while styles for the entire
 * DOM tree are being computed.
 */
public abstract class CascadingStyle<T> implements CssProperty<T> {

    /***
     * A special global value that indicates this object either contains no data or
     * must take its value from another element.
     */
    private GlobalValue globalValue;

    protected T wrappedValue;

    public CascadingStyle() {
        globalValue = GlobalValue.UNSET;
    }

    public CascadingStyle(GlobalValue currentValue) {
        globalValue = currentValue;
    }

    public CascadingStyle(T currentValue) {
        globalValue = null;
        wrappedValue = currentValue;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CascadingStyle<?> other = (CascadingStyle<?>) obj;
        return globalValue == other.globalValue && Objects.equals(wrappedValue, other.wrappedValue);
    }

    @Override
    public T getCurrentValue() {
        return wrappedValue;
    }

    @Override
    public GlobalValue getGlobalValue() {
        return globalValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(globalValue, wrappedValue);
    }

    @Override
    public void setValue(T newValue) {
        wrappedValue = newValue;
    }

    @Override
    public void updateStyle(CssProperty<T> updatedValue) {
        if (updatedValue.getGlobalValue() == GlobalValue.UNSET) {
            // New value is not set, no action needed.
            return;
        }

        if (this.globalValue == null) {
            // Current value is set.
            if (updatedValue.getGlobalValue() == null) {
                // Both the current and new value are set, choose the updated value.
                this.setValue(updatedValue.getCurrentValue());
            } else {
                // The current value is set but the new value is a global keyword. Take new
                // keyword and clear current value.
                this.globalValue = updatedValue.getGlobalValue();
                this.setValue(null);
            }
        } else {
            // Real value is not set.
            if (updatedValue.getGlobalValue() == null) {
                // Updated value is set.
                this.globalValue = null;
                this.setValue(updatedValue.getCurrentValue());
            } else {
                // Updated value is not set.
                this.globalValue = updatedValue.getGlobalValue();
            }
        }

    }
}
