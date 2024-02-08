package com.jonathanschram.vttconverter.lib.vtt.css.properties.background;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        return Objects.hash(attachment, clip, color, image, origin, position, repeat, size);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Background other = (Background) obj;
        return attachment == other.attachment && clip == other.clip && Objects.equals(color, other.color)
                && Objects.equals(image, other.image) && origin == other.origin
                && Objects.equals(position, other.position) && Objects.equals(repeat, other.repeat)
                && Objects.equals(size, other.size);
    }

    @Override
    public String toString() {
        return "Background [attachment=" + attachment + ", clip=" + clip + ", color=" + color + ", image=" + image
                + ", origin=" + origin + ", position=" + position + ", repeat=" + repeat + ", size=" + size + "]";
    }

}
