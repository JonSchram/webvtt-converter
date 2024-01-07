package com.jonathanschram.vttconverter.lib.vtt.parsing.cuetext;

import java.util.List;

public record StartTagToken(String tagName, List<String> classes, String annotation) implements CueTextToken {
}
