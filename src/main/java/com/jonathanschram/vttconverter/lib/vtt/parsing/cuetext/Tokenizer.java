package com.jonathanschram.vttconverter.lib.vtt.parsing.cuetext;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.text.StringEscapeUtils;

import com.jonathanschram.vttconverter.lib.vtt.parsing.Utils;

/***
 * Returns an object that can produce a list of cue text tokens in the input
 * string.
 */
public class Tokenizer {
    private String input;

    public Tokenizer(String input) {
        this.input = input;
    }

    public Iterator<CueTextToken> getTokens() {
        return new CueTextIterator(input);
    }

    /***
     * A state machine for tokenizing cue text. This is based on the algorithm in
     * the <a href="https://www.w3.org/TR/webvtt1/">WebVTT specification</a>.
     */
    private static class CueTextIterator implements Iterator<CueTextToken> {
        private String input;

        private State currentState = State.DATA;

        private int currentPosition = 0;

        private StringBuilder dataOrTagName = new StringBuilder();
        private StringBuilder classOrAnnotation = new StringBuilder();
        private List<String> currentClasses = new ArrayList<>();

        CueTextToken currentToken = null;

        public CueTextIterator(String input) {
            this.input = input;
        }

        @Override
        public boolean hasNext() {
            return currentPosition < input.length();
        }

        @Override
        public CueTextToken next() {
            currentToken = null;
            currentState = State.DATA;

            boolean isEndOfInput = false;

            while (currentToken == null && !isEndOfInput) {
                char currentChar = (char) 0;
                if (currentPosition >= input.length()) {
                    isEndOfInput = true;
                } else {
                    currentChar = input.charAt(currentPosition);
                }

                switch (currentState) {
                case DATA:
                    tokenizeData(currentChar, isEndOfInput);
                    break;

                case CHARACTER_REFERENCE_IN_DATA:
                    tokenizeCharacterReferenceInData();
                    break;

                case TAG:
                    tokenizeTag(currentChar, isEndOfInput);
                    break;

                case START_TAG:
                    tokenizeStartTag(currentChar, isEndOfInput);
                    break;

                case START_TAG_CLASS:
                    tokenizeStartTagClass(currentChar, isEndOfInput);
                    break;

                case START_TAG_ANNOTATION:
                    tokenizeStartTagAnnotation(currentChar, isEndOfInput);
                    break;

                case CHARACTER_REFERENCE_IN_ANNOTATION:
                    tokenizeCharacterReferenceInAnnotation();
                    break;

                case END_TAG:
                    tokenizeEndTag(currentChar, isEndOfInput);
                    break;

                case TIMESTAMP_TAG:
                    tokenizeTimestamp(currentChar, isEndOfInput);
                    break;
                }

            }
            return currentToken;
        }

        private void tokenizeData(char currentChar, boolean isEndOfInput) {
            if (isEndOfInput) {
                currentToken = new StringToken(dataOrTagName.toString());

                // Clear text builder for next token.
                dataOrTagName.setLength(0);
                return;
            }

            switch (currentChar) {
            case '&':
                currentState = State.CHARACTER_REFERENCE_IN_DATA;
                currentPosition++;
                return;
            case '<':
                if (dataOrTagName.isEmpty()) {
                    currentState = State.TAG;
                    currentPosition++;
                    return;
                } else {
                    // Must return current plain text before starting a tag.
                    currentToken = new StringToken(dataOrTagName.toString());
                    dataOrTagName.setLength(0);
                    // Do not advance to the next position so that this character can be consumed
                    // again.
                    return;
                }

            default:
                dataOrTagName.append(currentChar);
                currentPosition++;
            }
        }

        private void tokenizeCharacterReferenceInData() {
            dataOrTagName.append(consumeCharacterReference());
            currentState = State.DATA;
        }

        private void tokenizeTag(char currentChar, boolean isEndOfInput) {
            if (isEndOfInput) {
                currentToken = new StartTagToken("", List.of(), null);
                return;
            }

            if ('0' <= currentChar && currentChar <= '9') {
                currentState = State.TIMESTAMP_TAG;
                dataOrTagName.append(currentChar);
                currentPosition++;
                return;
            }

            switch (currentChar) {
            case '\t':
            case '\n':
            case '\f':
            case ' ':
                // Handle tab, line feed, form feed, and space the same way.
                currentState = State.START_TAG;
                currentPosition++;
                return;

            case '.':
                currentState = State.START_TAG_CLASS;
                currentPosition++;
                return;

            case '/':
                currentState = State.END_TAG;
                currentPosition++;
                return;

            case '>':
                // This is an empty tag with no tag name and the tag is invalid.
                currentPosition++;
                currentToken = new StartTagToken("", List.of(), null);
                return;

            default:
                currentState = State.START_TAG;
                dataOrTagName.append(currentChar);
                currentPosition++;
            }
        }

        private void tokenizeStartTag(char currentChar, boolean isEndOfInput) {
            if (isEndOfInput) {
                currentToken = new StartTagToken(dataOrTagName.toString(), List.of(), null);
                // Clear current text for next usage.
                dataOrTagName.setLength(0);
                return;
            }

            switch (currentChar) {
            case '\t':
            case '\f':
            case ' ':
                // Handle tab, form feed, and space the same way.
                currentState = State.START_TAG_ANNOTATION;
                currentPosition++;
                return;

            case '\n':
                currentState = State.START_TAG_ANNOTATION;
                // TODO: Seems that leading whitespace will be removed from buffer, so maybe
                // this isn't even needed.
                // The fact that \n is handled on its own when we have other whitespace handled
                // almost identically makes me suspicious.
                classOrAnnotation.append('\n');
                currentPosition++;
                return;

            case '.':
                currentState = State.START_TAG_CLASS;
                currentPosition++;
                return;

            case '>':
                currentPosition++;
                currentToken = new StartTagToken(dataOrTagName.toString(), List.of(), null);
                // Clear current text for next usage.
                dataOrTagName.setLength(0);
                return;

            default:
                dataOrTagName.append(currentChar);
                currentPosition++;
            }
        }

