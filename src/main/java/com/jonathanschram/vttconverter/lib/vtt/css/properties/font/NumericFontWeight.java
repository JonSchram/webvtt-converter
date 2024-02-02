package com.jonathanschram.vttconverter.lib.vtt.css.properties.font;

public class NumericFontWeight implements FontWeight {
    private final int weight;

    public NumericFontWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

}
