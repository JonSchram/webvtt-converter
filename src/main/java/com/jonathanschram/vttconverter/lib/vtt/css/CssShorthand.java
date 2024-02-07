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
    T getInitialValue();

    /***
     * Updates all properties in the current shorthand with the values in the
     * provided value.
     * 
     * @param newValue
     */
    void updateStyle(S newValue);
}
