package com.jonathanschram.vttconverter.lib.vtt.css.types;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        return Objects.hash(xDistance, yDistance);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LengthPosition other = (LengthPosition) obj;
        return Objects.equals(xDistance, other.xDistance) && Objects.equals(yDistance, other.yDistance);
    }

    @Override
    public String toString() {
        return "LengthPosition [xDistance=" + xDistance + ", yDistance=" + yDistance + "]";
    }

}
