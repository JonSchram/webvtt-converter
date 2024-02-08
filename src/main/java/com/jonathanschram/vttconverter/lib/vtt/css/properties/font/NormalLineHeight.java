package com.jonathanschram.vttconverter.lib.vtt.css.properties.font;

/***
 * An implementation of {@link LineHeight} for normal height.
 */
public class NormalLineHeight implements LineHeight {
    private static NormalLineHeight instance;

    public static NormalLineHeight getInstance() {
        if (instance == null) {
            instance = new NormalLineHeight();
        }
        return instance;
    }

    private NormalLineHeight() {
    }

    @Override
    public String toString() {
        return "NormalLineHeight []";
    }

}
