package com.dvimer.libgdx.info.runner;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;

/**
 * Created by dvime_000 on 02.10.2017.
 */
public class Monster extends GameObject {

    private int hp;
    private int attack;

    public Monster(int x, int y) {
        super(new TextureRegion(Runner.BASE_TEXTURE, 369, 465, 300, 300));
        this.setPosition(x, y);
        this.hp = 100;
        this.attack = 10;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }

    @Override
    public void act(float delta) {
        moveBy(-100 * delta, 0);
    }

    @Override
    public Actor hit(float x, float y, boolean touchable) {
        return super.hit(x, y, touchable);
    }

    public void getDamage(Player player) {
        hp -= player.getAttack();
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
