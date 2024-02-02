package com.jonathanschram.vttconverter.lib.vtt.css.types;

public class AbsoluteColor implements Color {
    // Standard HTML named colors.
    public static final AbsoluteColor ALICE_BLUE = new AbsoluteColor(240, 248, 255);
    public static final AbsoluteColor ANTIQUE_WHITE = new AbsoluteColor(250, 235, 215);
    public static final AbsoluteColor AQUA = new AbsoluteColor(0, 255, 255);
    public static final AbsoluteColor AQUAMARINE = new AbsoluteColor(127, 255, 212);
    public static final AbsoluteColor AZURE = new AbsoluteColor(240, 255, 255);
    public static final AbsoluteColor BEIGE = new AbsoluteColor(245, 245, 220);
    public static final AbsoluteColor BISQUE = new AbsoluteColor(255, 228, 196);
    public static final AbsoluteColor BLACK = new AbsoluteColor(0, 0, 0);
    public static final AbsoluteColor BLANCHED_ALMOND = new AbsoluteColor(255, 235, 205);
    public static final AbsoluteColor BLUE = new AbsoluteColor(0, 0, 255);
    public static final AbsoluteColor BLUE_VIOLET = new AbsoluteColor(138, 43, 226);
    public static final AbsoluteColor BROWN = new AbsoluteColor(165, 42, 42);
    public static final AbsoluteColor BURLY_WOOD = new AbsoluteColor(222, 184, 135);
    public static final AbsoluteColor CADET_BLUE = new AbsoluteColor(95, 158, 160);
    public static final AbsoluteColor CHARTREUSE = new AbsoluteColor(127, 255, 0);
    public static final AbsoluteColor CHOCOLATE = new AbsoluteColor(210, 105, 30);
    public static final AbsoluteColor CORAL = new AbsoluteColor(255, 127, 80);
    public static final AbsoluteColor CORNFLOWER_BLUE = new AbsoluteColor(100, 149, 237);
    public static final AbsoluteColor CORNSILK = new AbsoluteColor(255, 248, 220);
    public static final AbsoluteColor CRIMSON = new AbsoluteColor(220, 20, 60);
    public static final AbsoluteColor CYAN = new AbsoluteColor(0, 255, 255);
    public static final AbsoluteColor DARK_BLUE = new AbsoluteColor(0, 0, 139);
    public static final AbsoluteColor DARK_CYAN = new AbsoluteColor(0, 139, 139);
    public static final AbsoluteColor DARK_GOLDEN_ROD = new AbsoluteColor(184, 134, 11);
    public static final AbsoluteColor DARK_GRAY = new AbsoluteColor(169, 169, 169);
    public static final AbsoluteColor DARK_GREY = new AbsoluteColor(169, 169, 169);
    public static final AbsoluteColor DARK_GREEN = new AbsoluteColor(0, 100, 0);
    public static final AbsoluteColor DARK_KHAKI = new AbsoluteColor(189, 183, 107);
    public static final AbsoluteColor DARK_MAGENTA = new AbsoluteColor(139, 0, 139);
    public static final AbsoluteColor DARK_OLIVE_GREEN = new AbsoluteColor(85, 107, 47);
    public static final AbsoluteColor DARK_ORANGE = new AbsoluteColor(255, 140, 0);
    public static final AbsoluteColor DARK_ORCHID = new AbsoluteColor(153, 50, 204);
    public static final AbsoluteColor DARK_RED = new AbsoluteColor(139, 0, 0);
    public static final AbsoluteColor DARK_SALMON = new AbsoluteColor(233, 150, 122);
    public static final AbsoluteColor DARK_SEA_GREEN = new AbsoluteColor(143, 188, 143);
    public static final AbsoluteColor DARK_SLATE_BLUE = new AbsoluteColor(72, 61, 139);
    public static final AbsoluteColor DARK_SLATE_GRAY = new AbsoluteColor(47, 79, 79);
    public static final AbsoluteColor DARK_SLATE_GREY = new AbsoluteColor(47, 79, 79);
    public static final AbsoluteColor DARK_TURQUOISE = new AbsoluteColor(0, 206, 209);
    public static final AbsoluteColor DARK_VIOLET = new AbsoluteColor(148, 0, 211);
    public static final AbsoluteColor DEEP_PINK = new AbsoluteColor(255, 20, 147);
    public static final AbsoluteColor DEEP_SKY_BLUE = new AbsoluteColor(0, 191, 255);
    public static final AbsoluteColor DIM_GRAY = new AbsoluteColor(105, 105, 105);
    public static final AbsoluteColor DIM_GREY = new AbsoluteColor(105, 105, 105);
    public static final AbsoluteColor DODGER_BLUE = new AbsoluteColor(30, 144, 255);
    public static final AbsoluteColor FIRE_BRICK = new AbsoluteColor(178, 34, 34);
    public static final AbsoluteColor FLORAL_WHITE = new AbsoluteColor(255, 250, 240);
    public static final AbsoluteColor FOREST_GREEN = new AbsoluteColor(34, 139, 34);
    public static final AbsoluteColor FUCHSIA = new AbsoluteColor(255, 0, 255);
    public static final AbsoluteColor GAINSBORO = new AbsoluteColor(220, 220, 220);
    public static final AbsoluteColor GHOST_WHITE = new AbsoluteColor(248, 248, 255);
    public static final AbsoluteColor GOLD = new AbsoluteColor(255, 215, 0);
    public static final AbsoluteColor GOLDEN_ROD = new AbsoluteColor(218, 165, 32);
    public static final AbsoluteColor GRAY = new AbsoluteColor(128, 128, 128);
    public static final AbsoluteColor GREY = new AbsoluteColor(128, 128, 128);
    public static final AbsoluteColor GREEN = new AbsoluteColor(0, 128, 0);
    public static final AbsoluteColor GREEN_YELLOW = new AbsoluteColor(173, 255, 47);
    public static final AbsoluteColor HONEY_DEW = new AbsoluteColor(240, 255, 240);
    public static final AbsoluteColor HOT_PINK = new AbsoluteColor(255, 105, 180);
    public static final AbsoluteColor INDIAN_RED = new AbsoluteColor(205, 92, 92);
    public static final AbsoluteColor INDIGO = new AbsoluteColor(75, 0, 130);
    public static final AbsoluteColor IVORY = new AbsoluteColor(255, 255, 240);
    public static final AbsoluteColor KHAKI = new AbsoluteColor(240, 230, 140);
    public static final AbsoluteColor LAVENDER = new AbsoluteColor(230, 230, 250);
    public static final AbsoluteColor LAVENDER_BLUSH = new AbsoluteColor(255, 240, 245);
    public static final AbsoluteColor LAWN_GREEN = new AbsoluteColor(124, 252, 0);
    public static final AbsoluteColor LEMON_CHIFFON = new AbsoluteColor(255, 250, 205);
    public static final AbsoluteColor LIGHT_BLUE = new AbsoluteColor(173, 216, 230);
    public static final AbsoluteColor LIGHT_CORAL = new AbsoluteColor(240, 128, 128);
    public static final AbsoluteColor LIGHT_CYAN = new AbsoluteColor(224, 255, 255);
    public static final AbsoluteColor LIGHT_GOLDEN_ROD_YELLOW = new AbsoluteColor(250, 250, 210);
    public static final AbsoluteColor LIGHT_GRAY = new AbsoluteColor(211, 211, 211);
    public static final AbsoluteColor LIGHT_GREY = new AbsoluteColor(211, 211, 211);
    public static final AbsoluteColor LIGHT_GREEN = new AbsoluteColor(144, 238, 144);
    public static final AbsoluteColor LIGHT_PINK = new AbsoluteColor(255, 182, 193);
    public static final AbsoluteColor LIGHT_SALMON = new AbsoluteColor(255, 160, 122);
    public static final AbsoluteColor LIGHT_SEA_GREEN = new AbsoluteColor(32, 178, 170);
    public static final AbsoluteColor LIGHT_SKY_BLUE = new AbsoluteColor(135, 206, 250);
    public static final AbsoluteColor LIGHT_SLATE_GRAY = new AbsoluteColor(119, 136, 153);
    public static final AbsoluteColor LIGHT_SLATE_GREY = new AbsoluteColor(119, 136, 153);
    public static final AbsoluteColor LIGHT_STEEL_BLUE = new AbsoluteColor(176, 196, 222);
    public static final AbsoluteColor LIGHT_YELLOW = new AbsoluteColor(255, 255, 224);
    public static final AbsoluteColor LIME = new AbsoluteColor(0, 255, 0);
    public static final AbsoluteColor LIME_GREEN = new AbsoluteColor(50, 205, 50);
    public static final AbsoluteColor LINEN = new AbsoluteColor(250, 240, 230);
    public static final AbsoluteColor MAGENTA = new AbsoluteColor(255, 0, 255);
    public static final AbsoluteColor MAROON = new AbsoluteColor(128, 0, 0);
    public static final AbsoluteColor MEDIUM_AQUA_MARINE = new AbsoluteColor(102, 205, 170);
    public static final AbsoluteColor MEDIUM_BLUE = new AbsoluteColor(0, 0, 205);
    public static final AbsoluteColor MEDIUM_ORCHID = new AbsoluteColor(186, 85, 211);
    public static final AbsoluteColor MEDIUM_PURPLE = new AbsoluteColor(147, 112, 219);
    public static final AbsoluteColor MEDIUM_SEA_GREEN = new AbsoluteColor(60, 179, 113);
    public static final AbsoluteColor MEDIUM_SLATE_BLUE = new AbsoluteColor(123, 104, 238);
    public static final AbsoluteColor MEDIUM_SPRING_GREEN = new AbsoluteColor(0, 250, 154);
    public static final AbsoluteColor MEDIUM_TURQUOISE = new AbsoluteColor(72, 209, 204);
    public static final AbsoluteColor MEDIUM_VIOLET_RED = new AbsoluteColor(199, 21, 133);
    public static final AbsoluteColor MIDNIGHT_BLUE = new AbsoluteColor(25, 25, 112);
    public static final AbsoluteColor MINT_CREAM = new AbsoluteColor(245, 255, 250);
    public static final AbsoluteColor MISTY_ROSE = new AbsoluteColor(255, 228, 225);
    public static final AbsoluteColor MOCCASIN = new AbsoluteColor(255, 228, 181);
    public static final AbsoluteColor NAVAJO_WHITE = new AbsoluteColor(255, 222, 173);
    public static final AbsoluteColor NAVY = new AbsoluteColor(0, 0, 128);
    public static final AbsoluteColor OLD_LACE = new AbsoluteColor(253, 245, 230);
    public static final AbsoluteColor OLIVE = new AbsoluteColor(128, 128, 0);
    public static final AbsoluteColor OLIVE_DRAB = new AbsoluteColor(107, 142, 35);
    public static final AbsoluteColor ORANGE = new AbsoluteColor(255, 165, 0);
    public static final AbsoluteColor ORANGE_RED = new AbsoluteColor(255, 69, 0);
    public static final AbsoluteColor ORCHID = new AbsoluteColor(218, 112, 214);
    public static final AbsoluteColor PALE_GOLDEN_ROD = new AbsoluteColor(238, 232, 170);
    public static final AbsoluteColor PALE_GREEN = new AbsoluteColor(152, 251, 152);
    public static final AbsoluteColor PALE_TURQUOISE = new AbsoluteColor(175, 238, 238);
    public static final AbsoluteColor PALE_VIOLET_RED = new AbsoluteColor(219, 112, 147);
    public static final AbsoluteColor PAPAYA_WHIP = new AbsoluteColor(255, 239, 213);
    public static final AbsoluteColor PEACH_PUFF = new AbsoluteColor(255, 218, 185);
    public static final AbsoluteColor PERU = new AbsoluteColor(205, 133, 63);
    public static final AbsoluteColor PINK = new AbsoluteColor(255, 192, 203);
    public static final AbsoluteColor PLUM = new AbsoluteColor(221, 160, 221);
    public static final AbsoluteColor POWDER_BLUE = new AbsoluteColor(176, 224, 230);
    public static final AbsoluteColor PURPLE = new AbsoluteColor(128, 0, 128);
    public static final AbsoluteColor REBECCA_PURPLE = new AbsoluteColor(102, 51, 153);
    public static final AbsoluteColor RED = new AbsoluteColor(255, 0, 0);
    public static final AbsoluteColor ROSY_BROWN = new AbsoluteColor(188, 143, 143);
    public static final AbsoluteColor ROYAL_BLUE = new AbsoluteColor(65, 105, 225);
    public static final AbsoluteColor SADDLE_BROWN = new AbsoluteColor(139, 69, 19);
    public static final AbsoluteColor SALMON = new AbsoluteColor(250, 128, 114);
    public static final AbsoluteColor SANDY_BROWN = new AbsoluteColor(244, 164, 96);
    public static final AbsoluteColor SEA_GREEN = new AbsoluteColor(46, 139, 87);
    public static final AbsoluteColor SEA_SHELL = new AbsoluteColor(255, 245, 238);
    public static final AbsoluteColor SIENNA = new AbsoluteColor(160, 82, 45);
    public static final AbsoluteColor SILVER = new AbsoluteColor(192, 192, 192);
    public static final AbsoluteColor SKY_BLUE = new AbsoluteColor(135, 206, 235);
    public static final AbsoluteColor SLATE_BLUE = new AbsoluteColor(106, 90, 205);
    public static final AbsoluteColor SLATE_GRAY = new AbsoluteColor(112, 128, 144);
    public static final AbsoluteColor SLATE_GREY = new AbsoluteColor(112, 128, 144);
    public static final AbsoluteColor SNOW = new AbsoluteColor(255, 250, 250);
    public static final AbsoluteColor SPRING_GREEN = new AbsoluteColor(0, 255, 127);
    public static final AbsoluteColor STEEL_BLUE = new AbsoluteColor(70, 130, 180);
    public static final AbsoluteColor TAN = new AbsoluteColor(210, 180, 140);
    public static final AbsoluteColor TEAL = new AbsoluteColor(0, 128, 128);
    public static final AbsoluteColor THISTLE = new AbsoluteColor(216, 191, 216);
    public static final AbsoluteColor TOMATO = new AbsoluteColor(255, 99, 71);
    public static final AbsoluteColor TURQUOISE = new AbsoluteColor(64, 224, 208);
    public static final AbsoluteColor VIOLET = new AbsoluteColor(238, 130, 238);
    public static final AbsoluteColor WHEAT = new AbsoluteColor(245, 222, 179);
    public static final AbsoluteColor WHITE = new AbsoluteColor(255, 255, 255);
    public static final AbsoluteColor WHITE_SMOKE = new AbsoluteColor(245, 245, 245);
    public static final AbsoluteColor YELLOW = new AbsoluteColor(255, 255, 0);
    public static final AbsoluteColor YELLOW_GREEN = new AbsoluteColor(154, 205, 50);

