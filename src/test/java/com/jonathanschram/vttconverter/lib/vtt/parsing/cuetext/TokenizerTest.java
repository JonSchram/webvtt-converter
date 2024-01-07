package com.jonathanschram.vttconverter.lib.vtt.parsing.cuetext;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TokenizerTest {

    @Test
    void testGetTokens_SimpleText() {
        String cueText = "Hello, world!";
        List<CueTextToken> expectedTokens = List.of(new StringToken("Hello, world!"));
        tokenizeAndAssert(cueText, expectedTokens);
    }

    /***
     * Tests that multiple lines of text with no markup are returned as a single
     * string token.
     */
    @Test
    void testGetTokens_SimpleTextMultiline() {
        String cueText = "Hello,\nWorld!\nMultiple lines";
        List<CueTextToken> expectedTokens = List.of(new StringToken("Hello,\nWorld!\nMultiple lines"));
        tokenizeAndAssert(cueText, expectedTokens);
    }

    @Test
    void testGetTokens_TagMultiline() {
        String cueText = "<c>Some text\nNext line</c>";
        List<CueTextToken> expectedTokens = List.of(new StartTagToken("c", List.of(), null),
                new StringToken("Some text\nNext line"), new EndTagToken("c"));
        tokenizeAndAssert(cueText, expectedTokens);
    }

    @Test
    void testGetTokens_ClassNodeWithoutName() {
        String cueText = "<c>";
        List<CueTextToken> expectedTokens = List.of(new StartTagToken("c", List.of(), null));
        tokenizeAndAssert(cueText, expectedTokens);
    }

    @Test
    void testGetTokens_ClassNodeWithName() {
        String cueText = "<c.test>";
        List<CueTextToken> expectedTokens = List.of(new StartTagToken("c", List.of("test"), null));
        tokenizeAndAssert(cueText, expectedTokens);
    }

    @Test
    void testGetTokens_ClassNodeMultipleClasses() {
        String cueText = "<c.class1.class2>";
        List<CueTextToken> expectedTokens = List.of(new StartTagToken("c", List.of("class1", "class2"), null));
        tokenizeAndAssert(cueText, expectedTokens);
    }

    @Test
    void testGetTokens_CharacterReference() {
        String cueText = "&gt;";
        List<CueTextToken> expectedTokens = List.of(new StringToken(">"));
        tokenizeAndAssert(cueText, expectedTokens);
    }

    @Test
    void testGetTokens_ConsecutiveCharacterReferences() {
        String cueText = "&lt;&gt;";
        List<CueTextToken> expectedTokens = List.of(new StringToken("<>"));
        tokenizeAndAssert(cueText, expectedTokens);
    }

    @Test
    void testGetTokens_NumericCharacterReference() {
        String cueText = "&#x003c;";
        List<CueTextToken> expectedTokens = List.of(new StringToken("<"));
        tokenizeAndAssert(cueText, expectedTokens);
    }

    @Test
    void testGetTokens_CharacterReferenceInAnnotation() {
        String cueText = "<v Char&lt;reference>";
        List<CueTextToken> expectedTokens = List.of(new StartTagToken("v", List.of(), "Char<reference"));
        tokenizeAndAssert(cueText, expectedTokens);
    }

    @Test
    void testGetTokens_InvalidCharacterReference() {
        String cueText = "&doesNotExist;";
        List<CueTextToken> expectedTokens = List.of(new StringToken("&doesNotExist;"));
        tokenizeAndAssert(cueText, expectedTokens);
    }

    @Test
    void testGetTokens_CharacterReferenceMissingSemicolon() {
        String cueText = "&amp but there is no semicolon";
        List<CueTextToken> expectedTokens = List.of(new StringToken("&amp but there is no semicolon"));
        tokenizeAndAssert(cueText, expectedTokens);
    }

    @Test
    void testGetTokens_CharacterReferenceAtEndMissingSemicolon() {
        String cueText = "character reference - &amp";
        List<CueTextToken> expectedTokens = List.of(new StringToken("character reference - &amp"));
        tokenizeAndAssert(cueText, expectedTokens);
    }

    @Test
    void testGetTokens_CharacterReferenceFollowingInvalidReference() {
        String cueText = "&amp and then &para; is valid";
        List<CueTextToken> expectedTokens = List.of(new StringToken("&amp and then ¶ is valid"));
        tokenizeAndAssert(cueText, expectedTokens);
    }

    @Test
    void testGetTokens_tagFollowingInvalidCharacterReference() {
        String cueText = "&lt is invalid <c>In tag</c>";
        List<CueTextToken> expectedTokens = List.of(new StringToken("&lt is invalid "),
                new StartTagToken("c", List.of(), null), new StringToken("In tag"), new EndTagToken("c"));
        tokenizeAndAssert(cueText, expectedTokens);
    }

    @Test
    void testGetTokens_InvalidCharacterReferencePrecedingTag() {
        String cueText = "&gt<c>";
        List<CueTextToken> expectedTokens = List.of(new StringToken("&gt"), new StartTagToken("c", List.of(), null));
        tokenizeAndAssert(cueText, expectedTokens);
    }

    @Test
    void testGetTokens_VoiceSpanWithAnnotation() {
        String cueText = "<v Name>Hi</v>";
        List<CueTextToken> expectedTokens = List.of(new StartTagToken("v", List.of(), "Name"), new StringToken("Hi"),
                new EndTagToken("v"));
        tokenizeAndAssert(cueText, expectedTokens);
    }

    @Test
    void testGetTokens_AnnotationFollowingTab() {
        String cueText = "<v\tName>Hi</v>";
        List<CueTextToken> expectedTokens = List.of(new StartTagToken("v", List.of(), "Name"), new StringToken("Hi"),
                new EndTagToken("v"));
        tokenizeAndAssert(cueText, expectedTokens);
    }

    @Test
    void testGetTokens_AnnotationFollowedByWhitespace() {
        String cueText = "<v Name\t\f\f>Hi</v>";
        List<CueTextToken> expectedTokens = List.of(new StartTagToken("v", List.of(), "Name"), new StringToken("Hi"),
                new EndTagToken("v"));
        tokenizeAndAssert(cueText, expectedTokens);
    }

    @Test
    void testGetTokens_AnnotationFollowingNewLine() {
        String cueText = "<v\nName>Hi</v>";
        List<CueTextToken> expectedTokens = List.of(new StartTagToken("v", List.of(), "Name"), new StringToken("Hi"),
                new EndTagToken("v"));
        tokenizeAndAssert(cueText, expectedTokens);
    }

    @Test
    void testGetTokens_ClassAndAnnotation() {
        String cueText = "<v.loud\tName>Hi</v>";
        List<CueTextToken> expectedTokens = List.of(new StartTagToken("v", List.of("loud"), "Name"),
                new StringToken("Hi"), new EndTagToken("v"));
        tokenizeAndAssert(cueText, expectedTokens);
    }

    /***
     * Tests that multiple spaces in a tag annotation are condensed to a single
     * space.
     */
    @Test
    void testGetTokens_AnnotationContainingMultipleSpaces() {
        String cueText = "<v Your&#32;&#12;&#13;Name>Hi</v>";
        List<CueTextToken> expectedTokens = List.of(new StartTagToken("v", List.of(), "Your Name"),
                new StringToken("Hi"), new EndTagToken("v"));
        tokenizeAndAssert(cueText, expectedTokens);
    }

    @Test
    void testGetTokens_ItalicSpan() {
        String cueText = "<i>Suave</i>";
        List<CueTextToken> expectedTokens = List.of(new StartTagToken("i", List.of(), null), new StringToken("Suave"),
                new EndTagToken("i"));
        tokenizeAndAssert(cueText, expectedTokens);
    }

    @Test
    void testGetTokens_RubySpan() {
        String cueText = "<ruby>lower<rt>upper</rt></ruby>";
        List<CueTextToken> expectedTokens = List.of(new StartTagToken("ruby", List.of(), null),
                new StringToken("lower"), new StartTagToken("rt", List.of(), null), new StringToken("upper"),
                new EndTagToken("rt"), new EndTagToken("ruby"));
        tokenizeAndAssert(cueText, expectedTokens);
    }

    @Test
    void testGetTokens_Timestamp() {
        String cueText = "<00:00:01.234>";
        List<CueTextToken> expectedTokens = List.of(new TimestampTagToken("00:00:01.234"));
        tokenizeAndAssert(cueText, expectedTokens);
    }

    @Test
    void testGetTokens_EndTag() {
        String cueText = "</u>";
        List<CueTextToken> expectedTokens = List.of(new EndTagToken("u"));
        tokenizeAndAssert(cueText, expectedTokens);
    }

    @Test
    void testGetTokens_EmptyTag() {
        String cueText = "Some text here <> end of line";
        List<CueTextToken> expectedTokens = List.of(new StringToken("Some text here "),
                new StartTagToken("", List.of(), null), new StringToken(" end of line"));
        tokenizeAndAssert(cueText, expectedTokens);
    }

    /***
     * Tests that a cue text that reaches the end of file marker while in the tag
     * class state returns a start tag with the current set of classes.
     */
    @Test
    void testGetTokens_ClassName_EndOfFile() {
        String cueText = "<c.endoffile";
        List<CueTextToken> expectedTokens = List.of(new StartTagToken("c", List.of("endoffile"), null));
        tokenizeAndAssert(cueText, expectedTokens);
    }

    @Test
    void testGetTokens_Tag_EndOfFile() {
        String cueText = "the tag: <";
        List<CueTextToken> expectedTokens = List.of(new StringToken("the tag: "),
                new StartTagToken("", List.of(), null));
        tokenizeAndAssert(cueText, expectedTokens);
    }

    @Test
    void testGetTokens_TagName_EndOfFile() {
        String cueText = "the tag: <i";
        List<CueTextToken> expectedTokens = List.of(new StringToken("the tag: "),
                new StartTagToken("i", List.of(), null));
        tokenizeAndAssert(cueText, expectedTokens);
    }

    @Test
    void testGetTokens_Annotation_EndOfFile() {
        String cueText = "<v Speaker";
        List<CueTextToken> expectedTokens = List.of(new StartTagToken("v", List.of(), "Speaker"));
        tokenizeAndAssert(cueText, expectedTokens);
    }

    @Test
    void testGetTokens_Timestamp_EndOfFile() {
        String cueText = "Incomplete time tag - <00:0";
        List<CueTextToken> expectedTokens = List.of(new StringToken("Incomplete time tag - "),
                new TimestampTagToken("00:0"));
        tokenizeAndAssert(cueText, expectedTokens);
    }

    @Test
    void testGetTokens_EndTag_EndOfFile() {
        String cueText = "...The end</i";
        List<CueTextToken> expectedTokens = List.of(new StringToken("...The end"), new EndTagToken("i"));
        tokenizeAndAssert(cueText, expectedTokens);
    }

    private void tokenizeAndAssert(String cueText, List<CueTextToken> expectedTokens) {
        Tokenizer t = new Tokenizer(cueText);
        List<CueTextToken> tokens = convertToList(t.getTokens());

        Assertions.assertIterableEquals(expectedTokens, tokens);
    }

    private List<CueTextToken> convertToList(Iterator<CueTextToken> iterator) {
        ArrayList<CueTextToken> tokenList = new ArrayList<>();
        while (iterator.hasNext()) {
            tokenList.add(iterator.next());
        }
        return tokenList;
    }

}
