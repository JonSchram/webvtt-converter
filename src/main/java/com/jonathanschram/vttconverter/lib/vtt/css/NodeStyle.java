package com.jonathanschram.vttconverter.lib.vtt.css;

import java.util.Objects;

import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CssColor;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CssOpacity;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CssRubyPosition;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CssTextCombineUpright;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CssTextShadow;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CssVisibility;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CssWhitespace;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.background.CssBackground;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.decoration.CssTextDecoration;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.font.CssFont;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.outline.CssOutline;

/***
 * The set of CSS properties that can apply to a cue node.
 */
public class NodeStyle {

    public static class Builder {
        private CssBackground background = new CssBackground();
        private CssColor color = new CssColor();
        private CssFont font = new CssFont();
        private CssOpacity opacity = new CssOpacity();
        private CssOutline outline = new CssOutline();
        private CssRubyPosition rubyPosition = new CssRubyPosition();
        private CssTextCombineUpright textCombineUpright = new CssTextCombineUpright();
        private CssTextDecoration textDecoration = new CssTextDecoration();
        private CssTextShadow textShadow = new CssTextShadow();
        private CssVisibility visibility = new CssVisibility();
        private CssWhitespace whiteSpace = new CssWhitespace();

        public NodeStyle build() {
            return new NodeStyle(background, color, font, opacity, outline, rubyPosition, textCombineUpright,
                    textDecoration, textShadow, visibility, whiteSpace);
        }

        public Builder setBackground(CssBackground background) {
            this.background = background;
            return this;
        }

        public Builder setColor(CssColor color) {
            this.color = color;
            return this;
        }

        public Builder setFont(CssFont font) {
            this.font = font;
            return this;
        }

        public Builder setOpacity(CssOpacity opacity) {
            this.opacity = opacity;
            return this;
        }

        public Builder setOutline(CssOutline outline) {
            this.outline = outline;
            return this;
        }

        public Builder setRubyPosition(CssRubyPosition rubyPosition) {
            this.rubyPosition = rubyPosition;
            return this;
        }

        public Builder setTextCombineUpright(CssTextCombineUpright textCombineUpright) {
            this.textCombineUpright = textCombineUpright;
            return this;
        }

        public Builder setTextDecoration(CssTextDecoration textDecoration) {
            this.textDecoration = textDecoration;
            return this;
        }

        public Builder setTextShadow(CssTextShadow textShadow) {
            this.textShadow = textShadow;
            return this;
        }

        public Builder setVisibility(CssVisibility visibility) {
            this.visibility = visibility;
            return this;
        }

        public Builder setWhiteSpace(CssWhitespace whiteSpace) {
            this.whiteSpace = whiteSpace;
            return this;
        }

    }

    private final CssBackground background;
    private final CssColor color;
    private final CssFont font;
    private final CssOpacity opacity;
    private final CssOutline outline;
    private final CssRubyPosition rubyPosition;
    private final CssTextCombineUpright textCombineUpright;
    private final CssTextDecoration textDecoration;
    private final CssTextShadow textShadow;
    private final CssVisibility visibility;
    private final CssWhitespace whiteSpace;

    /***
     * Constructor for NodeStyle that has all values unset.
     */
    public NodeStyle() {
        this(new CssBackground(), new CssColor(), new CssFont(), new CssOpacity(), new CssOutline(),
                new CssRubyPosition(), new CssTextCombineUpright(), new CssTextDecoration(), new CssTextShadow(),
                new CssVisibility(), new CssWhitespace());
    }

    public NodeStyle(CssBackground background, CssColor color, CssFont font, CssOpacity opacity, CssOutline outline,
            CssRubyPosition rubyPosition, CssTextCombineUpright textCombineUpright, CssTextDecoration textDecoration,
            CssTextShadow textShadow, CssVisibility visibility, CssWhitespace whiteSpace) {
        this.background = background;
        this.color = color;
        this.font = font;
        this.opacity = opacity;
        this.outline = outline;
        this.rubyPosition = rubyPosition;
        this.textCombineUpright = textCombineUpright;
        this.textDecoration = textDecoration;
        this.textShadow = textShadow;
        this.visibility = visibility;
        this.whiteSpace = whiteSpace;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        NodeStyle other = (NodeStyle) obj;
        return Objects.equals(background, other.background) && Objects.equals(color, other.color)
                && Objects.equals(font, other.font) && Objects.equals(opacity, other.opacity)
                && Objects.equals(outline, other.outline) && Objects.equals(rubyPosition, other.rubyPosition)
                && Objects.equals(textCombineUpright, other.textCombineUpright)
                && Objects.equals(textDecoration, other.textDecoration) && Objects.equals(textShadow, other.textShadow)
                && Objects.equals(visibility, other.visibility) && Objects.equals(whiteSpace, other.whiteSpace);
    }

    public CssBackground getBackground() {
        return background;
    }

    public CssColor getColor() {
        return color;
    }

    public CssFont getFont() {
        return font;
    }

    public CssOpacity getOpacity() {
        return opacity;
    }

    public CssOutline getOutline() {
        return outline;
    }

    public CssRubyPosition getRubyPosition() {
        return rubyPosition;
    }

    public CssTextCombineUpright getTextCombineUpright() {
        return textCombineUpright;
    }

    public CssTextDecoration getTextDecoration() {
        return textDecoration;
    }

    public CssTextShadow getTextShadow() {
        return textShadow;
    }

    public CssVisibility getVisibility() {
        return visibility;
    }

    public CssWhitespace getWhiteSpace() {
        return whiteSpace;
    }

    @Override
    public int hashCode() {
        return Objects.hash(background, color, font, opacity, outline, rubyPosition, textCombineUpright, textDecoration,
                textShadow, visibility, whiteSpace);
    }
}
