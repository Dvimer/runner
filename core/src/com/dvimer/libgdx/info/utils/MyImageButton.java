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
public class MyImageButton extends Actor {

    private ImageButton button;

    public MyImageButton(int x, int y, Texture imageUp, Texture imageDown) {
        ImageButton.ImageButtonStyle style = new ImageButton.ImageButtonStyle();
        style.imageDown = new TextureRegionDrawable(new TextureRegion(imageDown));
        style.imageUp = new TextureRegionDrawable(new TextureRegion(imageUp));
        button = new ImageButton(style);
        button.setPosition(x, y);

    }

    public MyImageButton(int x, int y, Texture image) {
        ImageButton.ImageButtonStyle style = new ImageButton.ImageButtonStyle();
        style.imageDown = new TextureRegionDrawable(new TextureRegion(image));
        style.imageUp = new TextureRegionDrawable(new TextureRegion(image));
        button = new ImageButton(style);
        button.setPosition(x, y);
    }

    public ImageButton getButton() {
        return button;
    }
}
