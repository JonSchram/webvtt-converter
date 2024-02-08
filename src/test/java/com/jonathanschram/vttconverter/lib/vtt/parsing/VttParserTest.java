package com.jonathanschram.vttconverter.lib.vtt.parsing;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.jonathanschram.vttconverter.lib.vtt.VttObject;
import com.jonathanschram.vttconverter.lib.vtt.css.RawCssBlock;
import com.jonathanschram.vttconverter.lib.vtt.cue.Cue;
import com.jonathanschram.vttconverter.lib.vtt.cue.TimeCode;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.RootCueNode;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.TextNode;
import com.jonathanschram.vttconverter.lib.vtt.cue.properties.WritingDirection;
import com.jonathanschram.vttconverter.lib.vtt.cue.properties.line.NumericLine;
import com.jonathanschram.vttconverter.lib.vtt.region.Location;
import com.jonathanschram.vttconverter.lib.vtt.region.Region;

class VttParserTest {

    @Test
    void testParse_HeaderAndCue() throws IOException, IncorrectFormatException {
        InputStream input = buildInputStream("WEBVTT\n\n"
                + "00:00:01.000 --> 00:00:02.000\n"
                + "Cue text");

        VttParser parser = new VttParser(input);

        VttObject result = parser.parse();

        assertTrue(result.getCssBlocks().isEmpty());
        assertTrue(result.getRegions().isEmpty());

        List<Cue> cues = result.getCues();

        assertEquals(1, cues.size());
        Cue cue = cues.get(0);

        RootCueNode.Builder rootBuilder = new RootCueNode.Builder()
                .appendChild(new TextNode.Builder().setText("Cue text"));
        Cue expectedCue = new Cue.Builder()
                .setStart(new TimeCode(0, 0, 1, 0))
                .setEnd(new TimeCode(0, 0, 2, 0))
                .setPayload(new RootCueNode(rootBuilder))
                .build();
        assertEquals(expectedCue, cue);
    }

    @Test
    void testParse_HeaderWithBOM() throws IOException, IncorrectFormatException {
        InputStream input = buildInputStream("\uFEFFWEBVTT\n\n"
                + "00:00:01.000 --> 00:00:02.000\n"
                + "Cue text");

        VttParser parser = new VttParser(input);

        VttObject result = parser.parse();

        assertTrue(result.getCssBlocks().isEmpty());
        assertTrue(result.getRegions().isEmpty());

        List<Cue> cues = result.getCues();

        assertEquals(1, cues.size());
        Cue cue = cues.get(0);

        RootCueNode.Builder rootBuilder = new RootCueNode.Builder()
                .appendChild(new TextNode.Builder().setText("Cue text"));
        Cue expectedCue = new Cue.Builder()
                .setStart(new TimeCode(0, 0, 1, 0))
                .setEnd(new TimeCode(0, 0, 2, 0))
                .setPayload(new RootCueNode(rootBuilder))
                .build();
        assertEquals(expectedCue, cue);
    }

    @Test
    void testParse_HeaderWithTextSuffix() throws IOException, IncorrectFormatException {
        InputStream input = buildInputStream("WEBVTT\tThis header is ignored.\n\n"
                + "00:00:01.000 --> 00:00:02.000\n"
                + "Cue text");

        VttParser parser = new VttParser(input);

        VttObject result = parser.parse();

        assertTrue(result.getCssBlocks().isEmpty());
        assertTrue(result.getRegions().isEmpty());

        List<Cue> cues = result.getCues();

        assertEquals(1, cues.size());
        Cue cue = cues.get(0);

        RootCueNode.Builder rootBuilder = new RootCueNode.Builder()
                .appendChild(new TextNode.Builder().setText("Cue text"));
        Cue expectedCue = new Cue.Builder()
                .setStart(new TimeCode(0, 0, 1, 0))
                .setEnd(new TimeCode(0, 0, 2, 0))
                .setPayload(new RootCueNode(rootBuilder))
                .build();
        assertEquals(expectedCue, cue);
    }

