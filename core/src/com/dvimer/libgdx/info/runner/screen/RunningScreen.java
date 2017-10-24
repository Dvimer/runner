package com.dvimer.libgdx.info.runner.screen;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.dvimer.libgdx.info.runner.Chest;
import com.dvimer.libgdx.info.runner.Monster;
import com.dvimer.libgdx.info.runner.Player;
import com.dvimer.libgdx.info.runner.Runner;
import com.dvimer.libgdx.info.runner.factory.ImageButtons;
import com.dvimer.libgdx.info.runner.factory.Labels;

public class RunningScreen implements Screen {

    private Stage stage;
    private Runner game;
    private SpriteBatch batch;

    private Player player;
    private Array<Monster> monsters;
    private Chest chest;

    private Labels labels;

    private ImageButtons buttons;

    public RunningScreen(Runner game) {
        this.game = game;
        this.player = game.getPlayer();
        this.monsters = game.getMonsters();
        this.labels = game.getLabels();
        this.chest = game.getChest();
        this.buttons = game.getImageButtons();

        this.batch = new SpriteBatch();
        this.stage = new Stage(new ScreenViewport(), batch);

        addStage();

        this.player.addLabels(labels);
    }

    private void addStage() {
        this.stage.addActor(player);
        for (Monster monster : monsters) {
            this.stage.addActor(monster);
        }
        stage.addActor(labels);
        stage.addActor(chest);
        stage.addActor(buttons);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

        if (player.isDead()) {
            player.reset();
            game.setScreen(new TitleScreen(game));
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
