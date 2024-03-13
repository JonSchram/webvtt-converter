package com.jonathanschram.vttconverter.lib.vtt.css.types.length;

import java.util.Objects;

import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadeValueReference;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.PropertyName;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.Font;
import com.jonathanschram.vttconverter.lib.vtt.css.types.Percentage;

/***
 * An implementation of {@link Length} that specifies distance by percent of
 * another element's size.
 */
public class PercentageLength implements Length {
    private final Percentage percent;

    public PercentageLength(Percentage percent) {
        this.percent = percent;
    }

    public Percentage getPercent() {
        return percent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(percent);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PercentageLength other = (PercentageLength) obj;
        return Objects.equals(percent, other.percent);
    }

    @Override
    public String toString() {
        return "PercentageLength [percent=" + percent + "]";
    }

    @Override
    public boolean isAbsoluteLength() {
        // A length as a percentage of some other element is by definition not absolute.
        return false;
    }

    @Override
    public Length multiply(double scalar) {
        return new PercentageLength(percent.multiply(scalar));
    }

    @Override
    public Length convertToAbsoluteLength(CascadeValueReference<Font> fontReference, PropertyName currentProperty) {
        // TODO Auto-generated method stub
        return null;
    }

}
