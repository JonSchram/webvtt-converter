package com.jonathanschram.vttconverter.lib.vtt.parsing.cuetext;

import java.util.Iterator;
import java.util.Stack;

import com.jonathanschram.vttconverter.lib.vtt.cue.TimeCode;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.BoldNode;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.ClassNode;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.InternalNode;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.ItalicsNode;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.LanguageNode;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.RootCueNode;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.RubyNode;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.RubyTextNode;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.TextNode;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.TimestampNode;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.UnderlineNode;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.VoiceNode;
import com.jonathanschram.vttconverter.lib.vtt.parsing.TimeCodeParser;

/***
 * Parser for cue text. This works a lot like HTML, but it only supports a
 * subset of HTML tags, and there is no explicit root tag around the entire
 * text.
 */
public class CueTextParser {
    private final Iterator<CueTextToken> tokens;

    private boolean hasParsed = false;
    private InternalNode.Builder<?, ?> currentParent;

    /***
     * Creates a {@link CueTextParser} that will parse cue text tokens from the
     * given iterator.
     * 
     * @param tokens Tokens defining the cue text.
     */
    public CueTextParser(Iterator<CueTextToken> tokens) {
        this.tokens = tokens;
    }

    /***
     * Parses the tokens into a {@link RootCueNode}.
     * 
     * @param fallbackLanguage
     * @return
     * @throws IllegalStateException if this method has previously been called on
     *                               this instance.
     */
    public RootCueNode parse() {
        return this.parse(null);
    }

    /***
     * Parses the tokens into a {@link RootCueNode}, using the specified fallback
     * language.
     * 
     * @param fallbackLanguage
     * @return
     * @throws IllegalStateException if this method has previously been called on
     *                               this instance.
     */
    public RootCueNode parse(String fallbackLanguage) {
        if (hasParsed) {
            throw new IllegalStateException("Already parsed tokens, cannot parse again.");
        }
        hasParsed = true;

        Stack<InternalNode.Builder<?, ?>> allParents = new Stack<>();
        RootCueNode.Builder rootBuilder = new RootCueNode.Builder();
        currentParent = rootBuilder;

        Stack<String> languages = new Stack<>();

        if (fallbackLanguage != null) {
            languages.push(fallbackLanguage);
            rootBuilder.setApplicableLanguage(fallbackLanguage);
        }

        while (tokens.hasNext()) {
            CueTextToken token = tokens.next();
            System.out.println(token);

            if (token instanceof StringToken) {
                currentParent.appendChild(processTextToken((StringToken) token));

            } else if (token instanceof StartTagToken) {
                StartTagToken startToken = (StartTagToken) token;
                InternalNode.Builder<?, ?> nodeBuilder = processStartTagToken(startToken, languages);
                if (nodeBuilder != null) {
                    // Save current parent so it can be retrieved when the end tag is found.
                    allParents.push(currentParent);
                    applyLanguageAndClasses(startToken, nodeBuilder, languages);
                    currentParent.appendChild(nodeBuilder);
                    currentParent = nodeBuilder;
                }

            } else if (token instanceof EndTagToken) {
                processEndTagToken((EndTagToken) token, allParents, languages);

            } else if (token instanceof TimestampTagToken) {
                TimestampNode.Builder timeNodeBuilder = processTimestampTagToken((TimestampTagToken) token);
                if (timeNodeBuilder != null) {
                    currentParent.appendChild(timeNodeBuilder);
                }
            }

        }

        return rootBuilder.build();
    }

    private TextNode.Builder processTextToken(StringToken token) {
        return new TextNode.Builder().setText(token.text());
    }

    private InternalNode.Builder<?, ?> processStartTagToken(StartTagToken token, Stack<String> languages) {
        switch (token.tagName()) {
        case "c":
            return new ClassNode.Builder();

        case "i":
            return new ItalicsNode.Builder();

        case "b":
            return new BoldNode.Builder();

        case "u":
            return new UnderlineNode.Builder();

        case "ruby":
            return new RubyNode.Builder();

        case "rt":
            if (currentParent instanceof RubyNode.Builder) {
                return new RubyTextNode.Builder();
            }
            return null;

        case "v":
            VoiceNode.Builder voiceBuilder = new VoiceNode.Builder();
            voiceBuilder.setVoiceName(token.annotation());
            return voiceBuilder;

        case "lang":
            LanguageNode.Builder result = new LanguageNode.Builder();
            String language = token.annotation() == null ? "" : token.annotation();
            languages.push(language);
            return result;
        }

        return null;
    }

    private void applyLanguageAndClasses(StartTagToken token, InternalNode.Builder<?, ?> builder,
            Stack<String> languages) {
        if (languages.size() > 0) {
            builder.setApplicableLanguage(languages.peek());
        }
        if (token.classes().size() > 0) {
            builder.setClasses(token.classes());
        }
    }

    private void processEndTagToken(EndTagToken token, Stack<InternalNode.Builder<?, ?>> allParents,
            Stack<String> languages) {
        if ("c".equals(token.tagName()) && currentParent instanceof ClassNode.Builder
                || "i".equals(token.tagName()) && currentParent instanceof ItalicsNode.Builder
                || "b".equals(token.tagName()) && currentParent instanceof BoldNode.Builder
                || "u".equals(token.tagName()) && currentParent instanceof UnderlineNode.Builder
                || "ruby".equals(token.tagName()) && currentParent instanceof RubyNode.Builder
                || "rt".equals(token.tagName()) && currentParent instanceof RubyTextNode.Builder
                || "v".equals(token.tagName()) && currentParent instanceof VoiceNode.Builder) {
            currentParent = allParents.pop();

        } else if ("lang".equals(token.tagName()) && currentParent instanceof LanguageNode.Builder) {
            currentParent = allParents.pop();
            languages.pop();

        } else if ("ruby".equals(token.tagName()) && currentParent instanceof RubyTextNode.Builder) {
            // The ending ruby text tag can be omitted.
            // Discard ruby node.
            allParents.pop();
            // Get parent of ruby node.
            currentParent = allParents.pop();
        }
    }

    private TimestampNode.Builder processTimestampTagToken(TimestampTagToken token) {
        TimeCodeParser timeParser = new TimeCodeParser(token.time());

        try {
            TimeCode parsedTime = timeParser.parseTimestamp();
            // Test that the entire tag contents were parsed into the time code.
            if (timeParser.getCurrentPosition() == token.time().length()) {
                return new TimestampNode.Builder().setTimeCode(parsedTime);
            } else {
                // Ignore invalid time code.
                return null;
            }
        } catch (Exception e) {
            // Ignore invalid token.
            return null;
        }

    }
}
