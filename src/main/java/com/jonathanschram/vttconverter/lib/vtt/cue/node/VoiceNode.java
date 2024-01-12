package com.jonathanschram.vttconverter.lib.vtt.cue.node;

import java.util.Objects;

public class VoiceNode extends InternalNode {
    public static class Builder extends InternalNode.Builder {
        private String voiceName;

        @Override
        public VoiceNode build() {
            return new VoiceNode(this);
        }

        public Builder setVoiceName(String voiceName) {
            this.voiceName = voiceName;
            return this;
        }
    }

    private String voiceName;

    public VoiceNode(Builder builder) {
        super(builder);
        this.voiceName = builder.voiceName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        VoiceNode other = (VoiceNode) obj;
        return Objects.equals(voiceName, other.voiceName);
    }

    public String getVoiceName() {
        return voiceName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(voiceName);
        return result;
    }
}
