package com.jonathanschram.vttconverter.lib.vtt.css.properties.background;

public class BackgroundRepeat {

    public static final BackgroundRepeat REPEAT_X = new BackgroundRepeat(Repeat.REPEAT, Repeat.NO_REPEAT);
    public static final BackgroundRepeat REPEAT_Y = new BackgroundRepeat(Repeat.NO_REPEAT, Repeat.REPEAT);
    public static final BackgroundRepeat REPEAT = new BackgroundRepeat(Repeat.REPEAT, Repeat.REPEAT);
    public static final BackgroundRepeat SPACE = new BackgroundRepeat(Repeat.SPACE, Repeat.SPACE);
    public static final BackgroundRepeat ROUND = new BackgroundRepeat(Repeat.ROUND, Repeat.ROUND);
    public static final BackgroundRepeat NO_REPEAT = new BackgroundRepeat(Repeat.NO_REPEAT, Repeat.NO_REPEAT);

    private final Repeat repeatX;
    private final Repeat repeatY;

    public BackgroundRepeat(Repeat repeatX, Repeat repeatY) {
        this.repeatX = repeatX;
        this.repeatY = repeatY;
    }

    public Repeat getRepeatX() {
        return repeatX;
    }

    public Repeat getRepeatY() {
        return repeatY;
    }

}
