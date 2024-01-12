package com.jonathanschram.vttconverter.lib.vtt.css;

public class RawCssBlock {
    private final String blockContents;

    public RawCssBlock(String contents) {
        blockContents = contents;
    }

    public String getBlockContents() {
        return blockContents;
    }

}
