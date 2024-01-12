package com.jonathanschram.vttconverter.lib.vtt.parsing.cuetext;

import java.util.Map;
import java.util.Optional;
import com.jonathanschram.vttconverter.lib.vtt.VttObject;
import com.jonathanschram.vttconverter.lib.vtt.cue.Cue;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.RootCueNode;
import com.jonathanschram.vttconverter.lib.vtt.cue.properties.TextAlignment;
import com.jonathanschram.vttconverter.lib.vtt.cue.properties.WritingDirection;
import com.jonathanschram.vttconverter.lib.vtt.cue.properties.line.NumericLine;
import com.jonathanschram.vttconverter.lib.vtt.cue.properties.position.NumericPosition;
import com.jonathanschram.vttconverter.lib.vtt.cue.properties.position.PositionAlignment;
import com.jonathanschram.vttconverter.lib.vtt.cue.properties.line.LineAlignment;
import com.jonathanschram.vttconverter.lib.vtt.parsing.RawCue;
import com.jonathanschram.vttconverter.lib.vtt.parsing.Utils;

/***
 * An object to encapsulate the logic of converting a {@link RawCue} into a
 * ready-to-use {@link Cue} for a {@link VttObject}.
 */
public class CueFinalizer {

    public Cue processRawCue(RawCue rawCue) {
        Cue.Builder cueBuilder = new Cue.Builder();
        cueBuilder.setStart(rawCue.getStart());
        cueBuilder.setEnd(rawCue.getEnd());
        cueBuilder.setIdentifier(rawCue.getIdentifier());

        Tokenizer t = new Tokenizer(rawCue.getRawText());
        CueTextParser textParser = new CueTextParser(t.getTokens());
        RootCueNode rootNode = textParser.parse();
        cueBuilder.setPayload(rootNode);

        parseSettingsMap(cueBuilder, rawCue.getRawSettings());
        return cueBuilder.build();
    }

    private void parseSettingsMap(Cue.Builder builder, Map<String, String> rawSettings) {

        for (Map.Entry<String, String> entrySet : rawSettings.entrySet()) {
            String value = entrySet.getValue();
            switch (entrySet.getKey()) {
            case "region":
                builder.setRegionId(value);
                break;

            case "vertical":
                if ("rl".equals(value)) {
                    builder.setDirection(WritingDirection.VERTICAL_GROWINNG_LEFT);
                } else if ("lr".equals(value)) {
                    builder.setDirection(WritingDirection.VERTICAL_GROWING_RIGHT);
                }
                break;
            case "line":
                parseLineSettings(builder, value);
                break;
            case "position":
                parsePosition(builder, value);
                break;
            case "size":
                parseSize(builder, value);
                break;
            case "align":
                parseAlign(builder, value);
                break;
            }
        }
    }

    private void parseLineSettings(Cue.Builder builder, String lineValue) {
        String positionData;
        String alignmentData;

        if (lineValue.contains(",")) {
            String[] linePortions = lineValue.split(",", 2);
            positionData = linePortions[0];
            alignmentData = linePortions[1];
        } else {
            positionData = lineValue;
            alignmentData = null;
        }

        if (!Utils.containsAsciiDigits(positionData)) {
            return;
        }

        boolean snapToLines = false;
        Optional<Double> position;
        if (positionData.endsWith("%")) {
            snapToLines = false;
            position = Utils.parsePercentage(positionData);
        } else {
            snapToLines = true;
            position = parseLinePosition(positionData);
        }

        if (position.isEmpty()) {
            return;
        }

        if (alignmentData != null) {
            switch (alignmentData) {
            case "start":
                builder.setLineAlign(LineAlignment.START);
            case "center":
                builder.setLineAlign(LineAlignment.CENTER);
            case "end":
                builder.setLineAlign(LineAlignment.END);
            default:
                // An invalid alignment setting was provided.
                return;
            }
        }

        // Only set line settings after alignment was verified to be valid (if
        // provided).
        builder.setLine(new NumericLine(position.get()));
        builder.setSnapToLines(snapToLines);
        // Clear region if it has been set, because the line has been explicitly set.
        // Builder will enforce this in case the region setting appears after the line.
        builder.setRegionId(null);
    }

    private Optional<Double> parseLinePosition(String linePosition) {
        if (linePosition.lastIndexOf('-') > 0) {
            // There is a hyphen that isn't the first character. Invalid, skip.
            return Optional.empty();
        }

        int dotCount = 0;

        for (int i = 0; i < linePosition.length(); i++) {
            char currentChar = linePosition.charAt(i);
            if (!isValidDoubleCharacter(currentChar)) {
                return Optional.empty();
            }

            if (currentChar == '-' && i != 0) {
                // There is a hyphen at a position other than the beginning of the string.
                return Optional.empty();
            }

            if (currentChar == '.') {
                dotCount++;
                if (dotCount > 1) {
                    return Optional.empty();
                }
                if (i == 0 || i == linePosition.length() - 1) {
                    // Period cannot be the first or last character.
                    return Optional.empty();
                }
                if (!Utils.isAsciiDigit(linePosition.charAt(i - 1))
                        || !Utils.isAsciiDigit(linePosition.charAt(i + 1))) {
                    // Character before and after the period must be a digit.
                    return Optional.empty();
                }
            }
        }

        try {
            double value = Double.parseDouble(linePosition);
            return Optional.of(value);
        } catch (NumberFormatException e) {
            // String couldn't be parsed - ignore.
            return Optional.empty();
        }
    }

    private boolean isValidDoubleCharacter(char c) {
        return c == '.' || c == '-' || Utils.isAsciiDigit(c);
    }

    private void parsePosition(Cue.Builder builder, String position) {
        String columnPosition;
        String columnAlign;

        if (position.contains(",")) {
            String[] splitLine = position.split(",", 2);
            columnPosition = splitLine[0];
            columnAlign = splitLine[1];
        } else {
            columnPosition = position;
            columnAlign = null;
        }

        Optional<Double> columnPercent = Utils.parsePercentage(columnPosition);
        if (!columnPercent.isEmpty()) {
            // Invalid percentage value, skip setting.
            return;
        }

        if (columnAlign != null) {
            switch (columnAlign) {
            case "line-left":
                builder.setPositionAlign(PositionAlignment.LINE_LEFT);
            case "center":
                builder.setPositionAlign(PositionAlignment.CENTER);
            case "line-right":
                builder.setPositionAlign(PositionAlignment.LINE_RIGHT);
            default:
                // Invalid value was provided, skip setting.
                return;
            }
        }

        // Only set position after determining that column align was valid.
        builder.setPosition(new NumericPosition(columnPercent.get()));
    }

    private void parseSize(Cue.Builder builder, String size) {
        Optional<Double> sizePercent = Utils.parsePercentage(size);
        if (sizePercent.isEmpty()) {
            return;
        }

        builder.setSize(sizePercent.get());

        if (sizePercent.get() == 100) {
            // The spec requires the cue be taken out of the region because it was resized.
            // Comparing double values is bad but this was a parsed value, so there is
            // minimal room for error.
            builder.setRegionId(null);
        }
    }

    private void parseAlign(Cue.Builder builder, String align) {
        switch (align) {
        case "start":
            builder.setTextAlign(TextAlignment.START);
            break;
        case "center":
            builder.setTextAlign(TextAlignment.CENTER);
            break;
        case "end":
            builder.setTextAlign(TextAlignment.END);
            break;
        case "left":
            builder.setTextAlign(TextAlignment.LEFT);
            break;
        case "right":
            builder.setTextAlign(TextAlignment.RIGHT);
            break;
        }
    }
}
