package com.jonathanschram.vttconverter.lib.vtt.css.cascade;

import com.jonathanschram.vttconverter.lib.vtt.css.CssProperty;

/***
 * A superclass for any style that can cascade, i.e. while styles for the entire
 * DOM tree are being computed.
 */
public abstract class CascadingStyle<T> implements CssProperty<T> {

    public CascadingStyle() {
        // TODO Auto-generated constructor stub
    }

}
