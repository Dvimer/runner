package com.dvimer.libgdx.info.runner;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
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

    @Override
    public void create() {
        BASE_TEXTURE = new Texture(Gdx.files.internal("tartil.png"));
        this.player = new Player(0,WIDHT_PLAYER);
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

    public void setPlayer(Player player) {
        this.player = player;
    }
}
