package com.jonathanschram.vttconverter.lib.vtt.css;

import com.jonathanschram.vttconverter.lib.vtt.css.properties.Opacity;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.TextCombineUpright;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.TextShadow;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.Visibility;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.WhiteSpace;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.background.Background;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.decoration.TextDecoration;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.Font;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.outline.Outline;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.ruby.RubyPosition;
import com.jonathanschram.vttconverter.lib.vtt.css.types.AbsoluteColor;

/***
 * The set of CSS properties that can apply to a cue node.
 */
public class NodeStyle {
    private final AbsoluteColor color;
    private final Opacity opacity;
    private final Visibility visibility;
    private final TextDecoration textDecoration;
    private final TextShadow textShadow;
    private final Background background;
    private final Outline outline;
    private final Font font;
    private final WhiteSpace whiteSpace;
    private final TextCombineUpright textCombineUpright;
    private final RubyPosition rubyPosition;

    public NodeStyle(AbsoluteColor color, Opacity opacity, Visibility visibility, TextDecoration textDecoration,
            TextShadow textShadow, Background background, Outline outline, Font font, WhiteSpace whiteSpace,
            TextCombineUpright textCombineUpright, RubyPosition rubyPosition) {
        super();
        this.color = color;
        this.opacity = opacity;
        this.visibility = visibility;
        this.textDecoration = textDecoration;
        this.textShadow = textShadow;
        this.background = background;
        this.outline = outline;
        this.font = font;
        this.whiteSpace = whiteSpace;
        this.textCombineUpright = textCombineUpright;
        this.rubyPosition = rubyPosition;
    }

    public AbsoluteColor getColor() {
        return color;
    }

    public Opacity getOpacity() {
        return opacity;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public TextDecoration getTextDecoration() {
        return textDecoration;
    }

    public TextShadow getTextShadow() {
        return textShadow;
    }

    public Background getBackground() {
        return background;
    }

    public Outline getOutline() {
        return outline;
    }

    public Font getFont() {
        return font;
    }

    public WhiteSpace getWhiteSpace() {
        return whiteSpace;
    }

    public TextCombineUpright getTextCombineUpright() {
        return textCombineUpright;
    }

    public RubyPosition getRubyPosition() {
        return rubyPosition;
    }
}
