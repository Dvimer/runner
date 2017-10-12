package com.dvimer.libgdx.info.runner;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.dvimer.libgdx.info.runner.publisher.EventManager;
import com.dvimer.libgdx.info.runner.visiter.Visitor;

/**
 * Created by dvime_000 on 02.10.2017.
 */
public class Player extends GameObject {

    public EventManager events;
    private int hp;
    private int mp;
    private int attack;
    private int coin;

    public Player(int x, int y) {
        super(new TextureRegion(Runner.BASE_TEXTURE, 32, 465, 300, 300));
        this.setPosition(x, y);
        this.hp = 200;
        this.mp = 100;
        this.attack = 20;
        this.coin = 0;
        this.events = new EventManager("hp", "coin");
    }

    public void getDamage(int damage) {
        hp -= damage;
        updateHp();

    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getMp() {
        return mp;
    }

    public int getCoin() {
        return coin;
    }

    public void accept(Visitor visitor) {
        visitor.visitPlayer(this);
    }

    public void addCoin(int coin) {
        this.coin += coin;
        updateCoin();
    }

    public void updateHp() {
        events.notify("hp", hp);
    }

    public void updateCoin() {
        events.notify("coin", coin);
    }


}
