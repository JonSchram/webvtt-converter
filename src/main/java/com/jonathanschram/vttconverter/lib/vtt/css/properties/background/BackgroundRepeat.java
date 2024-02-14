package com.jonathanschram.vttconverter.lib.vtt.css.properties.background;

import java.util.Objects;

import com.jonathanschram.vttconverter.lib.vtt.css.CssValue;

public class BackgroundRepeat implements CssValue<BackgroundRepeat> {

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

    @Override
    public int hashCode() {
        return Objects.hash(repeatX, repeatY);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BackgroundRepeat other = (BackgroundRepeat) obj;
        return repeatX == other.repeatX && repeatY == other.repeatY;
    }

    @Override
    public String toString() {
        return "BackgroundRepeat [repeatX=" + repeatX + ", repeatY=" + repeatY + "]";
    }

    @Override
    public boolean isComputedValue() {
        return true;
    }

    @Override
    public BackgroundRepeat computeValue() {
        return this;
    }

}
