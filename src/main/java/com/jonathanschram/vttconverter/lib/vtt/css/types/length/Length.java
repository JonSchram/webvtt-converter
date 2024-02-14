package com.jonathanschram.vttconverter.lib.vtt.css.types.length;

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
}