    // System colors. Arbitrarily chosen based on CSS documentation, might revisit.
    public static final AbsoluteColor CANVAS = WHITE;
    public static final AbsoluteColor CANVAS_TEXT = BLACK;
    public static final AbsoluteColor LINK_TEXT = BLUE;
    public static final AbsoluteColor VISITED_TEXT = DARK_ORCHID;
    public static final AbsoluteColor ACTIVE_TEXT = DARK_RED;
    public static final AbsoluteColor BUTTON_FACE = GHOST_WHITE;
    public static final AbsoluteColor BUTTON_TEXT = BLACK;
    public static final AbsoluteColor BUTTON_BORDER = BLACK;
    public static final AbsoluteColor FIELD = WHITE;
    public static final AbsoluteColor FIELD_TEXT = BLACK;
    public static final AbsoluteColor HIGHLIGHT = DODGER_BLUE;
    public static final AbsoluteColor HIGHLIGHT_TEXT = WHITE;
    public static final AbsoluteColor SELECTED_ITEM = DODGER_BLUE;
    public static final AbsoluteColor SELECTED_ITEM_TEXT = WHITE;
    public static final AbsoluteColor MARK = YELLOW;
    public static final AbsoluteColor MARK_TEXT = BLACK;
    public static final AbsoluteColor GRAY_TEXT = GRAY;
    public static final AbsoluteColor ACCENT_COLOR = GREEN;
    public static final AbsoluteColor ACCENT_COLOR_TEXT = WHITE;

    // Special value.
    public static final AbsoluteColor TRANSPARENT = new AbsoluteColor(0, 0, 0, 0);

    private final byte red;
    private final byte green;
    private final byte blue;
    private final double alpha;

    public AbsoluteColor(int red, int green, int blue) {
        this((byte) red, (byte) green, (byte) blue);
    }

    /***
     * Creates a new {@link AbsoluteColor} that is fully opaque. Alpha is set to 1.
     * 
     * @param red
     * @param green
     * @param blue
     */
    public AbsoluteColor(byte red, byte green, byte blue) {
        this(red, green, blue, 1.0);
    }

    public AbsoluteColor(int red, int green, int blue, double alpha) {
        this((byte) red, (byte) green, (byte) blue, alpha);
    }

    public AbsoluteColor(byte red, byte green, byte blue, double alpha) {
        if (alpha < 0 || alpha > 1) {
            throw new IllegalArgumentException("Illegal value for alpha channel: Must be between 0 and 1");
        }

        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }

    public double getAlpha() {
        return alpha;
    }

    public int getBlue() {
        return blue;
    }

    public int getGreen() {
        return green;
    }

    public int getRed() {
        return red;
    }

}
