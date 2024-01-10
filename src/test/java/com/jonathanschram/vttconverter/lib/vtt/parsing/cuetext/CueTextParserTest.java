package com.jonathanschram.vttconverter.lib.vtt.parsing.cuetext;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.jonathanschram.vttconverter.lib.vtt.cue.TimeCode;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.BoldNode;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.ClassNode;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.ItalicsNode;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.LanguageNode;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.RootCueNode;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.RubyNode;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.RubyTextNode;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.TextNode;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.TimestampNode;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.UnderlineNode;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.VoiceNode;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.VttNode;

class CueTextParserTest {

    @Test
    void testParse_SimpleText() {
        List<CueTextToken> tokens = List.of(new StringToken("Hello, world!"));

        CueTextParser parser = new CueTextParser(tokens.iterator());
        RootCueNode node = parser.parse();

        assertEquals(0, node.getClasses().size());
        assertEquals(1, node.getChildren().size());

        VttNode child = node.getChildren().get(0);
        assertInstanceOf(TextNode.class, child);
        assertEquals("Hello, world!", ((TextNode) child).getText());

        assertNull(node.getApplicableLanguage());
    }

    @Test
    void testParse_FallbackLanguage() {
        List<CueTextToken> tokens = List.of(new StringToken("Test"));

        CueTextParser parser = new CueTextParser(tokens.iterator());
        RootCueNode node = parser.parse("en");

        assertEquals(1, node.getChildren().size());

        VttNode child = node.getChildren().get(0);
        assertInstanceOf(TextNode.class, child);
        assertEquals("Test", ((TextNode) child).getText());

        assertEquals("en", node.getApplicableLanguage());
    }

    @Test
    void testParse_EmptyItalicNode() {
        List<CueTextToken> tokens = List.of(new StartTagToken("i", List.of(), null), new EndTagToken("i"));

        CueTextParser parser = new CueTextParser(tokens.iterator());
        RootCueNode node = parser.parse();

        assertEquals(1, node.getChildren().size());

        VttNode child = node.getChildren().get(0);
        assertInstanceOf(ItalicsNode.class, child);

        ItalicsNode italicChild = (ItalicsNode) child;
        assertEquals(0, italicChild.getChildren().size());
        assertEquals(0, italicChild.getClasses().size());
        assertEquals(null, italicChild.getApplicableLanguage());
    }

    @Test
    void testParse_UnexpectedAnnotation() {
        List<CueTextToken> tokens = List.of(new StartTagToken("i", List.of(), "annotation"), new EndTagToken("i"));

        CueTextParser parser = new CueTextParser(tokens.iterator());
        RootCueNode node = parser.parse();

        assertEquals(1, node.getChildren().size());

        VttNode child = node.getChildren().get(0);
        assertInstanceOf(ItalicsNode.class, child);

        ItalicsNode italicChild = (ItalicsNode) child;
        assertEquals(0, italicChild.getChildren().size());
        assertEquals(0, italicChild.getClasses().size());
        assertEquals(null, italicChild.getApplicableLanguage());
    }

    @Test
    void testParse_TimestampNode() {
        List<CueTextToken> tokens = List.of(new TimestampTagToken("00:00:10.500"));
        CueTextParser parser = new CueTextParser(tokens.iterator());

        RootCueNode node = parser.parse();

        assertEquals(1, node.getChildren().size());

        assertInstanceOf(TimestampNode.class, node.getChildren().get(0));
        TimestampNode timeNode = (TimestampNode) node.getChildren().get(0);
        assertEquals(new TimeCode(0, 0, 10, 500), timeNode.getTimeCode());
    }

    @Test
    void testParse_InvalidTimestamp() {
        List<CueTextToken> tokens = List.of(new TimestampTagToken("00:00:10.500"));
        CueTextParser parser = new CueTextParser(tokens.iterator());

        RootCueNode node = parser.parse();

        assertEquals(1, node.getChildren().size());

        assertInstanceOf(TimestampNode.class, node.getChildren().get(0));
        TimestampNode timeNode = (TimestampNode) node.getChildren().get(0);
        assertEquals(new TimeCode(0, 0, 10, 500), timeNode.getTimeCode());
    }

    @Test
    void testParse_InvalidTimestamp_TrailingCharacters() {
        List<CueTextToken> tokens = List.of(new TimestampTagToken("00:00:10.500abc"));
        CueTextParser parser = new CueTextParser(tokens.iterator());

        RootCueNode node = parser.parse();

        assertEquals(0, node.getChildren().size());
    }

    @Test
    void testParse_InvalidTimestamp_IncorrectFormat() {
        List<CueTextToken> tokens = List.of(new TimestampTagToken("0123"));
        CueTextParser parser = new CueTextParser(tokens.iterator());

        RootCueNode node = parser.parse();

        assertEquals(0, node.getChildren().size());
    }

