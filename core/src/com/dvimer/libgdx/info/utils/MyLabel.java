package com.dvimer.libgdx.info.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;

/**
 * Created by dvime_000 on 01.10.2017.
 */
public class MyLabel {

    private Stage stage;

    public MyLabel(Stage stage) {
        this.stage = stage;
    }

    public void draw() {
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        BitmapFont myFont = new BitmapFont(Gdx.files.internal("font/bitmap.fnt"));
        labelStyle.font = myFont;
        labelStyle.fontColor = Color.RED;

        Label label1 = new Label("Hello peaple", labelStyle);
        label1.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getWidth() / 12);
        label1.setPosition(0 , 0);
        label1.setAlignment(Align.center);
        stage.addActor(label1);

    }
}
