package com.jonathanschram.vttconverter.lib.vtt.css.types.length;

import java.util.Objects;

import com.jonathanschram.vttconverter.lib.vtt.css.cascade.CascadeValueReference;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.PropertyName;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.Font;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.font.FontSize;
import com.jonathanschram.vttconverter.lib.vtt.css.types.Unit;

public class NumericLength implements Length {

    private final double value;
    private final Unit unit;

    public NumericLength(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public Unit getUnit() {
        return unit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(unit, value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        NumericLength other = (NumericLength) obj;
        return unit == other.unit && Double.doubleToLongBits(value) == Double.doubleToLongBits(other.value);
    }

    @Override
    public String toString() {
        return "NumericLength [value=" + value + ", unit=" + unit + "]";
    }

    @Override
    public boolean isAbsoluteLength() {
        return Unit.ABSOLUTE_UNITS.contains(unit);
    }

    @Override
    public Length multiply(double scalar) {
        return new NumericLength(this.value * scalar, unit);
    }

    @Override
    public Length convertToAbsoluteLength(CascadeValueReference<Font> fontReference,
            PropertyName currentProperty) {
        if (isAbsoluteLength()) {
            return this;
        }

        // There are a lot of switch cases to handle, so assert the unit is going to be
        // found.
        assert Unit.RELATIVE_UNITS.contains(unit);

        // TODO: Need logic for a couple dozen length units.
        switch (unit) {
        case EM:
            Font referencedFont = currentProperty == PropertyName.FONT_SIZE ? fontReference.getParentValue()
                    : fontReference.getSelfValue();
            FontSize size = referencedFont.getSize();

            break;
        case EX:
        case CAP:
        case CH:
        case IC:
        case LH:

        case REM:
        case REX:
        case RCAP:
        case RCH:
        case RIC:
        case RLH:

        case VW:
        case SVW:
        case LVW:
        case DVW:

        case VH:
        case SVH:
        case LVH:
        case DVH:

        case VI:
        case SVI:
        case LVI:
        case DVI:

        case VB:
        case SVB:
        case LVB:
        case DVB:

        case VMIN:
        case SVMIN:
        case LVMIN:
        case DVMIN:

        case VMAX:
        case SVMAX:
        case LVMAX:
        case DVMAX:
        default:
            throw new RuntimeException("Unhandled relative length unit.");
        }

        return null;
    }

}