    @Test
    void testParse_RubyTag() {
        List<CueTextToken> tokens = List.of(
                new StartTagToken("ruby", List.of(), null),
                new StringToken("Base"),
                new StartTagToken("rt", List.of(), null),
                new StringToken("Ruby text"),
                new EndTagToken("rt"),
                new EndTagToken("ruby"));

        CueTextParser parser = new CueTextParser(tokens.iterator());
        RootCueNode node = parser.parse();

        assertNull(node.getApplicableLanguage());
        assertEquals(0, node.getClasses().size());
        assertEquals(1, node.getChildren().size());

        VttNode rubyNode = (RubyNode) node.getChildren().get(0);
        assertInstanceOf(RubyNode.class, rubyNode);
        assertEquals(null, ((RubyNode) rubyNode).getApplicableLanguage());

        List<VttNode> rubyChildren = ((RubyNode) rubyNode).getChildren();
        assertEquals(2, rubyChildren.size());

        VttNode baseText = rubyChildren.get(0);
        assertInstanceOf(TextNode.class, baseText);
        assertEquals("Base", ((TextNode) baseText).getText());

        VttNode rubyTextNode = rubyChildren.get(1);
        assertInstanceOf(RubyTextNode.class, rubyTextNode);

        List<VttNode> rubyTextChildren = ((RubyTextNode) rubyTextNode).getChildren();
        assertEquals(1, rubyTextChildren.size());

        VttNode rubyText = rubyTextChildren.get(0);
        assertInstanceOf(TextNode.class, rubyText);
        assertEquals("Ruby text", ((TextNode) rubyText).getText());
    }

    @Test
    void testParse_RubyTag_OmittedEndingRtTag() {
        List<CueTextToken> tokens = List.of(
                new StartTagToken("ruby", List.of(), null),
                new StringToken("Base"),
                new StartTagToken("rt", List.of(), null),
                new StringToken("Ruby text"),
                new EndTagToken("ruby"),
                new StringToken("Following"));

        CueTextParser parser = new CueTextParser(tokens.iterator());
        RootCueNode node = parser.parse();

        assertNull(node.getApplicableLanguage());
        assertEquals(0, node.getClasses().size());
        assertEquals(2, node.getChildren().size());

        VttNode rubyNode = (RubyNode) node.getChildren().get(0);
        assertInstanceOf(RubyNode.class, rubyNode);
        assertEquals(null, ((RubyNode) rubyNode).getApplicableLanguage());

        List<VttNode> rubyChildren = ((RubyNode) rubyNode).getChildren();
        assertEquals(2, rubyChildren.size());

        VttNode baseText = rubyChildren.get(0);
        assertInstanceOf(TextNode.class, baseText);
        assertEquals("Base", ((TextNode) baseText).getText());

        VttNode rubyTextNode = rubyChildren.get(1);
        assertInstanceOf(RubyTextNode.class, rubyTextNode);

        List<VttNode> rubyTextChildren = ((RubyTextNode) rubyTextNode).getChildren();
        assertEquals(1, rubyTextChildren.size());

        VttNode rubyText = rubyTextChildren.get(0);
        assertInstanceOf(TextNode.class, rubyText);
        assertEquals("Ruby text", ((TextNode) rubyText).getText());

        VttNode followingTextNode = node.getChildren().get(1);
        assertInstanceOf(TextNode.class, followingTextNode);
        assertEquals("Following", ((TextNode) followingTextNode).getText());
    }

    @Test
    void testParse_RubyTextTagWithoutRuby() {
        List<CueTextToken> tokens = List.of(
                new StartTagToken("rt", List.of(), null),
                new StringToken("Ruby text"),
                new EndTagToken("rt"));

        CueTextParser parser = new CueTextParser(tokens.iterator());
        RootCueNode node = parser.parse();

        assertNull(node.getApplicableLanguage());
        assertEquals(1, node.getChildren().size());

        VttNode rubyText = node.getChildren().get(0);
        assertInstanceOf(TextNode.class, rubyText);
        assertEquals("Ruby text", ((TextNode) rubyText).getText());
    }

    @Test
    void testParse_LangaugeTag() {
        List<CueTextToken> tokens = List.of(
                new StartTagToken("lang", List.of(), "ja"),
                new StartTagToken("c", List.of(), null),
                new EndTagToken("c"),
                new EndTagToken("lang"));

        CueTextParser parser = new CueTextParser(tokens.iterator());
        RootCueNode node = parser.parse();

        assertNull(node.getApplicableLanguage());
        assertEquals(0, node.getClasses().size());
        assertEquals(1, node.getChildren().size());

        VttNode child = node.getChildren().get(0);
        assertInstanceOf(LanguageNode.class, child);
        assertEquals("ja", ((LanguageNode) child).getApplicableLanguage());

        assertEquals(1, ((LanguageNode) child).getChildren().size());

        VttNode classNode = ((LanguageNode) child).getChildren().get(0);
        assertInstanceOf(ClassNode.class, classNode);
        assertEquals("ja", ((ClassNode) classNode).getApplicableLanguage());
    }

    @Test
    void testParse_LangaugeTag_NoLanguageSet() {
        List<CueTextToken> tokens = List.of(new StartTagToken("lang", List.of(), null), new EndTagToken("lang"));

        CueTextParser parser = new CueTextParser(tokens.iterator());
        RootCueNode node = parser.parse();

        assertNull(node.getApplicableLanguage());
        assertEquals(0, node.getClasses().size());
        assertEquals(1, node.getChildren().size());

        VttNode child = node.getChildren().get(0);
        assertInstanceOf(LanguageNode.class, child);
        assertEquals("", ((LanguageNode) child).getApplicableLanguage());
    }

