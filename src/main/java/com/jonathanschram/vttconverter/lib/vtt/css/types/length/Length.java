package com.jonathanschram.vttconverter.lib.vtt.css.types.length;

import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadeValueReference;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.PropertyName;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.Font;

/***
 * An interface for CSS length. This allows setting absolute sizes (in terms of
 * pixels or real-world units like inches) or relative sizes (like 'em').
 */
public interface Length {
    /***
     * Returns whether the length represents an absolute distance such as pixels or
     * inches. Returns false if this is relative units like "em."
     * 
     * @return
     */
    boolean isAbsoluteLength();

    /***
     * Returns a new {@link Length} instance whose relative length unit has been
     * converted to an absolute unit.
     * 
     * If this length already uses an absolute unit, it may return itself.
     * 
     * @param currentProperty TODO
     * 
     * @return
     */
    Length convertToAbsoluteLength(CascadeValueReference<Font> fontReference, PropertyName currentProperty);

    /***
     * Returns a new length whose value is this Length multiplied by the given
     * scalar value.
     * 
     * @param scalar
     * @return
     */
    Length multiply(double scalar);
}
