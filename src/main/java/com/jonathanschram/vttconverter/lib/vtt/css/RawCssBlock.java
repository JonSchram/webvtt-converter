package com.jonathanschram.vttconverter.lib.vtt.css;

import java.util.Objects;

public class RawCssBlock {
    private final String blockContents;

    public RawCssBlock(String contents) {
        blockContents = contents;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RawCssBlock other = (RawCssBlock) obj;
        return Objects.equals(blockContents, other.blockContents);
    }

    public String getBlockContents() {
        return blockContents;
    }

    @Override
    public int hashCode() {
        return Objects.hash(blockContents);
    }

}