    @Test
    void testParse_LangaugeTag_WithFallback() {
        List<CueTextToken> tokens = List.of(new StartTagToken("lang", List.of(), "ja"), new EndTagToken("lang"));

        CueTextParser parser = new CueTextParser(tokens.iterator());
        RootCueNode node = parser.parse("en");

        assertEquals("en", node.getApplicableLanguage());
        assertEquals(0, node.getClasses().size());
        assertEquals(1, node.getChildren().size());

        VttNode child = node.getChildren().get(0);
        assertInstanceOf(LanguageNode.class, child);
        assertEquals("ja", ((LanguageNode) child).getApplicableLanguage());
    }

    @Test
    void testParse_VoiceTag() {
        List<CueTextToken> tokens = List.of(new StartTagToken("v", List.of(), "Joe"), new EndTagToken("v"));

        CueTextParser parser = new CueTextParser(tokens.iterator());
        RootCueNode node = parser.parse();

        assertEquals(1, node.getChildren().size());

        VttNode child = node.getChildren().get(0);
        assertInstanceOf(VoiceNode.class, child);

        VoiceNode voiceChild = (VoiceNode) child;
        assertEquals(0, voiceChild.getChildren().size());
        assertEquals(0, voiceChild.getClasses().size());
        assertEquals(null, voiceChild.getApplicableLanguage());
        assertEquals("Joe", voiceChild.getVoiceName());
    }

    @Test
    void testParse_TagClasses() {
        List<CueTextToken> tokens = List.of(new StartTagToken("b", List.of("test_tag", "", "second"), null),
                new EndTagToken("b"));

        CueTextParser parser = new CueTextParser(tokens.iterator());
        RootCueNode node = parser.parse();

        assertEquals(1, node.getChildren().size());

        VttNode child = node.getChildren().get(0);
        assertInstanceOf(BoldNode.class, child);

        BoldNode boldChild = (BoldNode) child;
        assertEquals(0, boldChild.getChildren().size());
        assertIterableEquals(List.of("test_tag", "second"), boldChild.getClasses());
        assertEquals(null, boldChild.getApplicableLanguage());
    }

    @Test
    void testParse_MissingEndTag() {
        List<CueTextToken> tokens = List.of(new StartTagToken("u", List.of(), null), new StringToken("Underlined"));

        CueTextParser parser = new CueTextParser(tokens.iterator());
        RootCueNode node = parser.parse();

        assertEquals(1, node.getChildren().size());

        VttNode child = node.getChildren().get(0);
        assertInstanceOf(UnderlineNode.class, child);

        UnderlineNode underlineChild = (UnderlineNode) child;
        assertEquals(1, underlineChild.getChildren().size());

        VttNode innerText = underlineChild.getChildren().get(0);
        assertInstanceOf(TextNode.class, innerText);
        assertEquals("Underlined", ((TextNode) innerText).getText());
    }

    @Test
    void testParse_MismatchedEndTag() {
        List<CueTextToken> tokens = List.of(
                new StartTagToken("c", List.of(), null),
                new StringToken("inner"),
                new EndTagToken("u"),
                new StringToken("after end underline"));

        CueTextParser parser = new CueTextParser(tokens.iterator());
        RootCueNode node = parser.parse();

        assertEquals(1, node.getChildren().size());

        VttNode child = node.getChildren().get(0);
        assertInstanceOf(ClassNode.class, child);

        ClassNode classChild = (ClassNode) child;
        assertEquals(2, classChild.getChildren().size());

        VttNode innerText = classChild.getChildren().get(0);
        assertInstanceOf(TextNode.class, innerText);
        assertEquals("inner", ((TextNode) innerText).getText());

        // If the end tag doesn't match the start, it is skipped, and therefore any text
        // following it is still a child of that element.
        VttNode afterText = classChild.getChildren().get(1);
        assertInstanceOf(TextNode.class, afterText);
        assertEquals("after end underline", ((TextNode) afterText).getText());
    }

    @Test
    void testParse_InvalidTag() {
        List<CueTextToken> tokens = List.of(new StartTagToken("fake", List.of(), null),
                new StringToken("Inner"),
                new EndTagToken("fake"));

        CueTextParser parser = new CueTextParser(tokens.iterator());
        RootCueNode node = parser.parse();

        assertEquals(1, node.getChildren().size());

        VttNode innerNode = node.getChildren().get(0);
        assertInstanceOf(TextNode.class, innerNode);
        assertEquals("Inner", ((TextNode) innerNode).getText());

    }

    @Test
    void testParse_FailSecondParse() {
        List<CueTextToken> tokens = List.of();
        CueTextParser parser = new CueTextParser(tokens.iterator());

        // Parse once and ignore result.
        parser.parse();

        assertThrows(IllegalStateException.class, () -> parser.parse());
    }
}
