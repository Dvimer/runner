package com.dvimer.libgdx.info.runner;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Array;
import com.dvimer.libgdx.info.runner.factory.ImageButtons;
import com.dvimer.libgdx.info.runner.factory.Labels;
import com.dvimer.libgdx.info.runner.item.*;
import com.dvimer.libgdx.info.runner.screen.TitleScreen;

/**
 * Created by dvime_000 on 02.10.2017.
 */
public class Runner extends Game {
    public static final int WIDGHT = 768;
    public static final int HIGHT = 640;
    public static final int WIDHT_PLAYER = 100;

    static public Skin gameSkin;
    public Player player;
    public Array<Monster> monsters;
    public Labels labels;
    public Chest chest;
    public ImageButtons imageButtons;
    public Array<Ground> grounds;
    public Background background;
    public Array<Wood> derevos;

    @Override
    public void create() {
        gameSkin = new Skin(Gdx.files.internal("skin/comic/skin/comic-ui.json"));
        this.background = new Background();
        this.player = new Player(0, WIDHT_PLAYER);
        this.labels = new Labels(player);

        this.monsters = new Array<Monster>();
        for (int i = 1; i < 5; i++) {
            monsters.add(new Monster(i * 200, WIDHT_PLAYER, player,"Monster" + i));
        }

        this.player.addLabels(labels);
        this.player.setMonsters(monsters);


        this.chest = new Chest(player, 700, WIDHT_PLAYER);
        imageButtons = new ImageButtons(player);

        this.derevos = new Array<Wood>();
        for (int i = 0; i < 5; i++) {
            derevos.add(new Wood(200 * i, WIDHT_PLAYER));
        }

        this.grounds = new Array<Ground>();
        for (int i = 0; i < 4; i++) {
            grounds.add(new Ground(256 * i, 0));
        }

        this.setScreen(new TitleScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
