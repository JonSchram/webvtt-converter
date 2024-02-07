package com.jonathanschram.vttconverter.lib.vtt.css.cascade.background;

import java.util.Objects;

import com.jonathanschram.vttconverter.lib.vtt.css.CssShorthand;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.background.Background;

public class CssBackground implements CssShorthand<Background, CssBackground> {

    public static class Builder {
        private CssBackgroundAttachment attachment = new CssBackgroundAttachment();
        private CssBackgroundColor color = new CssBackgroundColor();
        private CssBackgroundImage image = new CssBackgroundImage();
        private CssBackgroundOrigin origin = new CssBackgroundOrigin();
        private CssBackgroundPosition position = new CssBackgroundPosition();
        private CssBackgroundRepeat repeat = new CssBackgroundRepeat();
        private CssBackgroundSize size = new CssBackgroundSize();
        private CssBackgroundClip clip = new CssBackgroundClip();

        public CssBackground build() {
            return new CssBackground(attachment, color, image, origin, position, repeat, size, clip);
        }

        public Builder setAttachment(CssBackgroundAttachment attachment) {
            this.attachment = attachment;
            return this;
        }

        public Builder setClip(CssBackgroundClip clip) {
            this.clip = clip;
            return this;
        }

        public Builder setColor(CssBackgroundColor color) {
            this.color = color;
            return this;
        }

        public Builder setImage(CssBackgroundImage image) {
            this.image = image;
            return this;
        }

        public Builder setOrigin(CssBackgroundOrigin origin) {
            this.origin = origin;
            return this;
        }

        public Builder setPosition(CssBackgroundPosition position) {
            this.position = position;
            return this;
        }

        public Builder setRepeat(CssBackgroundRepeat repeat) {
            this.repeat = repeat;
            return this;
        }

        public Builder setSize(CssBackgroundSize size) {
            this.size = size;
            return this;
        }
    }

    private CssBackgroundAttachment attachment;
    private CssBackgroundColor color;
    private CssBackgroundImage image;
    private CssBackgroundOrigin origin;
    private CssBackgroundPosition position;
    private CssBackgroundRepeat repeat;
    private CssBackgroundSize size;
    private CssBackgroundClip clip;

    public CssBackground() {
        this(new CssBackgroundAttachment(), new CssBackgroundColor(), new CssBackgroundImage(),
                new CssBackgroundOrigin(), new CssBackgroundPosition(),
                new CssBackgroundRepeat(), new CssBackgroundSize(), new CssBackgroundClip());
    }

    public CssBackground(CssBackgroundAttachment attachment, CssBackgroundColor color, CssBackgroundImage image,
            CssBackgroundOrigin origin, CssBackgroundPosition position, CssBackgroundRepeat repeat,
            CssBackgroundSize size, CssBackgroundClip clip) {
        this.attachment = attachment;
        this.color = color;
        this.image = image;
        this.origin = origin;
        this.position = position;
        this.repeat = repeat;
        this.size = size;
        this.clip = clip;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CssBackground other = (CssBackground) obj;
        return Objects.equals(attachment, other.attachment) && Objects.equals(clip, other.clip)
                && Objects.equals(color, other.color) && Objects.equals(image, other.image)
                && Objects.equals(origin, other.origin) && Objects.equals(position, other.position)
                && Objects.equals(repeat, other.repeat) && Objects.equals(size, other.size);
    }

    public CssBackgroundAttachment getAttachment() {
        return attachment;
    }

    public CssBackgroundClip getClip() {
        return clip;
    }

    public CssBackgroundColor getColor() {
        return color;
    }

    public CssBackgroundImage getImage() {
        return image;
    }

    @Override
    public Background getInitialValue() {
        return new Background(attachment.getInitialValue(), clip.getInitialValue(),
                color.getInitialValue(), image.getInitialValue(), origin.getInitialValue(),
                position.getInitialValue(), repeat.getInitialValue(), size.getInitialValue());
    }

    public CssBackgroundOrigin getOrigin() {
        return origin;
    }

    public CssBackgroundPosition getPosition() {
        return position;
    }

    public CssBackgroundRepeat getRepeat() {
        return repeat;
    }

    public CssBackgroundSize getSize() {
        return size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(attachment, clip, color, image, origin, position, repeat, size);
    }

    @Override
    public void updateStyle(CssBackground newValue) {
        if (newValue == null) {
            return;
        }
        attachment.updateStyle(newValue.attachment);
        color.updateStyle(newValue.color);
        image.updateStyle(newValue.image);
        origin.updateStyle(newValue.origin);
        position.updateStyle(newValue.position);
        repeat.updateStyle(newValue.repeat);
        size.updateStyle(newValue.size);
        clip.updateStyle(newValue.clip);
    }
}
