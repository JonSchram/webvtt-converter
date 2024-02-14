package com.jonathanschram.vttconverter.lib.vtt.css;

/***
 * A value that can be stored in a CSS property. Ensures that values can be
 * cascaded properly.
 */
public interface CssValue<T extends CssValue<T>> {
    /***
     * Returns whether this value is acceptable as a computed value, according to
     * the CSS spec.
     * 
     * @return
     */
    boolean isComputedValue();

    /*
     * TODO: The CSS specification on MDN often refers to the computed value as a
     * slightly different type (such as a length value for the outline width).
     * 
     * This doesn't quite match the data types here. Consider renaming so it doesn't
     * conflict with CSS documentation.
     */
    /***
     * Returns a computed value equivalent to the current value.
     * 
     * @param <T>
     * @return
     */
    T computeValue();
}
