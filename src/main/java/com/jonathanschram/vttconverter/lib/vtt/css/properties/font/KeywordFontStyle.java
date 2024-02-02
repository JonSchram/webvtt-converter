package com.jonathanschram.vttconverter.lib.vtt.css.properties.font;

public class KeywordFontStyle implements FontStyle {
    private final FontStyleKeyword style;

    public KeywordFontStyle(FontStyleKeyword style) {
        this.style = style;
    }

    public FontStyleKeyword getStyle() {
        return style;
    }

}
