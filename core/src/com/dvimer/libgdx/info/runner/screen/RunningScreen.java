package com.dvimer.libgdx.info.runner.screen;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.dvimer.libgdx.info.runner.*;
import com.dvimer.libgdx.info.runner.buttons.HealEvent;
import com.dvimer.libgdx.info.runner.buttons.ManaEvent;
import com.dvimer.libgdx.info.runner.factory.ImageButtons;
import com.dvimer.libgdx.info.runner.factory.Labels;

public class RunningScreen implements Screen {
    public static final int WIDHT_PLAYER = 100;

    private Stage stage;
    private Runner game;
    private SpriteBatch batch;

    private Player player;
    private Array<Monster> monsters;
    private Chest chest;
    private Ground ground;

    private Texture textureGround;
    private Labels labels;

    private ImageButtons buttons;

    private HealEvent healEvent;
    private ManaEvent manaEvent;

    public RunningScreen(Runner game) {
        this.game = game;
        this.player = game.getPlayer();
        this.textureGround = new Texture(Gdx.files.internal("ground.png"));
        this.batch = new SpriteBatch();
        this.stage = new Stage(new ScreenViewport(), batch);


        gameInit();
        addStage();

        player.events.subscribe("hp", labels.getHpValue());
        player.events.subscribe("mp", labels.getMpValue());
        player.events.subscribe("coin", labels.getCointValue());
    }

    public void gameInit() {
//        this.player = new Player(0, WIDHT_PLAYER);
        this.monsters = new Array<Monster>();

        for (int i = 1; i < 5; i++) {
            monsters.add(new Monster(i * 200, WIDHT_PLAYER));
        }

        this.ground = new Ground(new TextureRegion(textureGround, 0, 0, 200, 200));
        this.chest = new Chest(700, WIDHT_PLAYER);
        this.labels = new Labels(player);
        this.manaEvent = new ManaEvent(player);
        this.healEvent = new HealEvent(player);
        this.buttons = new ImageButtons(healEvent, manaEvent);
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

        for (Monster monster : monsters) {
            if (monster.getBounds().overlaps(player.getBounds())) {
                player.accept(monster);
                if (player.isDead()){
                    player.reset();
                    game.setScreen(new TitleScreen(game));
                }
            }
        }
        if (chest.getBounds().overlaps(player.getBounds())) {
            player.accept(chest);
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
