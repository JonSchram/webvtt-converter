package com.jonathanschram.vttconverter.lib.vtt.css.properties.background.size;

/***
 * An interface for background sizing that calculates the dimensions based on a
 * {@link SizeKeyword}.
 */
public class KeywordSize implements BackgroundSize {

    private final SizeKeyword value;

    public KeywordSize(SizeKeyword value) {
        this.value = value;
    }

    public SizeKeyword getValue() {
        return value;
    }

}
