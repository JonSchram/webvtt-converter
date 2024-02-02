package com.jonathanschram.vttconverter.lib.vtt.css.properties;

import com.jonathanschram.vttconverter.lib.vtt.css.types.AbsoluteColor;

public class TextShadow {
    private final int offsetX;
    private final int offsetY;
    private final int blurRadius;
    private final AbsoluteColor color;

    public TextShadow(int offsetX, int offsetY, AbsoluteColor color) {
        this(offsetX, offsetY, 0, color);
    }

    public TextShadow(int offsetX, int offsetY, int blurRadius, AbsoluteColor color) {
        super();
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.blurRadius = blurRadius;
        this.color = color;
    }

    public int getBlurRadius() {
        return blurRadius;
    }

    public AbsoluteColor getColor() {
        return color;
    }

    public int getOffsetX() {
        return offsetX;
    }

    public int getOffsetY() {
        return offsetY;
    }

}
