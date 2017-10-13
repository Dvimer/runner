package com.dvimer.libgdx.info.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.dvimer.libgdx.info.runner.publisher.EventListener;

/**
 * Created by dvime_000 on 01.10.2017.
 */
public class MyLabel implements EventListener {

    private CustomLabel label;

    public MyLabel(int x, int y, String text) {
        this.label = new CustomLabel(text, styleInit());
        this.label.setPosition(x, y);
    }

    public MyLabel(int x, int y, int text) {
        this.label = new CustomLabel(text + "", styleInit());
        this.label.setPosition(x, y);
    }

    private Label.LabelStyle styleInit() {
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        BitmapFont myFont = new BitmapFont(Gdx.files.internal("font/bitmap.fnt"));
        labelStyle.font = myFont;
        labelStyle.fontColor = Color.BLACK;
        return labelStyle;
    }

    public CustomLabel getLabel() {
        return label;
    }

    @Override
    public void update(String type, String text) {
        label.updateText(text);
    }

    @Override
    public void update(String type, int value) {
        label.updateText(value + "");
    }
}
