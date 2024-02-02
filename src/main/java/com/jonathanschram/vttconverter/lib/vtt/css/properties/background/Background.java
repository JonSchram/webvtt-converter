package com.jonathanschram.vttconverter.lib.vtt.css.properties.background;

import com.jonathanschram.vttconverter.lib.vtt.css.properties.background.size.BackgroundSize;
import com.jonathanschram.vttconverter.lib.vtt.css.types.Color;

public class Background {

    private final BackgroundAttachment attachment;
    private final BackgroundClip clip;
    private final Color color;
    private final BackgroundImage image;
    private final BackgroundOrigin origin;
    private final BackgroundPosition position;
    private final BackgroundRepeat repeat;
    private final BackgroundSize size;

    public Background(BackgroundAttachment attachment, BackgroundClip clip, Color color, BackgroundImage image,
            BackgroundOrigin origin, BackgroundPosition position, BackgroundRepeat repeat, BackgroundSize size) {
        super();
        this.attachment = attachment;
        this.clip = clip;
        this.color = color;
        this.image = image;
        this.origin = origin;
        this.position = position;
        this.repeat = repeat;
        this.size = size;
    }

    public BackgroundAttachment getAttachment() {
        return attachment;
    }

    public BackgroundClip getClip() {
        return clip;
    }

    public Color getColor() {
        return color;
    }

    public BackgroundImage getImage() {
        return image;
    }

    public BackgroundOrigin getOrigin() {
        return origin;
    }

    public BackgroundPosition getPosition() {
        return position;
    }

    public BackgroundRepeat getRepeat() {
        return repeat;
    }

    public BackgroundSize getSize() {
        return size;
    }

}
