package com.jonathanschram.vttconverter.lib.vtt.css;

/***
 * Interface for a CSS property that can take on either a real value of
 * {@link T} or a {@link GlobalValue} that specifies cascade behavior.
 * 
 * @param <T> Type of value contained in this property.
 */
public interface CssProperty<T> {

    GlobalValue getGlobalValue();

    /***
     * Gets the initial value that the wrapped property should have, according to
     * the CSS spec.
     * 
     * @return
     */
    T getInitialValue();

    /***
     * Gets the current value of the wrapped property. Can be null if there is no
     * wrapped property, with only a global value set.
     * 
     * @return
     */
    T getCurrentValue();

    /***
     * Sets the new value of the wrapped property.
     * 
     * @param newValue
     */
    void setValue(T newValue);

    /***
     * Updates the current style with the provided style.
     * <p>
     * Both the {@link GlobalValue} and real value will be overwritten with the new
     * value, unless the new value is {@link GlobalValue#UNSET}.
     * 
     * @param updatedValue
     */
    void updateStyle(CssProperty<T> updatedValue);
}
