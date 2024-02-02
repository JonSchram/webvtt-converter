package com.jonathanschram.vttconverter.lib.vtt.css;

/***
 * An interface to allow CSS shorthand properties to cascade over a set of
 * properties at once.
 * 
 * @param <T>
 * @param <S>
 */
public interface CssShorthand<T, S extends CssProperty<T>> extends CssProperty<T> {
}
