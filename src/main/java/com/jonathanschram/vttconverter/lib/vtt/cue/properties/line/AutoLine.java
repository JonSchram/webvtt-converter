package com.jonathanschram.vttconverter.lib.vtt.cue.properties.line;

/***
 * Implementation of LineProperties with no methods, it only signals that the
 * cue box is positioned automatically.
 */
public class AutoLine implements LineSetting {

    @Override
    public boolean equals(Object obj) {
        // This class has no properties, so we consider all AutoLines to be equal.
        return obj instanceof AutoLine;
    }
}
