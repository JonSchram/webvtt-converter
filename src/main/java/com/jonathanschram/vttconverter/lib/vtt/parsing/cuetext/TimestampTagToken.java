package com.jonathanschram.vttconverter.lib.vtt.parsing.cuetext;

/***
 * An implementation of CueTextToken for timestamp tags. While this is a type of
 * tag, it doesn't extend StartTagToken because:
 * <ul>
 * <li>It requires no end tag</li>
 * <li>It doesn't support any attributes</li>
 * </ul>
 */
public record TimestampTagToken(String time) implements CueTextToken {

}
