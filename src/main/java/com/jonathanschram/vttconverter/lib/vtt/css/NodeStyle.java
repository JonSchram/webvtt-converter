package com.jonathanschram.vttconverter.lib.vtt.css;

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
        background = new CssBackground();
        color = new CssColor();
        font = new CssFont();
        opacity = new CssOpacity();
        outline = new CssOutline();
        rubyPosition = new CssRubyPosition();
        textCombineUpright = new CssTextCombineUpright();
        textDecoration = new CssTextDecoration();
        textShadow = new CssTextShadow();
        visibility = new CssVisibility();
        whiteSpace = new CssWhitespace();
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
}
