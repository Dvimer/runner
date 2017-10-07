package com.dvimer.libgdx.info.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;

/**
 * Created by dvime_000 on 01.10.2017.
 */
public class MyButton {

    private Stage stage;
    private Texture texture;
    private Label outputLabel;

    public MyButton(Stage stage) {
        this.stage = stage;
        this.texture = new Texture(Gdx.files.internal("badlogic.jpg"));
    }

    public void draw() {

        Label.LabelStyle labelStyle = new Label.LabelStyle();
        BitmapFont myFont = new BitmapFont(Gdx.files.internal("font/bitmap.fnt"));
        labelStyle.font = myFont;
        labelStyle.fontColor = Color.RED;

        final Label label1 = new Label("Hello peaple", labelStyle);
        label1.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getWidth() / 12);
//        label1.setPosition(Gdx.graphics.getWidth() , Gdx.graphics.getHeight()/2);
        label1.setPosition(1,1);
        label1.setAlignment(Align.center);
        stage.addActor(label1);


        Skin skin = new Skin(Gdx.files.internal("skin/comic/skin/comic-ui.json"));

        final Label title = new Label("Button with Skin", skin, "narration");
        title.setSize(Gdx.graphics.getWidth() / 2, Gdx.graphics.getWidth() / 2);
//        title.setOrigin(title.getWidth()/2,title.getHeight()/2);
        title.setPosition(Gdx.graphics.getWidth() / 2 - Gdx.graphics.getWidth() / 4, Gdx.graphics.getHeight() / 2 - title.getHeight() / 2);
        title.setAlignment(Align.center);
        title.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                label1.setText("Hello");
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                label1.setText("Bay");
                return true;
            }
        });


        stage.addActor(title);

//        Button button1 = new Button(skin,"half-tone");


    }
}
