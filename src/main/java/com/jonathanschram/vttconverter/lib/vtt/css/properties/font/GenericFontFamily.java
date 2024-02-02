package com.jonathanschram.vttconverter.lib.vtt.css.properties.font;

public class GenericFontFamily implements FontFamily {
    private final GenericFamilyName name;

    public GenericFontFamily(GenericFamilyName name) {
        this.name = name;
    }

    public GenericFamilyName getName() {
        return name;
    }

}
