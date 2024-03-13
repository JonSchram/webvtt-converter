package com.jonathanschram.vttconverter.lib.vtt.css;

/**
 * Parameters that determine how CSS properties are resolved
 */
public class RenderParameters {

    private final int viewportWidth;
    private final int viewportHeight;
    private final double pixelsPerInch;

    public RenderParameters(int viewportWidth, int viewportHeight, double pixelsPerInch) {
        super();
        this.viewportWidth = viewportWidth;
        this.viewportHeight = viewportHeight;
        this.pixelsPerInch = pixelsPerInch;
    }

    /**
     * Gets the number of pixels per inch for the current render.
     * 
     * @return
     */
    public double getPixelsPerInch() {
        return pixelsPerInch;
    }

    /**
     * Gets the viewport height in pixels.
     * 
     * @return
     */
    public int getViewportHeight() {
        return viewportHeight;
    }

    /**
     * Gets the viewport width in pixels.
     * 
     * @return
     */
    public int getViewportWidth() {
        return viewportWidth;
    }

}
