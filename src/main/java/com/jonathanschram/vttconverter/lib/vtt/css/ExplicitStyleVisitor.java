package com.jonathanschram.vttconverter.lib.vtt.css;

import com.jonathanschram.vttconverter.lib.vtt.css.cascade.decoration.TextDecorationShorthand;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.font.FontShorthand;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.decoration.LineType;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.decoration.LineTypeSet;
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
        FontShorthand fontUpdate = FontShorthand.Builder.createUpdate()
                .setWeight(new KeywordFontWeight(FontWeightKeyword.BOLD)).build();

        node.getStyle().updateFont(fontUpdate);
    }

    @Override
    public void visitClassNode(ClassNode node) {
        // No explicit style needed.
    }

    @Override
    public void visitItalicsNode(ItalicsNode node) {
        FontShorthand fontUpdate = FontShorthand.Builder.createUpdate()
                .setStyle(new KeywordFontStyle(FontStyleKeyword.ITALIC))
                .build();

        node.getStyle().updateFont(fontUpdate);
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
        TextDecorationShorthand decorationUpdate = TextDecorationShorthand.Builder.createUpdate()
                .setLine(new LineTypeSet(LineType.UNDERLINE))
                .build();
        node.getStyle().updateTextDecoration(decorationUpdate);
    }

    @Override
    public void visitVoiceNode(VoiceNode node) {
        // No explicit style needed.
    }

}
