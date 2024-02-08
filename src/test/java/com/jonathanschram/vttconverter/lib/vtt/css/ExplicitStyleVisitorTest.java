package com.jonathanschram.vttconverter.lib.vtt.css;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;

import com.jonathanschram.vttconverter.lib.vtt.css.cascade.decoration.CssTextDecoration;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.font.CssFont;
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

        CssFont expectedFont = new CssFont.Builder().setWeight(new KeywordFontWeight(FontWeightKeyword.BOLD)).build();
        NodeStyle expectedStyle = new NodeStyle.Builder().setFont(expectedFont).build();

        assertEquals(expectedStyle, node.getStyle());
    }

    @Test
    void testVisitItalicNode() {
        ItalicsNode node = new ItalicsNode.Builder().build();

        ExplicitStyleVisitor visitor = new ExplicitStyleVisitor();
        visitor.visitItalicsNode(node);

        CssFont expectedFont = new CssFont.Builder().setStyle(new KeywordFontStyle(FontStyleKeyword.ITALIC)).build();
        NodeStyle expectedStyle = new NodeStyle.Builder().setFont(expectedFont).build();

        assertEquals(expectedStyle, node.getStyle());
    }

    @Test
    void testVisitUnderlineNode() {
        UnderlineNode node = new UnderlineNode.Builder().build();

        ExplicitStyleVisitor visitor = new ExplicitStyleVisitor();
        visitor.visitUnderlineNode(node);

        CssTextDecoration expectedDecoration = new CssTextDecoration.Builder().setLine(Set.of(LineType.UNDERLINE))
                .build();
        NodeStyle expectedStyle = new NodeStyle.Builder().setTextDecoration(expectedDecoration).build();

        assertEquals(expectedStyle, node.getStyle());
    }

    @Test
    void testAccept_NestedNodes() {
        ItalicsNode italicsNode = new ItalicsNode.Builder().build();
        // TODO: Add generics to node builder so this ugly pattern can be fixed.
        BoldNode.Builder boldBuilder = new BoldNode.Builder();
        boldBuilder.appendChild(italicsNode);
        BoldNode boldNode = boldBuilder.build();

        ExplicitStyleVisitor visitor = new ExplicitStyleVisitor();
        boldNode.accept(visitor);

        NodeStyle expectedBoldStyle = new NodeStyle.Builder()
                .setFont(new CssFont.Builder().setWeight(new KeywordFontWeight(FontWeightKeyword.BOLD)).build())
                .build();
        assertEquals(expectedBoldStyle, boldNode.getStyle());

        NodeStyle expectedItalicStyle = new NodeStyle.Builder()
                .setFont(new CssFont.Builder().setStyle(new KeywordFontStyle(FontStyleKeyword.ITALIC)).build()).build();
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
