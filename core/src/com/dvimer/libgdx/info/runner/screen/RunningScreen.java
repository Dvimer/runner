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
    private SpriteBatch batch;

    private Player player;
    private Runner game;

    public RunningScreen(Runner game) {
        this.batch = new SpriteBatch();
        this.stage = new Stage(new ScreenViewport(), batch);

        this.game = game;
        this.player = game.getPlayer();
        this.stage.addActor(player);
        this.stage.addActor(game.getChest());
        for (Monster monster : game.getMonsters()) {
            this.stage.addActor(monster);
        }
        this.stage.addActor(game.getLabels());
        this.stage.addActor(game.getImageButtons());
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
