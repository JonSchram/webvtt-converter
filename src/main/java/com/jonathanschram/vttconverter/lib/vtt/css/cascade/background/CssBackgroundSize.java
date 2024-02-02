package com.jonathanschram.vttconverter.lib.vtt.css.cascade.background;

import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.background.size.AutoDimension;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.background.size.BackgroundSize;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.background.size.MeasuredSize;

public class CssBackgroundSize extends CascadingStyle<BackgroundSize> {

    public CssBackgroundSize() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public BackgroundSize getInitialValue() {
        return new MeasuredSize(new AutoDimension(), new AutoDimension());
    }

}
