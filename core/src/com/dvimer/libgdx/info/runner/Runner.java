package com.dvimer.libgdx.info.runner;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.dvimer.libgdx.info.runner.screen.TitleScreen;

/**
 * Created by dvime_000 on 02.10.2017.
 */
public class Runner extends Game {
    public static final int WIDGHT = 800;
    public static final int HIGHT = 640;
    static public Skin gameSkin;
    private Player player;

    @Override
    public void create() {
//        this.player = new Player();
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
}
