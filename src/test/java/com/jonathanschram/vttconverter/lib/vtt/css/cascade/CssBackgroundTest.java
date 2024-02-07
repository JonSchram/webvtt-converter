package com.jonathanschram.vttconverter.lib.vtt.css.cascade;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.jonathanschram.vttconverter.lib.vtt.css.GlobalValue;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.background.CssBackground;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.background.CssBackgroundAttachment;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.background.CssBackgroundColor;
import com.jonathanschram.vttconverter.lib.vtt.css.cascade.background.CssBackgroundOrigin;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.background.BackgroundAttachment;
import com.jonathanschram.vttconverter.lib.vtt.css.properties.background.BackgroundOrigin;
import com.jonathanschram.vttconverter.lib.vtt.css.types.AbsoluteColor;

class CssBackgroundTest {

    @Test
    void testUpdateStyle() {
        CssBackground background = new CssBackground.Builder().setColor(new CssBackgroundColor(AbsoluteColor.RED))
                .setOrigin(new CssBackgroundOrigin(BackgroundOrigin.CONTENT_BOX))
                .build();

        CssBackground updateBackground = new CssBackground.Builder()
                .setAttachment(new CssBackgroundAttachment(BackgroundAttachment.SCROLL))
                .setOrigin(new CssBackgroundOrigin(GlobalValue.REVERT))
                .build();

        background.updateStyle(updateBackground);

        CssBackground expectedBackground = new CssBackground.Builder()
                .setColor(new CssBackgroundColor(AbsoluteColor.RED))
                .setAttachment(new CssBackgroundAttachment(BackgroundAttachment.SCROLL))
                .setOrigin(new CssBackgroundOrigin(GlobalValue.REVERT))
                .build();

        assertEquals(expectedBackground, background);
    }

}
