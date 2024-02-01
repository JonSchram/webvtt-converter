package com.jonathanschram.vttconverter.lib.vtt.layout;

import com.jonathanschram.vttconverter.lib.vtt.cue.NodeVisitor;
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

public class NodeFlattener implements NodeVisitor {

    public NodeFlattener() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void visitBoldNode(BoldNode node) {
        // TODO Auto-generated method stub
        System.out.println("Visiting bold node");
    }

    @Override
    public void visitClassNode(ClassNode node) {
        // TODO Auto-generated method stub
        System.out.println("Visiting class node");
    }

    @Override
    public void visitItalicsNode(ItalicsNode node) {
        System.out.println("Visiting italics node");
    }

    @Override
    public void visitLanguageNode(LanguageNode node) {
        System.out.println("Visiting language node");
    }

    @Override
    public void visitRubyNode(RubyNode node) {
        System.out.println("Visiting ruby node");
    }

    @Override
    public void visitRubyTextNode(RubyTextNode node) {
        System.out.println("Visiting ruby text node");
    }

    @Override
    public void visitTextNode(TextNode node) {
        System.out.println("Visiting text node");
    }

    @Override
    public void visitTimestampNode(TimestampNode node) {
        // TODO Apply styles based on current time.
        System.out.println("Visiting timestamp node");
    }

    @Override
    public void visitUnderlineNode(UnderlineNode node) {
        System.out.println("Visiting underline node");
    }

    @Override
    public void visitVoiceNode(VoiceNode node) {
        System.out.println("Visiting voice node");
    }

}
