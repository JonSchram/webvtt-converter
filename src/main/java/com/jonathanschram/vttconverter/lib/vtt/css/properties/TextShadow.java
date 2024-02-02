package com.jonathanschram.vttconverter.lib.vtt.css.properties;

import com.jonathanschram.vttconverter.lib.vtt.css.types.Color;

public class TextShadow {
    private final int offsetX;
    private final int offsetY;
    private final int blurRadius;
    private final Color color;

    public TextShadow(int offsetX, int offsetY, Color color) {
        this(offsetX, offsetY, 0, color);
    }

    public TextShadow(int offsetX, int offsetY, int blurRadius, Color color) {
        super();
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.blurRadius = blurRadius;
        this.color = color;
    }

    public int getBlurRadius() {
        return blurRadius;
    }

    public Color getColor() {
        return color;
    }

    public int getOffsetX() {
        return offsetX;
    }

    public int getOffsetY() {
        return offsetY;
    }

}
