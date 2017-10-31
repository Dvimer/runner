package com.dvimer.libgdx.info.runner.factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.dvimer.libgdx.info.runner.Runner;
import com.dvimer.libgdx.info.runner.publisher.EventListener;
import com.dvimer.libgdx.info.utils.CustomLabel;

/**
 * Created by dvime_000 on 01.10.2017.
 */
public class MyLabel extends Label implements EventListener {

    public MyLabel(String text, int x, int y) {
        super(text, Runner.gameSkin, "big");
        setPosition(x, y);
    }

    public MyLabel(int number, int x, int y) {
        super(number + "", Runner.gameSkin, "big");
        setPosition(x, y);
    }


    @Override
    public void act(final float delta) {
        super.act(delta);
    }

    @Override
    public void update(String type, String text) {
        setText(text);
    }

    @Override
    public void update(String type, int value) {
        setText(value + "");

    }
}
