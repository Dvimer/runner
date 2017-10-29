package com.dvimer.libgdx.info.runner.item;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by dvime_000 on 02.10.2017.
 */
public class Monster extends GameObject {

    private Player player;
    private String name;
    private int hp;
    private int attack;

    public Monster(int x, int y, Player player,String name) {
        super(new TextureRegion(new Texture(Gdx.files.internal("greenMonster.png"))));
        this.player = player;
        this.setPosition(x, y);
        this.hp = 100;
        this.attack = 5;
        this.name = name;
    }

    @Override
    public void act(float delta) {
        moveBy(-100 * delta, 0);
        if (getBounds().overlaps(player.getBounds())) {
            player.getDamage(attack + random.nextInt(5));
            visitPlayer(player, 40);
        }
    }

    public void getDamage(int damage) {
        hp -= damage;
        System.out.println(hp);
    }


    public void visitPlayer(Player player, int moveX) {
        getDamage(player.getAttack());
        moveBy(moveX, 0);
        if (hp <= 0) {
            moveBy(800, 0);
            hp = 100;
            player.addCoin(random.nextInt(10));
        }
    }

    @Override
    public String getName() {
        return name;
    }
}
