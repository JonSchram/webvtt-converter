package com.jonathanschram.vttconverter.lib.vtt.cue.properties.line;

/***
 * An implementation of {@link LineSetting} that specifies a line number on
 * screen.
 */
public record NumericLine(double lineNumber) implements LineSetting {}
