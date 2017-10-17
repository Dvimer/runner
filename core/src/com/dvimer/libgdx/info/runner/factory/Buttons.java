package com.dvimer.libgdx.info.runner.factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.dvimer.libgdx.info.utils.MyButton;

/**
 * Created by dvime_000 on 13.10.2017.
 */
public class Buttons extends Group {
    private final static int WIDGHT_BUTTON = 20;
    private MyButton hpPotion;
    private MyButton mpPotion;
    private MyButton magic;
    private MyButton attack;
    private MyButton spell;

    public Buttons() {
        hpPotion = new MyButton(20, WIDGHT_BUTTON);
        mpPotion = new MyButton(120, WIDGHT_BUTTON);
        magic = new MyButton(Gdx.graphics.getWidth() / 2 - 40, WIDGHT_BUTTON);
        attack = new MyButton(620, WIDGHT_BUTTON);
        spell = new MyButton(720, WIDGHT_BUTTON);
        buttonInit();
    }

    private void hpPotionListener() {
        hpPotion.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }

    private void buttonInit() {
        addActor(hpPotion.getTitle());
        addActor(mpPotion.getTitle());
        addActor(magic.getTitle());
        addActor(attack.getTitle());
        addActor(spell.getTitle());
    }
}
