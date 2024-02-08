package com.jonathanschram.vttconverter.lib.vtt.css.properties.font;

import java.util.Objects;

public class GenericFontFamily implements FontFamily {
    private final GenericFamilyName name;

    public GenericFontFamily(GenericFamilyName name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GenericFontFamily other = (GenericFontFamily) obj;
        return name == other.name;
    }

    public GenericFamilyName getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "GenericFontFamily [name=" + name + "]";
    }

}
