package com.dvimer.libgdx.info.runner.item;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by dvime_000 on 25.10.2017.
 */
public class Background extends GameObject {

    public Background() {
        super(new TextureRegion(new Texture(Gdx.files.internal("background.png"))), 0, 0);
        setSize(getWidth() * 5, getHeight() * 5);
    }
}
