package com.dvimer.libgdx.info.runner.item;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.Random;

/**
 * Created by dvime_000 on 07.10.2017.
 */
public abstract class GameObject extends Actor {

    private TextureRegion region;
    protected Rectangle bounds;
    protected Random random;


    public GameObject(TextureRegion region) {
        this.region = region;
        setSize(region.getRegionWidth(), region.getRegionHeight());
        setBounds(getX(), getY(), getWidth(), getHeight());
        setOrigin(getWidth() / 2, getHeight() / 2);
        bounds = new Rectangle((int) getX(), (int) getY(), (int) getWidth(), (int) getHeight());

        updatePositon();
        this.random = new Random();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(region, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
        updatePositon();
    }

    private void updatePositon() {
        bounds.setPosition(getX(), getY());
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public Texture getTexture() {
        return region.getTexture();
    }

}
