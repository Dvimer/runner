package com.dvimer.libgdx.info.utils;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 * Created by dvime_000 on 01.10.2017.
 */
public class MyImageButton extends ImageButton {

    public MyImageButton(int x, int y, Texture imageUp, Texture imageDown, EventListener event) {
        super(
                new TextureRegionDrawable(new TextureRegion(imageUp)),
                new TextureRegionDrawable(new TextureRegion(imageDown)));
        setPosition(x, y);
        setSize(100, 100);
        addListener(event);
    }

    public MyImageButton(int x, int y, Texture image, EventListener event) {
        this(x, y, image, image, event);
    }
}
