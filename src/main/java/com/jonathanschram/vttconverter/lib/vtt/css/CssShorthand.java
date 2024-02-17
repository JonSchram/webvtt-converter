package com.jonathanschram.vttconverter.lib.vtt.css;

/***
 * An interface to allow CSS shorthand properties to cascade over a set of
 * properties at once.
 * 
 * @param <T> The type of the object this shorthand defines.
 * @param <S> The type of the object to use when updating self value. This will
 *            usually be the same as the type implementing this interface.
 */
public interface CssShorthand<T, S extends CssShorthand<T, S>> {

    // TODO: This might not be needed either. In what case do you need anything
    // other than unset values?

    T getInitialValue();

    /***
     * Updates all properties in the current shorthand with the values in the
     * provided value.
     * 
     * @param newValue
     */
    void updateStyle(S newValue);

    /***
     * Updates the styles in this shorthand, cascading from the styles in the
     * parent.
     * 
     * @param parent
     * @throws UncomputedValueException
     * @throws UnresolvedPropertyException
     */
    void cascadeFrom(S parent) throws UnresolvedPropertyException, UncomputedValueException;

    /**
     * Convenience method for choosing <code>newValue</code> only if it is non-null.
     * 
     * @param <P>
     * @param oldValue
     * @param newValue
     * @return
     */
    static <P extends CssValue<P>> CssProperty<P> newPropertyIfNotNull(CssProperty<P> oldValue,
            CssProperty<P> newValue) {
        if (newValue != null) {
            return newValue;
        }

        return oldValue;
    }

}
