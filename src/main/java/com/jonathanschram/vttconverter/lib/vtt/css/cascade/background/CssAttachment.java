package com.jonathanschram.vttconverter.lib.vtt.css.cascade.background;

import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.background.BackgroundAttachment;

public class CssAttachment extends CascadingStyle<BackgroundAttachment> {

    public CssAttachment() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public BackgroundAttachment getInitialValue() {
        return BackgroundAttachment.SCROLL;
    }

}
