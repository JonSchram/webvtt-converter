package com.jonathanschram.vttconverter.lib.vtt.css.properties.background.size;

import java.util.Objects;

import com.jonathanschram.vttconverter.lib.vtt.css.RenderParameters;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadeValueReference;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.Font;
import com.jonathanschram.vttconverter.lib.vtt.css.types.Color;

/***
 * An implementation of {@link BackgroundSize} that calculates size based on a
 * measurement.
 */
public class MeasuredSize implements BackgroundSize {

    private final SizeDimension width;
    private final SizeDimension height;

    public MeasuredSize(SizeDimension width, SizeDimension height) {
        this.width = width;
        this.height = height;
    }

    public SizeDimension getWidth() {
        return width;
    }

    public SizeDimension getHeight() {
        return height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, width);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MeasuredSize other = (MeasuredSize) obj;
        return Objects.equals(height, other.height) && Objects.equals(width, other.width);
    }

    @Override
    public String toString() {
        return "MeasuredSize [width=" + width + ", height=" + height + "]";
    }

    @Override
    public boolean isComputedValue() {
        return width.isAbsoluteLength() && height.isAbsoluteLength();
    }

    @Override
    public BackgroundSize computeValue(CascadeValueReference<Color> colorReference, CascadeValueReference<Font> fontReference, RenderParameters parameters) {
        // TODO Auto-generated method stub
        return null;
    }

}
