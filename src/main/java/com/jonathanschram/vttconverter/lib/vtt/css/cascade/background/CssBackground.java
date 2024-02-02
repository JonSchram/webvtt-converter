package com.jonathanschram.vttconverter.lib.vtt.css.cascade.background;

import com.jonathanschram.vttconverter.lib.vtt.css.CssProperty;
import com.jonathanschram.vttconverter.lib.vtt.css.CssShorthand;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.background.Background;

public class CssBackground implements CssShorthand<Background, CssProperty<Background>> {

    private CssBackgroundAttachment attachment;
    private CssBackgroundColor color;
    private CssBackgroundImage image;
    private CssBackgroundOrigin origin;
    private CssBackgroundPosition position;
    private CssBackgroundRepeat repeat;
    private CssBackgroundSize size;
    private CssCssBackgroundClip clip;

    public CssBackground() {
        // All of these default to an unset value.
        attachment = new CssBackgroundAttachment();
        color = new CssBackgroundColor();
        image = new CssBackgroundImage();
        origin = new CssBackgroundOrigin();
        position = new CssBackgroundPosition();
        repeat = new CssBackgroundRepeat();
        size = new CssBackgroundSize();
        clip = new CssCssBackgroundClip();
    }

    @Override
    public Background getInitialValue() {
        return new Background(attachment.getInitialValue(), clip.getInitialValue(),
                color.getInitialValue(), image.getInitialValue(), origin.getInitialValue(),
                position.getInitialValue(), repeat.getInitialValue(), size.getInitialValue());
    }
}
