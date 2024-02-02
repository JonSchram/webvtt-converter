package com.jonathanschram.vttconverter.lib.vtt.css.properties.ruby;

/***
 * An implementation of {@link RubyPosition} that encodes an over or under style
 * with corresponding alternate setting.
 */
public class OverUnderPosition implements RubyPosition {

    /***
     * Whether the ruby position alternates between over and under.
     */
    private final boolean alternate;
    private final RubyTextPosition position;

    public OverUnderPosition(boolean alternate, RubyTextPosition position) {
        super();
        this.alternate = alternate;
        this.position = position;
    }

    public boolean isAlternate() {
        return alternate;
    }

    public RubyTextPosition getPosition() {
        return position;
    }

}
