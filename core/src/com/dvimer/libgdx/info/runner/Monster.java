package com.dvimer.libgdx.info.runner;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.dvimer.libgdx.info.runner.visiter.Visitor;

/**
 * Created by dvime_000 on 02.10.2017.
 */
public class Monster extends GameObject implements Visitor {

    private Player player;
    private int hp;
    private int attack;

    public Monster(int x, int y, Player player) {
        super(new TextureRegion(Runner.BASE_TEXTURE, 369, 465, 300, 300));
        this.player = player;
        this.setPosition(x, y);
        this.hp = 100;
        this.attack = 10;
    }

    @Override
    public void act(float delta) {
        moveBy(-100 * delta, 0);
        if (getBounds().overlaps(player.getBounds())) {
            player.visit(this);

        }
    }

    @Override
    public Actor hit(float x, float y, boolean touchable) {
        return super.hit(x, y, touchable);
    }

    public void getDamage(int damage) {
        hp -= damage;
    }

    @Override
    public void visitPlayer(Player player) {
        player.getDamage(attack);
        getDamage(player.getAttack());
        moveBy(40, 0);
        if (hp <= 0) {
            moveBy(800, 0);
            hp = 100;
        }
    }
}
