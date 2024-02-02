package com.jonathanschram.vttconverter.lib.vtt.css.cascade.background;

import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.background.BackgroundClip;

public class CssClip extends CascadingStyle<BackgroundClip> {

    public CssClip() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public BackgroundClip getInitialValue() {
        return BackgroundClip.BORDER_BOX;
    }

}
