package com.jonathanschram.vttconverter.lib.vtt.layout;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.jonathanschram.vttconverter.lib.vtt.cue.node.BoldNode;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.TextNode;
import com.jonathanschram.vttconverter.lib.vtt.cue.node.VttNode;

class NodeFlattenerTest {

    @Test
    void test() {
        TextNode.Builder child = new TextNode.Builder().setText("this is bold");
        VttNode node = new BoldNode.Builder().appendChild(child).build();
        
        NodeFlattener flattener = new NodeFlattener();
        node.accept(flattener);
    }

}
