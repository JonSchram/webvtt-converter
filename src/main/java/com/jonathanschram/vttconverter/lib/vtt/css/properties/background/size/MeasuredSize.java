package com.jonathanschram.vttconverter.lib.vtt.css.properties.background.size;

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

}
