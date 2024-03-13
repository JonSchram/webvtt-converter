package com.jonathanschram.vttconverter.lib.vtt.css.properties.decoration;

import java.util.Objects;
import java.util.Set;

import com.jonathanschram.vttconverter.lib.vtt.css.CssValue;
import com.jonathanschram.vttconverter.lib.vtt.css.RenderParameters;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadeValueReference;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.Font;
import com.jonathanschram.vttconverter.lib.vtt.css.types.Color;

public class LineTypeSet implements CssValue<LineTypeSet> {

    private final Set<LineType> values;

    public LineTypeSet() {
        values = Set.of();
    }

    public LineTypeSet(LineType value) {
        values = Set.of(value);
    }

    public LineTypeSet(Set<LineType> values) {
        this.values = Set.copyOf(values);
    }

    @Override
    public LineTypeSet computeValue(CascadeValueReference<Color> colorReference, CascadeValueReference<Font> fontReference, RenderParameters parameters) {
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LineTypeSet other = (LineTypeSet) obj;
        return Objects.equals(values, other.values);
    }

    public Set<LineType> getValues() {
        return values;
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

    @Override
    public boolean isComputedValue() {
        return true;
    }

    @Override
    public String toString() {
        return "LineTypeSet [values=" + values + "]";
    }

}
