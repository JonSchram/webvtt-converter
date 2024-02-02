package com.jonathanschram.vttconverter.lib.vtt.layout;

import com.jonathanschram.vttconverter.lib.vtt.css.properties.TextShadow;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.Visibility;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.background.Background;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.decoration.TextDecoration;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.Font;
import com.jonathanschram.vttconverter.lib.vtt.css.types.Color;

/***
 * The set of CSS styles that can apply to text runs in a style box. This is a
 * subset of all CSS properties.
 */
public class TextStyle {
    private final Color color;
    private final int opacity;
    private final Visibility visibility;
    private final TextDecoration textDecoration;
    private final TextShadow textShadow;
    private final Background background;
    private final Font font;

    public TextStyle(Color color, int opacity, Visibility visibility, TextDecoration textDecoration,
            TextShadow textShadow, Background background, Font font) {
        super();
        this.color = color;
        this.opacity = opacity;
        this.visibility = visibility;
        this.textDecoration = textDecoration;
        this.textShadow = textShadow;
        this.background = background;
        this.font = font;
    }

    public Background getBackground() {
        return background;
    }

    public Color getColor() {
        return color;
    }

    public Font getFont() {
        return font;
    }

    public int getOpacity() {
        return opacity;
    }

    public TextDecoration getTextDecoration() {
        return textDecoration;
    }

    public TextShadow getTextShadow() {
        return textShadow;
    }

    public Visibility getVisibility() {
        return visibility;
    }

}
