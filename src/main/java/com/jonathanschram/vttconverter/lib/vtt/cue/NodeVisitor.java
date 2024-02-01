package com.jonathanschram.vttconverter.lib.vtt.cue;

import com.jonathanschram.vttconverter.lib.vtt.cue.node.BoldNode;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.ClassNode;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.ItalicsNode;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.LanguageNode;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.RubyNode;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.RubyTextNode;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.TextNode;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.TimestampNode;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.UnderlineNode;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.VoiceNode;

public interface NodeVisitor {
    void visitBoldNode(BoldNode node);

    void visitClassNode(ClassNode node);

    void visitItalicsNode(ItalicsNode node);

    void visitLanguageNode(LanguageNode node);

    void visitRubyNode(RubyNode node);

    void visitRubyTextNode(RubyTextNode node);

    void visitTextNode(TextNode node);

    void visitTimestampNode(TimestampNode node);

    void visitUnderlineNode(UnderlineNode node);

    void visitVoiceNode(VoiceNode node);
}
