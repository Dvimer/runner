package com.dvimer.libgdx.info.runner.factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.dvimer.libgdx.info.utils.MyButton;

/**
 * Created by dvime_000 on 13.10.2017.
 */
public class Buttons extends Group {
    private final static int WIDGHT_BUTTON = 20;
    private MyButton hpPotion;
    private MyButton mpPotion;
    private MyButton magic;
    private MyButton attacke;
    private MyButton spell;

    public Buttons() {
        hpPotion = new MyButton(20, WIDGHT_BUTTON);
        mpPotion = new MyButton(120, WIDGHT_BUTTON);
        magic = new MyButton(Gdx.graphics.getWidth() / 2 - 40, WIDGHT_BUTTON);
        attacke = new MyButton(620, WIDGHT_BUTTON);
        spell = new MyButton(720, WIDGHT_BUTTON);
        buttonInit();
    }


    private void buttonInit() {
        addActor(hpPotion.getTitle());
        addActor(mpPotion.getTitle());
        addActor(magic.getTitle());
        addActor(attacke.getTitle());
        addActor(spell.getTitle());
    }
}
