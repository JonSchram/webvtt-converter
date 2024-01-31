package com.jonathanschram.vttconverter.lib.vtt.layout;

/***
 * An implementation of {@link StyleBox} that just holds text with text styles.
 */
public class TextStyleBox implements StyleBox {
    
    public TextStyleBox() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public int getWidth() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public StyleBox[] softSplitToWidth(int width) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean canSoftSplit(int width) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public StyleBox[] hardSplitToWidth(int width) {
        // TODO Auto-generated method stub
        return null;
    }

}
