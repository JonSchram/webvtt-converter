package com.jonathanschram.vttconverter.lib.vtt.cue.node;

public class VoiceNode extends InternalNode {
    public static class Builder extends InternalNode.Builder {
        private String voiceName;

        public Builder setVoiceName(String voiceName) {
            this.voiceName = voiceName;
            return this;
        }

        @Override
        public VoiceNode build() {
            return new VoiceNode(this);
        }
    }

    private String voiceName;

    public VoiceNode(Builder builder) {
        super(builder);
        this.voiceName = builder.voiceName;
    }

    public String getVoiceName() {
        return voiceName;
    }
}
