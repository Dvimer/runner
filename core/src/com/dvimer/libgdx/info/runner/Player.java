package com.dvimer.libgdx.info.runner;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by dvime_000 on 02.10.2017.
 */
public class Player extends GameObject {

    private int hp;
    private int attack;

    public Player(int x, int y) {
        super(new TextureRegion(Runner.BASE_TEXTURE, 32, 465, 300, 300));
        this.setPosition(x,y);
        this.hp = 200;
        this.attack = 20;
    }

    public void getDamage(Monster monster) {
        hp -= monster.getAttack();
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