    @Test
    void testParse_CueWithIdentifier() throws IOException, IncorrectFormatException {
        InputStream input = buildInputStream("WEBVTT\n\n"
                + "Cue name\n"
                + "00:01:00.000 --> 00:01:10.000\n"
                + "Words");

        VttParser parser = new VttParser(input);

        VttObject result = parser.parse();

        assertTrue(result.getCssBlocks().isEmpty());
        assertTrue(result.getRegions().isEmpty());

        List<Cue> cues = result.getCues();

        assertEquals(1, cues.size());
        Cue cue = cues.get(0);

        RootCueNode.Builder rootBuilder = new RootCueNode.Builder()
                .appendChild(new TextNode.Builder().setText("Words"));
        Cue expectedCue = new Cue.Builder()
                .setIdentifier("Cue name")
                .setStart(new TimeCode(0, 1, 0, 0))
                .setEnd(new TimeCode(0, 1, 10, 0))
                .setPayload(new RootCueNode(rootBuilder))
                .build();
        assertEquals(expectedCue, cue);
    }

    @Test
    void testParse_CueWithLineSettings() throws IOException, IncorrectFormatException {
        InputStream input = buildInputStream("WEBVTT\n\n"
                + "00:01:00.000 --> 00:01:10.000 vertical:rl line:95% size:60%\n"
                + "Words");

        VttParser parser = new VttParser(input);

        VttObject result = parser.parse();

        assertTrue(result.getCssBlocks().isEmpty());
        assertTrue(result.getRegions().isEmpty());

        List<Cue> cues = result.getCues();

        assertEquals(1, cues.size());
        Cue cue = cues.get(0);

        RootCueNode.Builder rootBuilder = new RootCueNode.Builder()
                .appendChild(new TextNode.Builder().setText("Words"));
        Cue expectedCue = new Cue.Builder()
                .setStart(new TimeCode(0, 1, 0, 0))
                .setEnd(new TimeCode(0, 1, 10, 0))
                .setPayload(new RootCueNode(rootBuilder))
                .setDirection(WritingDirection.VERTICAL_GROWINNG_LEFT)
                .setLine(new NumericLine(95))
                .setSnapToLines(false)
                .setSize(60)
                .build();
        assertEquals(expectedCue, cue);
    }

    @Test
    void testParse_MultipleCues() throws IOException, IncorrectFormatException {
        InputStream input = buildInputStream("WEBVTT\n\n"
                + "00:01:00.000 --> 00:01:10.000\n"
                + "Hello, world!\n\n"
                + "01:05.000 --> 01:08.000\n"
                + "Hello, test!");

        VttParser parser = new VttParser(input);

        VttObject result = parser.parse();

        assertTrue(result.getCssBlocks().isEmpty());
        assertTrue(result.getRegions().isEmpty());

        List<Cue> cues = result.getCues();

        assertEquals(2, cues.size());

        Cue firstCue = cues.get(0);
        RootCueNode.Builder rootBuilder = new RootCueNode.Builder()
                .appendChild(new TextNode.Builder().setText("Hello, world!"));
        Cue expectedFirstCue = new Cue.Builder()
                .setStart(new TimeCode(0, 1, 0, 0))
                .setEnd(new TimeCode(0, 1, 10, 0))
                .setPayload(new RootCueNode(rootBuilder))
                .build();
        assertEquals(expectedFirstCue, firstCue);

        Cue secondCue = cues.get(1);
        RootCueNode.Builder secondRootBuilder = new RootCueNode.Builder()
                .appendChild(new TextNode.Builder().setText("Hello, test!"));
        Cue expectedSecondCue = new Cue.Builder()
                .setStart(new TimeCode(0, 1, 5, 0))
                .setEnd(new TimeCode(0, 1, 8, 0))
                .setPayload(new RootCueNode(secondRootBuilder))
                .build();
        assertEquals(expectedSecondCue, secondCue);
    }

    @Test
    void testParse_WithEmptyRegion() throws IOException, IncorrectFormatException {
        InputStream input = buildInputStream("WEBVTT\n\n"
                + "REGION\n\n"
                + "00:00:01.000 --> 00:00:02.000\n"
                + "Cue text");

        VttParser parser = new VttParser(input);

        VttObject result = parser.parse();

        assertTrue(result.getCssBlocks().isEmpty());
        assertTrue(result.getRegions().isEmpty());

        List<Cue> cues = result.getCues();

        assertEquals(1, cues.size());
        Cue cue = cues.get(0);

        RootCueNode.Builder rootBuilder = new RootCueNode.Builder()
                .appendChild(new TextNode.Builder().setText("Cue text"));
        Cue expectedCue = new Cue.Builder()
                .setStart(new TimeCode(0, 0, 1, 0))
                .setEnd(new TimeCode(0, 0, 2, 0))
                .setPayload(new RootCueNode(rootBuilder))
                .build();
        assertEquals(expectedCue, cue);
    }

