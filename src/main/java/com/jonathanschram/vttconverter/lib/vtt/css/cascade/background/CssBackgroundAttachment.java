package com.jonathanschram.vttconverter.lib.vtt.css.cascade.background;

import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.background.BackgroundAttachment;

public class CssBackgroundAttachment extends CascadingStyle<BackgroundAttachment> {

    public CssBackgroundAttachment() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public BackgroundAttachment getInitialValue() {
        return BackgroundAttachment.SCROLL;
    }

}
