package com.jonathanschram.vttconverter.lib.vtt.css;

import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadeValueReference;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.Font;
import com.jonathanschram.vttconverter.lib.vtt.css.types.Color;

/***
 * Interface for a CSS property that can take on either a real value of
 * {@link T} or a {@link GlobalValue} that specifies cascade behavior.
 * 
 * @param <T> Type of value contained in this property.
 */
public interface CssProperty<T extends CssValue<T>> {

    /***
     * Returns whether the property has been resolved to a set value. It must return
     * false if this property is an unknown value such as a global value.
     * 
     * @return
     */
    boolean isResolved();

    /***
     * Returns the resolved value of this property. This is only valid if
     * {@link #isResolved()} returns true.
     * 
     * @return The value of this property
     * @throws UnresolvedPropertyException If this is not a resolved property.
     */
    T getResolvedValue() throws UnresolvedPropertyException;

    /***
     * Calculates and returns a CSS property that follows CSS cascading rules. The
     * result of calling {@link CssValue#isComputedValue()} must be
     * <code>true</code> on the returned type <code>T</code>.
     * 
     * @param parent
     * @param colorReference TODO
     * @param fontReference TODO
     * @param parameters TODO
     * @return
     * @throws UncomputedValueException If a child property references an uncomputed
     *         parent property.
     * @throws UnresolvedPropertyException If a child property references a parent
     *         property whose value is a global value keyword.
     */
    CssProperty<T> cascadeFrom(CssProperty<T> parent, CascadeValueReference<Color> colorReference,
            CascadeValueReference<Font> fontReference, RenderParameters parameters)
            throws UnresolvedPropertyException, UncomputedValueException;

    /***
     * Convenience method for cascading a style from a parent onto the child.
     * 
     * @param <S> The CSS value type.
     * @param parent
     * @param child
     * @param colorReference TODO
     * @param fontReference TODO
     * @param parameters TODO
     * @return
     * @throws UncomputedValueException
     * @throws UnresolvedPropertyException
     */
    static <S extends CssValue<S>> CssProperty<S> cascade(CssProperty<S> parent, CssProperty<S> child,
            CascadeValueReference<Color> colorReference, CascadeValueReference<Font> fontReference,
            RenderParameters parameters)
            throws UnresolvedPropertyException, UncomputedValueException {
        if (child == null) {
            return parent;
        }
        return child.cascadeFrom(parent, colorReference, fontReference, parameters);
    }
}
