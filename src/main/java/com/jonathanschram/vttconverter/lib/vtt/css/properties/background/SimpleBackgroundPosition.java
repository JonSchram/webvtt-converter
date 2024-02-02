package com.jonathanschram.vttconverter.lib.vtt.css.properties.background;

import com.jonathanschram.vttconverter.lib.vtt.css.types.Position;

/***
 * A position with no offset. Simply wraps a position value.
 */
public class SimpleBackgroundPosition implements BackgroundPosition {

    private final Position position;

    public SimpleBackgroundPosition(Position p) {
        position = p;
    }

    public Position getPosition() {
        return position;
    }

}
