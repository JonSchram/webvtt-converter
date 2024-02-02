package com.jonathanschram.vttconverter.lib.vtt.css.cascade.background;

import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.background.BackgroundClip;

public class CssCssBackgroundClip extends CascadingStyle<BackgroundClip> {

    public CssCssBackgroundClip() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public BackgroundClip getInitialValue() {
        return BackgroundClip.BORDER_BOX;
    }

}
