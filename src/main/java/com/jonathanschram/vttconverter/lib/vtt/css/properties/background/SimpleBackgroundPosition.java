package com.jonathanschram.vttconverter.lib.vtt.css.properties.background;

import java.util.Objects;

import com.jonathanschram.vttconverter.lib.vtt.css.RenderParameters;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadeValueReference;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.Font;
import com.jonathanschram.vttconverter.lib.vtt.css.types.Color;
import com.jonathanschram.vttconverter.lib.vtt.css.types.Position;

/***
 * A position with no offset. Simply wraps a position value.
 */
public class SimpleBackgroundPosition implements BackgroundPosition {

    private final Position position;

    public SimpleBackgroundPosition(Position p) {
        position = p;
    }

    @Override
    public BackgroundPosition computeValue(CascadeValueReference<Color> colorReference, CascadeValueReference<Font> fontReference, RenderParameters parameters) {
        // TODO Compute value.
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SimpleBackgroundPosition other = (SimpleBackgroundPosition) obj;
        return Objects.equals(position, other.position);
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public boolean isComputedValue() {
        // TODO Determine whether this is a computed value.
        return false;
    }

    @Override
    public String toString() {
        return "SimpleBackgroundPosition [position=" + position + "]";
    }

}
