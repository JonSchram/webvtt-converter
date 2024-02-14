package com.jonathanschram.vttconverter.lib.vtt.css.cascade.background;

import java.util.Objects;

import com.jonathanschram.vttconverter.lib.vtt.css.CssProperty;
import com.jonathanschram.vttconverter.lib.vtt.css.CssShorthand;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.ConcreteProperty;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.background.Background;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.background.BackgroundAttachment;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.background.BackgroundClip;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.background.BackgroundImage;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.background.BackgroundOrigin;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.background.BackgroundPosition;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.background.BackgroundRepeat;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.background.size.BackgroundSize;
import com.jonathanschram.vttconverter.lib.vtt.css.types.Color;

public class BackgroundShorthand implements CssShorthand<Background, BackgroundShorthand> {

    public static class Builder {
        /***
         * Creates a new builder whose values are global unset values.
         * 
         * @return
         */
        public static Builder createUnset() {
            Builder builder = new Builder();
            builder.attachment = new CssBackgroundAttachment();
            builder.color = new CssBackgroundColor();
            builder.image = new CssBackgroundImage();
            builder.origin = new CssBackgroundOrigin();
            builder.position = new CssBackgroundPosition();
            builder.repeat = new CssBackgroundRepeat();
            builder.size = new CssBackgroundSize();
            builder.clip = new CssBackgroundClip();
            return builder;
        }

        /***
         * Creates a new builder whose values are null, to allow updating only certain
         * properties.
         * 
         * @return
         */
        public static Builder createUpdate() {
            return new Builder();
        }

        private CssProperty<BackgroundAttachment> attachment = null;
        private CssProperty<Color> color = null;
        private CssProperty<BackgroundImage> image = null;
        private CssProperty<BackgroundOrigin> origin = null;
        private CssProperty<BackgroundPosition> position = null;
        private CssProperty<BackgroundRepeat> repeat = null;
        private CssProperty<BackgroundSize> size = null;
        private CssProperty<BackgroundClip> clip = null;

        public BackgroundShorthand build() {
            return new BackgroundShorthand(this);
        }

        public Builder setAttachment(BackgroundAttachment attachment) {
            this.attachment = new ConcreteProperty<BackgroundAttachment>(attachment);
            return this;
        }

        public Builder setAttachment(CssBackgroundAttachment attachment) {
            this.attachment = attachment;
            return this;
        }

        public Builder setClip(BackgroundClip clip) {
            this.clip = new ConcreteProperty<BackgroundClip>(clip);
            return this;
        }

        public Builder setClip(CssBackgroundClip clip) {
            this.clip = clip;
            return this;
        }

        public Builder setColor(Color color) {
            this.color = new ConcreteProperty<Color>(color);
            return this;
        }

        public Builder setColor(CssBackgroundColor color) {
            this.color = color;
            return this;
        }

        public Builder setImage(BackgroundImage image) {
            this.image = new ConcreteProperty<BackgroundImage>(image);
            return this;
        }

        public Builder setImage(CssBackgroundImage image) {
            this.image = image;
            return this;
        }

        public Builder setOrigin(BackgroundOrigin origin) {
            this.origin = new ConcreteProperty<>(origin);
            return this;
        }

        public Builder setOrigin(CssBackgroundOrigin origin) {
            this.origin = origin;
            return this;
        }

        public Builder setPosition(BackgroundPosition position) {
            this.position = new ConcreteProperty<>(position);
            return this;
        }

        public Builder setPosition(CssBackgroundPosition position) {
            this.position = position;
            return this;
        }

        public Builder setRepeat(BackgroundRepeat repeat) {
            this.repeat = new ConcreteProperty<>(repeat);
            return this;
        }

        public Builder setRepeat(CssBackgroundRepeat repeat) {
            this.repeat = repeat;
            return this;
        }

        public Builder setSize(BackgroundSize size) {
            this.size = new ConcreteProperty<>(size);
            return this;
        }

        public Builder setSize(CssBackgroundSize size) {
            this.size = size;
            return this;
        }
    }

