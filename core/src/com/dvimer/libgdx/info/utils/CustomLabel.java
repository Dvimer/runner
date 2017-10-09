package com.dvimer.libgdx.info.utils;

import com.badlogic.gdx.scenes.scene2d.ui.Label;

/**
 * Created by dvime_000 on 09.10.2017.
 */
public class CustomLabel extends Label {
    private String text;

    public CustomLabel(final CharSequence text, final LabelStyle style) {
        super(text, style);
        this.text = text.toString();
    }

    @Override
    public void act(final float delta) {
        this.setText(text);
        super.act(delta);
    }

    public void updateText(final String text) {
        this.text = text;
    }
}
