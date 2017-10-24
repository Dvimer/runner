package com.dvimer.libgdx.info.runner;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Array;
import com.dvimer.libgdx.info.runner.events.HealEvent;
import com.dvimer.libgdx.info.runner.events.ManaEvent;
import com.dvimer.libgdx.info.runner.factory.ImageButtons;
import com.dvimer.libgdx.info.runner.factory.Labels;
import com.dvimer.libgdx.info.runner.screen.TitleScreen;

/**
 * Created by dvime_000 on 02.10.2017.
 */
public class Runner extends Game {
    public static final int WIDGHT = 800;
    public static final int HIGHT = 640;
    public static final int WIDHT_PLAYER = 100;

    public static Texture BASE_TEXTURE;

    static public Skin gameSkin;
    private Player player;
    private Array<Monster> monsters;
    private Labels labels;
    private Chest chest;
    private ImageButtons imageButtons;

    @Override
    public void create() {
        BASE_TEXTURE = new Texture(Gdx.files.internal("tartil.png"));
        this.player = new Player(0, WIDHT_PLAYER);
        this.labels = new Labels(player);
        this.player.addLabels(labels);

        this.monsters = new Array<Monster>();
        for (int i = 1; i < 5; i++) {
            monsters.add(new Monster(i * 200, WIDHT_PLAYER, player));
        }
        this.chest = new Chest(player, 700, WIDHT_PLAYER);
        imageButtons = new ImageButtons(new ManaEvent(player), new HealEvent(player));

        gameSkin = new Skin(Gdx.files.internal("skin/comic/skin/comic-ui.json"));
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

    public Player getPlayer() {
        return player;
    }

    public Array<Monster> getMonsters() {
        return monsters;
    }

    public Labels getLabels() {
        return labels;
    }

    public Chest getChest() {
        return chest;
    }

    public ImageButtons getImageButtons() {
        return imageButtons;
    }
}
