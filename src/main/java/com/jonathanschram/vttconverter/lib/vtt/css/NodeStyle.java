package com.jonathanschram.vttconverter.lib.vtt.css;

import java.util.Objects;

import com.jonathanschram.vttconverter.lib.vtt.css.cascade.ConcreteProperty;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CssColor;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CssOpacity;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CssRubyPosition;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CssTextCombineUpright;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CssTextShadow;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CssVisibility;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CssWhitespace;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.background.BackgroundShorthand;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.decoration.TextDecorationShorthand;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.font.FontShorthand;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.outline.OutlineShorthand;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.Opacity;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.TextCombineUpright;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.TextShadow;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.Visibility;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.WhiteSpace;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.ruby.RubyPosition;
import com.jonathanschram.vttconverter.lib.vtt.css.types.Color;;

/***
 * The set of CSS properties that can apply to a cue node.
 */
public class NodeStyle {

    public static class Builder {
        private BackgroundShorthand background = new BackgroundShorthand();
        private CssProperty<Color> color = new CssColor();
        private FontShorthand font = new FontShorthand();
        private CssOpacity opacity = new CssOpacity();
        private OutlineShorthand outline = new OutlineShorthand();
        private CssRubyPosition rubyPosition = new CssRubyPosition();
        private CssTextCombineUpright textCombineUpright = new CssTextCombineUpright();
        private TextDecorationShorthand textDecoration = new TextDecorationShorthand();
        private CssTextShadow textShadow = new CssTextShadow();
        private CssVisibility visibility = new CssVisibility();
        private CssWhitespace whiteSpace = new CssWhitespace();

        public NodeStyle build() {
            return new NodeStyle(background, color, font, opacity, outline, rubyPosition, textCombineUpright,
                    textDecoration, textShadow, visibility, whiteSpace);
        }

        public Builder setBackground(BackgroundShorthand background) {
            this.background = background;
            return this;
        }

        public Builder setColor(Color newColor) {
            this.color = new ConcreteProperty<Color>(newColor);
            return this;
        }

        public Builder setColor(CssProperty<Color> color) {
            this.color = color;
            return this;
        }

        public Builder setFont(FontShorthand font) {
            this.font = font;
            return this;
        }

        public Builder setOpacity(CssOpacity opacity) {
            this.opacity = opacity;
            return this;
        }