    @Test
    void testParse_WithRegion() throws IOException, IncorrectFormatException {
        InputStream input = buildInputStream("WEBVTT\n\n"
                + "REGION\n"
                + "id:region_id\n"
                + "width:50% regionanchor:50%,70%\tviewportanchor:80%,20%\n\n"
                + "00:00:01.000 --> 00:00:02.000\n"
                + "Cue text");

        VttParser parser = new VttParser(input);

        VttObject result = parser.parse();

        assertTrue(result.getCssBlocks().isEmpty());
        assertEquals(1, result.getRegions().size());

        Region expectedRegion = new Region.Builder()
                .setIdentifier("region_id")
                .setWidthPercent(50)
                .setRegionAnchor(new Location(50, 70))
                .setViewportAnchor(new Location(80, 20)).build();
        assertEquals(expectedRegion, result.getRegions().get("region_id"));

        List<Cue> cues = result.getCues();

        assertEquals(1, cues.size());
        Cue cue = cues.get(0);

        RootCueNode.Builder rootBuilder = new RootCueNode.Builder()
                .appendChild(new TextNode.Builder().setText("Cue text"));
        Cue expectedCue = new Cue.Builder()
                .setStart(new TimeCode(0, 0, 1, 0))
                .setEnd(new TimeCode(0, 0, 2, 0))
                .setPayload(new RootCueNode(rootBuilder))
                .build();
        assertEquals(expectedCue, cue);
    }

    @Test
    void testParse_SkipsComment() throws IOException, IncorrectFormatException {
        InputStream input = buildInputStream("WEBVTT\n\n"
                + "NOTE This text is skipped\n"
                + "This as well\n\n"
                + "00:00:01.000 --> 00:00:02.000\n"
                + "Cue text");

        VttParser parser = new VttParser(input);

        VttObject result = parser.parse();

        assertTrue(result.getCssBlocks().isEmpty());
        assertTrue(result.getRegions().isEmpty());

        List<Cue> cues = result.getCues();

        assertEquals(1, cues.size());
        Cue cue = cues.get(0);

        RootCueNode.Builder rootBuilder = new RootCueNode.Builder()
                .appendChild(new TextNode.Builder().setText("Cue text"));
        Cue expectedCue = new Cue.Builder()
                .setStart(new TimeCode(0, 0, 1, 0))
                .setEnd(new TimeCode(0, 0, 2, 0))
                .setPayload(new RootCueNode(rootBuilder))
                .build();
        assertEquals(expectedCue, cue);
    }

    @Test
    void testParse_WithStyle() throws IOException, IncorrectFormatException {
        InputStream input = buildInputStream("WEBVTT\n\n"
                + "STYLE\n"
                + "::cue {\n"
                + "color:red\n"
                + "}\n\n"
                + "00:00:01.000 --> 00:00:02.000\n"
                + "Cue text");

        VttParser parser = new VttParser(input);
        VttObject result = parser.parse();

        List<RawCssBlock> expectedCss = List.of(new RawCssBlock("::cue {\ncolor:red\n}"));
        assertIterableEquals(expectedCss, result.getCssBlocks());

        assertTrue(result.getRegions().isEmpty());

        List<Cue> cues = result.getCues();

        assertEquals(1, cues.size());
        Cue cue = cues.get(0);

        RootCueNode.Builder rootBuilder = new RootCueNode.Builder()
                .appendChild(new TextNode.Builder().setText("Cue text"));
        Cue expectedCue = new Cue.Builder()
                .setStart(new TimeCode(0, 0, 1, 0))
                .setEnd(new TimeCode(0, 0, 2, 0))
                .setPayload(new RootCueNode(rootBuilder))
                .build();
        assertEquals(expectedCue, cue);
    }

    @Test
    void testParse_EmptyFile_Throws() {
        InputStream input = buildInputStream("");

        VttParser parser = new VttParser(input);

        assertThrows(IncorrectFormatException.class, () -> parser.parse());
    }

    @Test
    void testParse_IncorrectHeader_Throws() {
        InputStream input = buildInputStream("NOT THE HEADER");

        VttParser parser = new VttParser(input);

        assertThrows(IncorrectFormatException.class, () -> parser.parse());
    }

    @Test
    void testParse_TooShortFile_Throws() {
        InputStream input = buildInputStream("short");

        VttParser parser = new VttParser(input);

        assertThrows(IncorrectFormatException.class, () -> parser.parse());
    }

    private InputStream buildInputStream(String vttContents) {
        return new ByteArrayInputStream(vttContents.getBytes());
    }
}
