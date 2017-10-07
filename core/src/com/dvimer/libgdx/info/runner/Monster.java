package com.dvimer.libgdx.info.runner;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by dvime_000 on 02.10.2017.
 */
public class Monster extends Actor {

    private final TextureRegion region;
    private Rectangle bounds;
    private int hp;
    private int attack;

    public Monster(TextureRegion region) {
        this.hp = 100;
        this.attack = 10;
        this.region = region;
        setSize(region.getRegionWidth() / 3, region.getRegionHeight() / 3);



        bounds = new Rectangle(getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(region, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
        updatePositon();
    }

    public void getDamage(Player player) {
        hp -= player.getAttack();
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
