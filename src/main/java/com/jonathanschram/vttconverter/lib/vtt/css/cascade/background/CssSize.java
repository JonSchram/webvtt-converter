package com.jonathanschram.vttconverter.lib.vtt.css.cascade.background;

import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadingStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.background.size.AutoDimension;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.background.size.BackgroundSize;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.background.size.MeasuredSize;

public class CssSize extends CascadingStyle<BackgroundSize> {

    public CssSize() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public BackgroundSize getInitialValue() {
        return new MeasuredSize(new AutoDimension(), new AutoDimension());
    }

}
