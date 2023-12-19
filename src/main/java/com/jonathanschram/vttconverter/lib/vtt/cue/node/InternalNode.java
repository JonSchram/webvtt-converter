package com.jonathanschram.vttconverter.lib.vtt.cue.node;

import java.util.List;

public abstract class InternalNode extends VttNode {
	protected List<VttNode> children;
	protected List<String> classes;
	protected String applicableLanguage;

}
