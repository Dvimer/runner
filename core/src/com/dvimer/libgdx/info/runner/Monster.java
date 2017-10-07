package com.dvimer.libgdx.info.runner;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by dvime_000 on 02.10.2017.
 */
public class Monster extends GameObject {

    private int hp;
    private int attack;

    public Monster(TextureRegion region) {
        super(region);
        this.hp = 100;
        this.attack = 10;
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
