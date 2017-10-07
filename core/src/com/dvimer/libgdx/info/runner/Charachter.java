package com.dvimer.libgdx.info.runner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;

/**
 * Created by dvime_000 on 05.10.2017.
 */
public class Charachter extends Actor {

    private Label.LabelStyle labelStyle;
    private Label label;

    public Charachter() {
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        BitmapFont myFont = new BitmapFont(Gdx.files.internal("font/bitmap.fnt"));
        labelStyle.font = myFont;
        labelStyle.fontColor = Color.BLACK;

        this.label = new Label("10fdsfdsfasd0", labelStyle);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        label.setSize(100, 100);
        label.setPosition(40, 100);
        label.setAlignment(Align.center);
    }
}
