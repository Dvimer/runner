package com.dvimer.libgdx.info.runner.factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.dvimer.libgdx.info.utils.MyButton;
import com.dvimer.libgdx.info.utils.MyImageButton;

/**
 * Created by dvime_000 on 13.10.2017.
 */
public class ImageButtons extends Group {
    private final static int WIDGHT_BUTTON = 0;
    public final static Texture potionRed = new Texture(Gdx.files.internal("icons/potionRed.png"));
    public final static Texture potionBlue = new Texture(Gdx.files.internal("icons/potionBlue.png"));
    public final static Texture potionGreen = new Texture(Gdx.files.internal("icons/potionGreen.png"));
    public final static Texture scroll = new Texture(Gdx.files.internal("icons/scroll.png"));
    public final static Texture sword = new Texture(Gdx.files.internal("icons/sword.png"));
    public final static Texture upg_sword = new Texture(Gdx.files.internal("icons/upg_sword.png"));
    public final static Texture wand = new Texture(Gdx.files.internal("icons/wand.png"));
    public final static Texture upg_wand = new Texture(Gdx.files.internal("icons/upg_wand.png"));


    private MyImageButton hpPotion;
    private MyImageButton mpPotion;
    private MyImageButton magic;
    private MyImageButton attack;
    private MyImageButton spell;

    public ImageButtons() {

        hpPotion = new MyImageButton(0, WIDGHT_BUTTON, potionRed, potionGreen);
        mpPotion = new MyImageButton(70, WIDGHT_BUTTON, potionBlue, potionGreen);
        magic = new MyImageButton(Gdx.graphics.getWidth() / 2 - 40, WIDGHT_BUTTON, scroll);
        attack = new MyImageButton(580, WIDGHT_BUTTON, sword, upg_sword);
        spell = new MyImageButton(650, WIDGHT_BUTTON, wand,upg_wand);
        buttonInit();
    }


    private void buttonInit() {
        addActor(hpPotion.getButton());
        addActor(mpPotion.getButton());
        addActor(magic.getButton());
        addActor(attack.getButton());
        addActor(spell.getButton());
    }
}
