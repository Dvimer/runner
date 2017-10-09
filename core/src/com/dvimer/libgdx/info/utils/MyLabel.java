package com.dvimer.libgdx.info.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;

/**
 * Created by dvime_000 on 01.10.2017.
 */
public class MyLabel {

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

    public void updateText(String text) {
        label.updateText(text);
    }

    public void updateText(int text) {
        label.updateText(text + "");
    }

    public CustomLabel getLabel() {
        return label;
    }
}
