package com.jonathanschram.vttconverter.lib.vtt.css.properties;

/***
 * All CSS properties that can be set.
 * 
 * Assists with resolving property values during cascade when the value depends
 * on the property being resolved.
 */
public enum PropertyName {
    COLOR, OPACITY, VISIBILITY, TEXT_SHADOW, WHITE_SPACE, TEXT_COMBINE_UPRIGHT, RUBY_POSITION,

    // Background shorthand
    BACKGROUND_ATTACHMENT, BACKGROUND_COLOR, BACKGROUND_IMAGE, BACKGROUND_ORIGIN, BACKGROUND_POSITION,
    BACKGROUND_REPEAT, BACKGROUND_SIZE, BACKGROUND_CLIP,

    // Decoration shorthand
    TEXT_DECORATION_COLOR, TEXT_DECORATION_LINE, TEXT_DECORATION_STYLE,

    // Font shorthand
    FONT_FAMILY, FONT_SIZE, FONT_STRETCH, FONT_STYLE, FONT_VARIANT, FONT_WEIGHT, LINE_HEIGHT,

    // Outline shorthand
    OUTLINE_COLOR, OUTLINE_STYLE, OUTLINE_WIDTH;
}
