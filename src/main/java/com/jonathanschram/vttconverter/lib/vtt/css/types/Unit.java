package com.jonathanschram.vttconverter.lib.vtt.css.types;

import java.util.Set;

/***
 * An enumeration of the different kinds of units that CSS allows.
 */
public enum Unit {
    /* ---- Absolute units ---- */
    CENTIMETER, MILLIMETER, QUARTER_MILLIMETER, INCHES, PICAS, POINTS, PIXELS,

    /* ---- Relative units ---- */

    /* Font-relative units */

    // Relative to font measurements.
    EM, EX, CAP, CH, IC, LH,
    // Relative to root element.
    REM, REX, RCAP, RCH, RIC, RLH,

    /* Viewport-relative units */

    // Width
    VW, SVW, LVW, DVW,
    // Height
    VH, SVH, LVH, DVH,
    // Inline axis
    VI, SVI, LVI, DVI,
    // Initial containing block
    VB, SVB, LVB, DVB,
    // Min of w/h
    VMIN, SVMIN, LVMIN, DVMIN,
    // Max of w/h
    VMAX, SVMAX, LVMAX, DVMAX;

    public static final Set<Unit> ABSOLUTE_UNITS = Set.of(CENTIMETER, MILLIMETER, QUARTER_MILLIMETER, INCHES, PICAS,
            POINTS, PIXELS);
    public static final Set<Unit> RELATIVE_UNITS = Set.of(
            EM, EX, CAP, CH, IC, LH,
            REM, REX, RCAP, RCH, RIC, RLH,
            VW, SVW, LVW, DVW,
            VH, SVH, LVH, DVH,
            VI, SVI, LVI, DVI,
            VB, SVB, LVB, DVB,
            VMIN, SVMIN, LVMIN, DVMIN,
            VMAX, SVMAX, LVMAX, DVMAX);
}