    private CssProperty<BackgroundAttachment> attachment;
    private CssProperty<Color> color;
    private CssProperty<BackgroundImage> image;
    private CssProperty<BackgroundOrigin> origin;
    private CssProperty<BackgroundPosition> position;
    private CssProperty<BackgroundRepeat> repeat;
    private CssProperty<BackgroundSize> size;
    private CssProperty<BackgroundClip> clip;

    public BackgroundShorthand() {
        this(new CssBackgroundAttachment(), new CssBackgroundColor(), new CssBackgroundImage(),
                new CssBackgroundOrigin(), new CssBackgroundPosition(),
                new CssBackgroundRepeat(), new CssBackgroundSize(), new CssBackgroundClip());
    }

    public BackgroundShorthand(Builder builder) {
        this.attachment = builder.attachment;
        this.color = builder.color;
        this.image = builder.image;
        this.origin = builder.origin;
        this.position = builder.position;
        this.repeat = builder.repeat;
        this.size = builder.size;
        this.clip = builder.clip;
    }

    public BackgroundShorthand(CssBackgroundAttachment attachment, CssBackgroundColor color, CssBackgroundImage image,
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
    public void cascadeFrom(BackgroundShorthand parent) {
        attachment = CssProperty.cascade(parent.attachment, attachment);
        color = CssProperty.cascade(parent.color, color);
        image = CssProperty.cascade(parent.image, image);
        origin = CssProperty.cascade(parent.origin, origin);
        position = CssProperty.cascade(parent.position, position);
        repeat = CssProperty.cascade(parent.repeat, repeat);
        size = CssProperty.cascade(parent.size, size);
        clip = CssProperty.cascade(parent.clip, clip);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BackgroundShorthand other = (BackgroundShorthand) obj;
        return Objects.equals(attachment, other.attachment) && Objects.equals(clip, other.clip)
                && Objects.equals(color, other.color) && Objects.equals(image, other.image)
                && Objects.equals(origin, other.origin) && Objects.equals(position, other.position)
                && Objects.equals(repeat, other.repeat) && Objects.equals(size, other.size);
    }

    public CssProperty<BackgroundAttachment> getAttachment() {
        return attachment;
    }

    public CssProperty<BackgroundClip> getClip() {
        return clip;
    }

    public CssProperty<Color> getColor() {
        return color;
    }

    public CssProperty<BackgroundImage> getImage() {
        return image;
    }

    @Override
    public Background getInitialValue() {
        return new Background(CssBackgroundAttachment.INITIAL_VALUE, CssBackgroundClip.INITIAL_VALUE,
                CssBackgroundColor.INITIAL_VALUE, CssBackgroundImage.INITIAL_VALUE, CssBackgroundOrigin.INITIAL_VALUE,
                CssBackgroundPosition.INITIAL_VALUE, CssBackgroundRepeat.INITIAL_VALUE,
                CssBackgroundSize.INITIAL_VALUE);
    }

    public CssProperty<BackgroundOrigin> getOrigin() {
        return origin;
    }

    public CssProperty<BackgroundPosition> getPosition() {
        return position;
    }

    public CssProperty<BackgroundRepeat> getRepeat() {
        return repeat;
    }

    public CssProperty<BackgroundSize> getSize() {
        return size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(attachment, clip, color, image, origin, position, repeat, size);
    }

    @Override
    public String toString() {
        return "CssBackground [attachment=" + attachment + ", color=" + color + ", image=" + image + ", origin="
                + origin + ", position=" + position + ", repeat=" + repeat + ", size=" + size + ", clip=" + clip + "]";
    }

    @Override
    public void updateStyle(BackgroundShorthand newValue) {
        if (newValue == null) {
            return;
        }
        attachment = CssShorthand.newPropertyIfNotNull(attachment, newValue.attachment);
        color = CssShorthand.newPropertyIfNotNull(color, newValue.color);
        image = CssShorthand.newPropertyIfNotNull(image, newValue.image);
        origin = CssShorthand.newPropertyIfNotNull(origin, newValue.origin);
        position = CssShorthand.newPropertyIfNotNull(position, newValue.position);
        repeat = CssShorthand.newPropertyIfNotNull(repeat, newValue.repeat);
        size = CssShorthand.newPropertyIfNotNull(size, newValue.size);
        clip = CssShorthand.newPropertyIfNotNull(clip, newValue.clip);
    }
}
