package com.jonathanschram.vttconverter.lib.vtt.layout;

public interface StyleBox {
    int getWidth();

    StyleBox[] softSplitToWidth(int width);

    boolean canSoftSplit(int width);

    StyleBox[] hardSplitToWidth(int width);
}
