package com.dvimer.libgdx.info.runner.item;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.dvimer.libgdx.info.runner.factory.Labels;
import com.dvimer.libgdx.info.runner.publisher.EventManager;

/**
 * Created by dvime_000 on 02.10.2017.
 */
public class Player extends GameObject {

    public static final int MOVE_X = 20;
    private EventManager events;
    private Array<Monster> monsters;
    private int hp;
    private float mp;
    private int attack;
    private int coin;
    private int maxHp;
    private int maxMp;

    public Player(int x, int y) {
        super(new TextureRegion(new Texture(Gdx.files.internal("player.png"))));
        this.setPosition(x, y);
        this.hp = 200;
        this.maxHp = hp;
        this.mp = 100;
        this.maxMp = (int) mp;
        this.attack = 20 + random.nextInt(10);
        this.coin = 0;
        this.events = new EventManager("hp", "coin", "mp");
    }


    @Override
    public void act(float delta) {
        regenMaxMana(delta);
    }



    public void regenMaxMana(float delta) {
        if (mp < maxMp) {
            mp += 1 * delta;
            updateMana();
        }
    }

    public void getDamage(int damage) {
        hp -= damage;
        updateHp();
    }


    public void reset() {
        hp = maxHp;
        updateHp();
    }

    public void addCoin(int coin) {
        this.coin += coin;
        updateCoin();
    }

    public void manaCast(int mana) {
        this.mp -= mana;
        updateMana();
    }

    public void regenMaxMana() {
        this.mp = 100;
        updateMana();
    }

    public void heal() {
        hp = maxHp;
        updateHp();
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getMp() {
        return (int) mp;
    }

    public int getCoin() {
        return coin;
    }


    public boolean isDead() {
        return hp <= 0;
    }

    public void updateHp() {
        events.notify("hp", hp);
    }

    public void updateMana() {
        events.notify("mp", (int) mp);
    }

    public void updateCoin() {
        events.notify("coin", coin);
    }

    public void addLabels(Labels labels) {
        events.subscribe("hp", labels.getHpValue());
        events.subscribe("mp", labels.getMpValue());
        events.subscribe("coin", labels.getCoinValue());
    }

    public void setMonsters(Array<Monster> monsters) {
        this.monsters = monsters;
    }

    public void attackMonsters() {
        for (Monster monster : monsters) {
            if (monster.getX() < getX() + getWidth() + 100) {
                monster.visitPlayer(this, MOVE_X);
            } else {
                System.out.println("Пичль");
            }
        }
    }

    public void magicDamageMonsters() {
        for (Monster monster : monsters) {
            if (monster.getX() < getX() + getWidth() + 1000) {
                if (mp > 40) {
                    monster.visitPlayer(this, 0);
                    manaCast(40);
                    break;
                }
            }
        }
    }

}
