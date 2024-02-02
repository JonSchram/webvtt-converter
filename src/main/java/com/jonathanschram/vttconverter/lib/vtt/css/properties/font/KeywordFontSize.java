package com.jonathanschram.vttconverter.lib.vtt.css.properties.font;

public class KeywordFontSize implements FontSize {

    private final FontSizeKeyword size;

    public KeywordFontSize(FontSizeKeyword size) {
        this.size = size;
    }

    public FontSizeKeyword getSize() {
        return size;
    }

}
