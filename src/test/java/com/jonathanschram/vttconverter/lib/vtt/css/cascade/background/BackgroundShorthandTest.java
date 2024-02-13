package com.jonathanschram.vttconverter.lib.vtt.css.cascade.background;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.jonathanschram.vttconverter.lib.vtt.css.GlobalValue;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.background.BackgroundAttachment;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.background.BackgroundOrigin;
import com.jonathanschram.vttconverter.lib.vtt.css.types.AbsoluteColor;

class BackgroundShorthandTest {

    @Test
    void testUpdateStyle() {
        BackgroundShorthand background = BackgroundShorthand.Builder.createUnset()
                .setColor(AbsoluteColor.RED).setOrigin(BackgroundOrigin.CONTENT_BOX)
                .build();

        BackgroundShorthand updateBackground = BackgroundShorthand.Builder.createUpdate()
                .setAttachment(BackgroundAttachment.SCROLL)
                .setOrigin(new CssBackgroundOrigin(GlobalValue.REVERT))
                .build();

        background.updateStyle(updateBackground);

        BackgroundShorthand expectedBackground = new BackgroundShorthand.Builder()
                .setAttachment(BackgroundAttachment.SCROLL)
                .setColor(AbsoluteColor.RED)
                .setImage(new CssBackgroundImage())
                .setOrigin(new CssBackgroundOrigin(GlobalValue.REVERT))
                .setPosition(new CssBackgroundPosition())
                .setRepeat(new CssBackgroundRepeat())
                .setSize(new CssBackgroundSize())
                .setClip(new CssBackgroundClip())
                .build();

        assertEquals(expectedBackground, background);
    }

}