        public Builder setOutline(OutlineShorthand outline) {
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

        public Builder setTextDecoration(TextDecorationShorthand textDecoration) {
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

    // Shorthand properties.
    private final BackgroundShorthand background;
    private final FontShorthand font;
    private final OutlineShorthand outline;
    private final TextDecorationShorthand textDecoration;

    // Single properties.
    private CssProperty<Color> color;
    private CssProperty<Opacity> opacity;
    private CssProperty<RubyPosition> rubyPosition;
    private CssProperty<TextCombineUpright> textCombineUpright;
    private CssProperty<TextShadow> textShadow;
    private CssProperty<Visibility> visibility;
    private CssProperty<WhiteSpace> whiteSpace;

    /***
     * Constructor for NodeStyle that has all values unset.
     */
    public NodeStyle() {
        this(new BackgroundShorthand(), new CssColor(), new FontShorthand(), new CssOpacity(),
                new OutlineShorthand(),
                new CssRubyPosition(), new CssTextCombineUpright(), new TextDecorationShorthand(), new CssTextShadow(),
                new CssVisibility(), new CssWhitespace());
    }

    public NodeStyle(BackgroundShorthand background, CssProperty<Color> color, FontShorthand font, CssOpacity opacity,
            OutlineShorthand outline,
            CssRubyPosition rubyPosition, CssTextCombineUpright textCombineUpright,
            TextDecorationShorthand textDecoration,
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

    public BackgroundShorthand getBackground() {
        return background;
    }

    public CssProperty<Color> getColor() {
        return color;
    }

    public FontShorthand getFont() {
        return font;
    }

    public CssProperty<Opacity> getOpacity() {
        return opacity;
    }

    public OutlineShorthand getOutline() {
        return outline;
    }

    public CssProperty<RubyPosition> getRubyPosition() {
        return rubyPosition;
    }

    public CssProperty<TextCombineUpright> getTextCombineUpright() {
        return textCombineUpright;
    }

    public TextDecorationShorthand getTextDecoration() {
        return textDecoration;
    }

    public CssProperty<TextShadow> getTextShadow() {
        return textShadow;
    }

    public CssProperty<Visibility> getVisibility() {
        return visibility;
    }

    public CssProperty<WhiteSpace> getWhiteSpace() {
        return whiteSpace;
    }

    public void cascadeFrom(NodeStyle parent) throws UnresolvedPropertyException, UncomputedValueException {
        if (parent == null) {
            return;
        }

        color = CssProperty.cascade(parent.color, color);
        opacity = CssProperty.cascade(parent.opacity, opacity);
        rubyPosition = CssProperty.cascade(parent.rubyPosition, rubyPosition);
        textCombineUpright = CssProperty.cascade(parent.textCombineUpright, textCombineUpright);
        textShadow = CssProperty.cascade(parent.textShadow, textShadow);
        visibility = CssProperty.cascade(parent.visibility, visibility);
        whiteSpace = CssProperty.cascade(parent.whiteSpace, whiteSpace);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(background, color, font, opacity, outline, rubyPosition, textCombineUpright, textDecoration,
                textShadow, visibility, whiteSpace);
    }

    @Override
    public String toString() {
        return "NodeStyle [background=" + background + ", font=" + font + ", outline=" + outline + ", textDecoration="
                + textDecoration + ", color=" + color + ", opacity=" + opacity + ", rubyPosition=" + rubyPosition
                + ", textCombineUpright=" + textCombineUpright + ", textShadow=" + textShadow + ", visibility="
                + visibility + ", whiteSpace=" + whiteSpace + "]";
    }

    /***
     * Convenience method for updating the background shorthand styles.
     * 
     * @param newBackground
     */
    public void updateBackground(BackgroundShorthand newBackground) {
        background.updateStyle(newBackground);
    }

    public void updateColor(CssProperty<Color> newColor) {
        color = calculateUpdate(color, newColor);
    }

    /***
     * Convenience method for updating the font shorthand styles.
     * 
     * @param newFont
     */
    public void updateFont(FontShorthand newFont) {
        font.updateStyle(newFont);
    }

    public void updateOpacity(CssProperty<Opacity> newOpacity) {
        opacity = calculateUpdate(opacity, newOpacity);
    }

    /***
     * Convenience method for updating the outline shorthand styles.
     * 
     * @param newOutline
     */
    public void updateOutline(OutlineShorthand newOutline) {
        outline.updateStyle(newOutline);
    }

    public void updateRubyPosition(CssProperty<RubyPosition> newPosition) {
        rubyPosition = calculateUpdate(rubyPosition, newPosition);
    }

    public void updateTextCombineUpright(CssProperty<TextCombineUpright> newValue) {
        textCombineUpright = calculateUpdate(textCombineUpright, newValue);
    }

    /***
     * Convenience method for updating the text decoration shorthand.
     * 
     * @param newTextDecoration
     */
    public void updateTextDecoration(TextDecorationShorthand newTextDecoration) {
        textDecoration.updateStyle(newTextDecoration);
    }

    public void updateTextShadow(CssProperty<TextShadow> newValue) {
        textShadow = calculateUpdate(textShadow, newValue);
    }

    public void updateVisibility(CssProperty<Visibility> newValue) {
        visibility = calculateUpdate(visibility, newValue);
    }

    public void updateWhitespace(CssProperty<WhiteSpace> newValue) {
        whiteSpace = calculateUpdate(whiteSpace, newValue);
    }

    private <T extends CssValue<T>> CssProperty<T> calculateUpdate(CssProperty<T> oldValue, CssProperty<T> newValue) {
        if (newValue != null) {
            return newValue;
        }
        return oldValue;
    }
}
