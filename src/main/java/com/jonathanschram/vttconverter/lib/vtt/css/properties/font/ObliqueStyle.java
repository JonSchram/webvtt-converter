package com.jonathanschram.vttconverter.lib.vtt.css.properties.font;

import java.util.Objects;

import com.jonathanschram.vttconverter.lib.vtt.css.RenderParameters;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadeValueReference;
import com.jonathanschram.vttconverter.lib.vtt.css.types.Angle;
import com.jonathanschram.vttconverter.lib.vtt.css.types.Color;

public class ObliqueStyle implements FontStyle {

    private final Angle angle;

    public ObliqueStyle(Angle angle) {
        this.angle = angle;
    }

    @Override
    public FontStyle computeValue(CascadeValueReference<Color> colorReference, CascadeValueReference<Font> fontReference, RenderParameters parameters) {
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ObliqueStyle other = (ObliqueStyle) obj;
        return Objects.equals(angle, other.angle);
    }

    public Angle getAngle() {
        return angle;
    }

    @Override
    public int hashCode() {
        return Objects.hash(angle);
    }

    @Override
    public boolean isComputedValue() {
        return true;
    }

    @Override
    public String toString() {
        return "ObliqueStyle [angle=" + angle + "]";
    }

}
