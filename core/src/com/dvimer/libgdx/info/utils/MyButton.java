package com.dvimer.libgdx.info.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;

/**
 * Created by dvime_000 on 01.10.2017.
 */
public class MyButton extends Actor {

    private final static int SIZE_BUTTON = 70;
    private Label title;

    public MyButton(int x, int y) {
        draw(x, y);
    }

    public Label getTitle() {
        return title;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }


    public void draw(int x,int y) {
        Skin skin = new Skin(Gdx.files.internal("skin/comic/skin/comic-ui.json"));

        title = new Label("Button", skin, "narration");
        title.setSize(SIZE_BUTTON, SIZE_BUTTON);
        title.setPosition(x, y);
        title.setAlignment(Align.center);

        title.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                title.setText("Hello");
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                title.setText("Bay");
                return true;
            }
        });
    }
}
