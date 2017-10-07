package com.dvimer.libgdx.info.runner;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by dvime_000 on 02.10.2017.
 */
public class Player extends Actor {

    private final TextureRegion region;
    private Rectangle bounds;
    private int hp;
    private int attack;

    public Player(TextureRegion region) {
        this.hp = 200;
        this.attack = 20;
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

    public void getDamage(Monster monster) {
        hp -= monster.getAttack();
    }

    public void updatePositon() {
        bounds.setPosition(getX(), getY());
    }

    public Rectangle getPolygon() {
        return bounds;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
}
