package com.jonathanschram.vttconverter.lib.vtt.css.types;

import com.jonathanschram.vttconverter.lib.vtt.css.types.length.Length;

public class LengthPosition implements Position {

    private final Length xDistance;
    private final Length yDistance;

    public LengthPosition(Length xDistance, Length yDistance) {
        this.xDistance = xDistance;
        this.yDistance = yDistance;
    }

    public Length getxDistance() {
        return xDistance;
    }

    public Length getyDistance() {
        return yDistance;
    }

}
