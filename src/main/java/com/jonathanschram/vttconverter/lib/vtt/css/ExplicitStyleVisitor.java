package com.jonathanschram.vttconverter.lib.vtt.css;

import java.util.Set;

import com.jonathanschram.vttconverter.lib.vtt.css.cascade.decoration.CssTextDecoration;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.font.CssFont;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.font.CssFontWeight;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.decoration.LineType;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.FontStyleKeyword;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.FontWeightKeyword;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.KeywordFontStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.KeywordFontWeight;
import com.jonathanschram.vttconverter.lib.vtt.cue.NodeVisitor;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.BoldNode;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.ClassNode;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.ItalicsNode;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.LanguageNode;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.RubyNode;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.RubyTextNode;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.TextNode;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.TimestampNode;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.UnderlineNode;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.VoiceNode;

/***
 * A {@link NodeVisitor} that sets CSS properties explicitly required by that
 * node type. For example, a bold node must have the font weight set to bold.
 * Styles are not cascaded at this time.
 */
public class ExplicitStyleVisitor implements NodeVisitor {

    public ExplicitStyleVisitor() {
    }

    @Override
    public void visitBoldNode(BoldNode node) {
        CssFont fontUpdate = new CssFont.Builder()
                .setWeight(new CssFontWeight(new KeywordFontWeight(FontWeightKeyword.BOLD))).build();

        node.getStyle().getFont().updateStyle(fontUpdate);
    }

    @Override
    public void visitClassNode(ClassNode node) {
        // No explicit style needed.
    }

    @Override
    public void visitItalicsNode(ItalicsNode node) {
        CssFont fontUpdate = new CssFont.Builder()
                .setStyle(new KeywordFontStyle(FontStyleKeyword.ITALIC))
                .build();

        node.getStyle().getFont().updateStyle(fontUpdate);
    }

    @Override
    public void visitLanguageNode(LanguageNode node) {
        // No explicit style needed.
    }

    @Override
    public void visitRubyNode(RubyNode node) {
        // No explicit style needed.
    }

    @Override
    public void visitRubyTextNode(RubyTextNode node) {
        // No explicit style needed.
    }

    @Override
    public void visitTextNode(TextNode node) {
        // No explicit style needed.
    }

    @Override
    public void visitTimestampNode(TimestampNode node) {
        // No explicit style needed.
    }

    @Override
    public void visitUnderlineNode(UnderlineNode node) {
        CssTextDecoration decorationUpdate = new CssTextDecoration.Builder().setLine(Set.of(LineType.UNDERLINE))
                .build();
        node.getStyle().getTextDecoration().updateStyle(decorationUpdate);
    }

    @Override
    public void visitVoiceNode(VoiceNode node) {
        // No explicit style needed.
    }

}
