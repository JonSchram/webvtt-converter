package com.jonathanschram.vttconverter.lib.vtt.cue.node;

/***
 * A collection of the ruby base text and the text that appears above it.
 * 
 * This allows each base text to be unambiguously paired with ruby text in the
 * same ruby tag, even if it doesn't follow the ideal node structure of a ruby
 * node.
 */
public class RubySegment {
	private RubyBaseNode baseText;
	private RubyTextNode rubyText;
}
