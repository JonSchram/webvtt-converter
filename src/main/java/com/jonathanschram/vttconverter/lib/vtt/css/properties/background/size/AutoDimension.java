package com.jonathanschram.vttconverter.lib.vtt.css.properties.background.size;

/***
 * A dimension of background size representing automatic scaling.
 */
public class AutoDimension implements SizeDimension {

    private static AutoDimension instance;

    public static final AutoDimension getInstance() {
        if (instance == null) {
            instance = new AutoDimension();
        }
        return instance;
    }

    private AutoDimension() {
    }

}
