package com.dvimer.libgdx.info.utils;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.dvimer.libgdx.info.runner.Runner;

/**
 * Created by dvime_000 on 09.10.2017.
 */
public class CustomLabel extends Label {
    private String text;

    public CustomLabel(String text, int x, int y) {
        super(text, Runner.gameSkin, "big");
        setPosition(x, y);
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