        private void tokenizeStartTagClass(char currentChar, boolean isEndOfInput) {
            if (isEndOfInput) {
                currentClasses.add(classOrAnnotation.toString());
                currentToken = new StartTagToken(dataOrTagName.toString(), currentClasses, null);
                classOrAnnotation.setLength(0);
                dataOrTagName.setLength(0);
                currentClasses = new ArrayList<>();
                return;
            }

            switch (currentChar) {
            case '\t':
            case '\f':
            case ' ':
                // Handle tab, form feed, and space the same way.
                currentClasses.add(classOrAnnotation.toString());
                classOrAnnotation.setLength(0);
                currentState = State.START_TAG_ANNOTATION;
                currentPosition++;
                return;

            case '\n':
                currentClasses.add(classOrAnnotation.toString());
                classOrAnnotation.setLength(0);
                classOrAnnotation.append('\n');
                currentState = State.START_TAG_ANNOTATION;
                currentPosition++;
                return;

            case '.':
                currentClasses.add(classOrAnnotation.toString());
                classOrAnnotation.setLength(0);
                currentPosition++;
                return;

            case '>':
                currentPosition++;
                currentClasses.add(classOrAnnotation.toString());
                currentToken = new StartTagToken(dataOrTagName.toString(), currentClasses, null);
                classOrAnnotation.setLength(0);
                dataOrTagName.setLength(0);
                currentClasses = new ArrayList<>();
                return;

            default:
                classOrAnnotation.append(currentChar);
                currentPosition++;
            }
        }

        private void tokenizeStartTagAnnotation(char currentChar, boolean isEndOfInput) {
            if (isEndOfInput) {
                String annotation = Utils.stripWhitespace(classOrAnnotation.toString());
                annotation = Utils.condenseConsecutiveWhitespace(annotation);
                currentToken = new StartTagToken(dataOrTagName.toString(), currentClasses, annotation);
                classOrAnnotation.setLength(0);
                dataOrTagName.setLength(0);
                currentClasses = new ArrayList<>();
                return;
            }

            switch (currentChar) {
            case '&':
                // character reference.
                currentState = State.CHARACTER_REFERENCE_IN_ANNOTATION;
                currentPosition++;
                return;

            case '>':
                currentPosition++;
                String annotation = Utils.stripWhitespace(classOrAnnotation.toString());
                annotation = Utils.condenseConsecutiveWhitespace(annotation);
                currentToken = new StartTagToken(dataOrTagName.toString(), currentClasses, annotation);
                classOrAnnotation.setLength(0);
                dataOrTagName.setLength(0);
                currentClasses = new ArrayList<>();
                return;

            default:
                classOrAnnotation.append(currentChar);
                currentPosition++;
            }
        }

        private void tokenizeCharacterReferenceInAnnotation() {
            classOrAnnotation.append(consumeCharacterReference());
            currentState = State.START_TAG_ANNOTATION;
            // Current position is already set to the character after the character
            // reference.
        }

        private void tokenizeEndTag(char currentChar, boolean isEndOfInput) {
            if (isEndOfInput) {
                currentToken = new EndTagToken(dataOrTagName.toString());
                dataOrTagName.setLength(0);
                return;
            }

            if (currentChar == '>') {
                currentPosition++;
                currentToken = new EndTagToken(dataOrTagName.toString());
                dataOrTagName.setLength(0);
            } else {
                dataOrTagName.append(currentChar);
                currentPosition++;
            }
        }

        private void tokenizeTimestamp(char currentChar, boolean isEndOfInput) {
            if (isEndOfInput) {
                currentToken = new TimestampTagToken(dataOrTagName.toString());
                return;
            }

            if (currentChar == '>') {
                currentPosition++;
                // Don't parse timestamp yet, that will be done after tokenizing.
                currentToken = new TimestampTagToken(dataOrTagName.toString());
            } else {
                dataOrTagName.append(currentChar);
                currentPosition++;
            }
        }

        private String consumeCharacterReference() {
            StringBuilder referenceBuilder = new StringBuilder("&");
            int searchPosition = currentPosition;
            // String scan starts after the leading ampersand, so pre-populate with it.
            char previousChar = '&';
            while (searchPosition < input.length() && previousChar != ';'
                    && isCharacterReferenceCharacter(input.charAt(searchPosition))) {
                char currentChar = input.charAt(searchPosition);
                referenceBuilder.append(currentChar);
                previousChar = currentChar;
                searchPosition++;
            }

            currentPosition = searchPosition;
            return StringEscapeUtils.unescapeHtml4(referenceBuilder.toString());
        }

        /***
         * Returns whether this character is valid as a portion of a character
         * reference, either as a named reference or numeric.
         * 
         * This includes the leading ampersand and trailing semicolon.
         * 
         * @param c
         * @return
         */
        private boolean isCharacterReferenceCharacter(char c) {
            return c == '#' || c == '&' || c == ';' || ('0' <= c && c <= '9') || ('a' <= c && c <= 'z')
                    || ('A' <= c && c <= 'Z');
        }

        private enum State {
            DATA, CHARACTER_REFERENCE_IN_DATA, TAG, START_TAG, START_TAG_CLASS, START_TAG_ANNOTATION,
            CHARACTER_REFERENCE_IN_ANNOTATION, END_TAG, TIMESTAMP_TAG
        }

    }
}
