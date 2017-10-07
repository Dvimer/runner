package com.dvimer.libgdx.info.runner;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by dvime_000 on 07.10.2017.
 */
public class GameObject extends Actor {

    private TextureRegion region;
    private Rectangle bounds;


    public GameObject(TextureRegion region) {
        this.region = region;
        setSize(region.getRegionWidth() / 3, region.getRegionHeight() / 3);
        setBounds(0, 0, getWidth(), getHeight());
        bounds = new Rectangle((int) getX(), (int) getY(), (int) getWidth(), (int) getHeight());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(region, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
        updatePositon();
    }

    private void updatePositon() {
        bounds.setPosition(getX(), getY());
    }

    public Rectangle getBounds() {
        return bounds;
    }
}
