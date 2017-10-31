package com.dvimer.libgdx.info.runner.item;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.dvimer.libgdx.info.runner.events.AttackEvent;
import com.dvimer.libgdx.info.runner.factory.MyLabel;

/**
 * Created by dvime_000 on 02.10.2017.
 */
public class Monster extends GameObject {

    private Player player;
    private String name;
    private int hp;
    private int attack;

    public Monster(int x, int y, Player player, String name) {
        super(new TextureRegion(new Texture(Gdx.files.internal("greenMonster.png"))), x, y);
        this.player = player;
        this.hp = 100;
        this.attack = 5;
        this.name = name;
        setTouchable(Touchable.enabled);
        addListener(new AttackEvent(player));
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        moveBy(-100 * delta, 0);
        if (getBounds().overlaps(player.getBounds())) {
            player.getDamage(attack + random.nextInt(5));
            visitPlayer(player, 40);
        }
    }

    public void getDamage(int damage) {
        hp -= damage;
        MyLabel label = new MyLabel("-" + damage, 0, 500);

        getStage().addActor(label);
//        for (Actor actor : getStage().getActors()) {
//            if (actor.getName() != null && actor.getName().equals("damage")) {

        label.setPosition(getX() + getWidth(), getY() + getHeight());

        SequenceAction sequenceAction = new SequenceAction();
        sequenceAction.addAction(Actions.moveTo(getX() + getWidth() + 50, getY() + getHeight() - 100, 1f));
        sequenceAction.addAction(Actions.removeActor());

        label.addAction(sequenceAction);
//        System.out.println();

//            }
//        }
//        MyLabel myLabel = new MyLabel((int) getWidth(), (int) getHeight(), damage + "");
//        getStage().addActor(myLabel);
//
        System.out.println(hp);
    }


    public void visitPlayer(Player player, int moveX) {
        getDamage(player.getAttack());
        moveBy(moveX, 0);
        if (hp <= 0) {

            addAction(Actions.sequence(Actions.moveBy(800, 0, 1)));

            hp = 100;
            player.addCoin(random.nextInt(10));
        }
    }

    @Override
    public String getName() {
        return name;
    }
}
