package com.jonathanschram.vttconverter.lib.vtt.css;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;

import com.jonathanschram.vttconverter.lib.vtt.css.cascade.decoration.TextDecorationShorthand;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.font.FontShorthand;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.decoration.LineType;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.FontStyleKeyword;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.FontWeightKeyword;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.KeywordFontStyle;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.KeywordFontWeight;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.BoldNode;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.ItalicsNode;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.TextNode;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.UnderlineNode;

class ExplicitStyleVisitorTest {

    @Test
    void testVisitBoldNode() {
        // TODO: This and below create a builder without setting any properties. There
        // should be constructors that build default nodes with no children, for
        // convenience.
        BoldNode node = new BoldNode.Builder().build();

        ExplicitStyleVisitor visitor = new ExplicitStyleVisitor();
        visitor.visitBoldNode(node);

        FontShorthand expectedFont = FontShorthand.Builder.createUnset()
                .setWeight(new KeywordFontWeight(FontWeightKeyword.BOLD)).build();
        NodeStyle expectedStyle = new NodeStyle.Builder().setFont(expectedFont).build();

        assertEquals(expectedStyle, node.getStyle());
    }

    @Test
    void testVisitItalicNode() {
        ItalicsNode node = new ItalicsNode.Builder().build();

        ExplicitStyleVisitor visitor = new ExplicitStyleVisitor();
        visitor.visitItalicsNode(node);

        FontShorthand expectedFont = FontShorthand.Builder.createUnset()
                .setStyle(new KeywordFontStyle(FontStyleKeyword.ITALIC))
                .build();
        NodeStyle expectedStyle = new NodeStyle.Builder().setFont(expectedFont).build();

        assertEquals(expectedStyle, node.getStyle());
    }

    @Test
    void testVisitUnderlineNode() {
        UnderlineNode node = new UnderlineNode.Builder().build();

        ExplicitStyleVisitor visitor = new ExplicitStyleVisitor();
        visitor.visitUnderlineNode(node);

        TextDecorationShorthand expectedDecoration = TextDecorationShorthand.Builder.createUnset()
                .setLine(Set.of(LineType.UNDERLINE))
                .build();
        NodeStyle expectedStyle = new NodeStyle.Builder().setTextDecoration(expectedDecoration).build();

        assertEquals(expectedStyle, node.getStyle());
    }

    @Test
    void testAccept_NestedNodes() {
        ItalicsNode italicsNode = new ItalicsNode.Builder().build();
        BoldNode boldNode = new BoldNode.Builder().appendChild(italicsNode).build();

        ExplicitStyleVisitor visitor = new ExplicitStyleVisitor();
        boldNode.accept(visitor);

        NodeStyle expectedBoldStyle = new NodeStyle.Builder()
                .setFont(FontShorthand.Builder.createUnset().setWeight(new KeywordFontWeight(FontWeightKeyword.BOLD))
                        .build())
                .build();
        assertEquals(expectedBoldStyle, boldNode.getStyle());

        NodeStyle expectedItalicStyle = new NodeStyle.Builder()
                .setFont(FontShorthand.Builder.createUnset().setStyle(new KeywordFontStyle(FontStyleKeyword.ITALIC))
                        .build())
                .build();
        assertEquals(expectedItalicStyle, italicsNode.getStyle());
    }

    @Test
    void testVisitTextNode() {
        TextNode node = new TextNode.Builder().build();

        ExplicitStyleVisitor visitor = new ExplicitStyleVisitor();
        visitor.visitTextNode(node);

        assertEquals(new NodeStyle(), node.getStyle());
    }

}
