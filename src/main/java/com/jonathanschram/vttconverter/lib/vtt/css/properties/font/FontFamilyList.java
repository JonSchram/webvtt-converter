package com.jonathanschram.vttconverter.lib.vtt.css.properties.font;

import java.util.List;
import java.util.Objects;

import com.jonathanschram.vttconverter.lib.vtt.css.CssProperty;
import com.jonathanschram.vttconverter.lib.vtt.css.CssValue;

/***
 * A wrapper class for a list of font families. Allows creating a list that
 * implements {@link CssValue} that can be stored in a {@link CssProperty}.
 */
public class FontFamilyList implements CssValue<FontFamilyList> {

    private final List<FontFamily> values;

    public FontFamilyList() {
        values = List.of();
    }

    public FontFamilyList(FontFamily value) {
        values = List.of(value);
    }

    public FontFamilyList(List<FontFamily> values) {
        this.values = List.copyOf(values);
    }

    @Override
    public FontFamilyList computeValue(FontFamilyList parentValue) {
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
        FontFamilyList other = (FontFamilyList) obj;
        return Objects.equals(values, other.values);
    }

    public List<FontFamily> getValues() {
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
        return "FontFamilyList [values=" + values + "]";
    }

}
