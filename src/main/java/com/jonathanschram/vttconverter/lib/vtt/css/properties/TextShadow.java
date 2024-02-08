package com.jonathanschram.vttconverter.lib.vtt.css.properties;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        return Objects.hash(blurRadius, color, offsetX, offsetY);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TextShadow other = (TextShadow) obj;
        return blurRadius == other.blurRadius && Objects.equals(color, other.color) && offsetX == other.offsetX
                && offsetY == other.offsetY;
    }

    @Override
    public String toString() {
        return "TextShadow [offsetX=" + offsetX + ", offsetY=" + offsetY + ", blurRadius=" + blurRadius + ", color="
                + color + "]";
    }

}
