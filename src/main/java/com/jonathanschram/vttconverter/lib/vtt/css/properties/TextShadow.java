package com.jonathanschram.vttconverter.lib.vtt.css.properties;

import java.util.Objects;

import com.jonathanschram.vttconverter.lib.vtt.css.CssValue;
import com.jonathanschram.vttconverter.lib.vtt.css.RenderParameters;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadeValueReference;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.Font;
import com.jonathanschram.vttconverter.lib.vtt.css.types.AbsoluteColor;
import com.jonathanschram.vttconverter.lib.vtt.css.types.Color;
import com.jonathanschram.vttconverter.lib.vtt.css.types.Unit;
import com.jonathanschram.vttconverter.lib.vtt.css.types.length.Length;
import com.jonathanschram.vttconverter.lib.vtt.css.types.length.NumericLength;

public class TextShadow implements CssValue<TextShadow> {
    private final Length offsetX;
    private final Length offsetY;
    private final Length blurRadius;
    private final AbsoluteColor color;

    public TextShadow(Length offsetX, Length offsetY, AbsoluteColor color) {
        this(offsetX, offsetY, new NumericLength(0, Unit.PIXELS), color);
    }

    public TextShadow(Length offsetX, Length offsetY, Length blurRadius, AbsoluteColor color) {
        super();
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.blurRadius = blurRadius;
        this.color = color;
    }

    public Length getBlurRadius() {
        return blurRadius;
    }

    public AbsoluteColor getColor() {
        return color;
    }

    public Length getOffsetX() {
        return offsetX;
    }

    public Length getOffsetY() {
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

    @Override
    public boolean isComputedValue() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public TextShadow computeValue(CascadeValueReference<Color> colorReference, CascadeValueReference<Font> fontReference, RenderParameters parameters) {
        // TODO Auto-generated method stub
        // This needs BOTH color and font reference (for currentcolor and EM units).
        // A parent textShadow doesn't help at all.
        return null;
    }

}
