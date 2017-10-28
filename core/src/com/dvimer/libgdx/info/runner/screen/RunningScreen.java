package com.dvimer.libgdx.info.runner.screen;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.dvimer.libgdx.info.runner.*;
import com.dvimer.libgdx.info.runner.item.Wood;
import com.dvimer.libgdx.info.runner.item.Ground;
import com.dvimer.libgdx.info.runner.item.Monster;

public class RunningScreen implements Screen {

    private Stage stage;
    private SpriteBatch batch;

    private Runner game;

    public RunningScreen(Runner game) {
        this.batch = new SpriteBatch();
        this.stage = new Stage(new ScreenViewport(), batch);

        this.game = game;
        this.stage.addActor(game.background);

        for (Ground groung : game.grounds){
            this.stage.addActor(groung);
        }

        for (Wood wood : game.derevos) {
            this.stage.addActor(wood);
        }

        this.stage.addActor(game.player);
        this.stage.addActor(game.chest);
        for (Monster monster : game.monsters) {
            this.stage.addActor(monster);
        }
        this.stage.addActor(game.labels);
        this.stage.addActor(game.imageButtons);

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

        if (game.player.isDead()) {
            game.player.reset();
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
