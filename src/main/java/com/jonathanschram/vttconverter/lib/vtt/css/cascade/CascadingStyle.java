package com.jonathanschram.vttconverter.lib.vtt.css.cascade;

import com.jonathanschram.vttconverter.lib.vtt.css.CssProperty;
import com.jonathanschram.vttconverter.lib.vtt.css.GlobalValue;

/***
 * A superclass for any style that can cascade, i.e. while styles for the entire
 * DOM tree are being computed.
 */
public abstract class CascadingStyle<T> implements CssProperty<T> {

    /***
     * A special global value that indicates this object either contains no data or
     * must take its value from another element.
     */
    private GlobalValue globalValue;

    public CascadingStyle() {
        globalValue = GlobalValue.UNSET;
    }

}
