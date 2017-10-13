package com.dvimer.libgdx.info.runner;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.dvimer.libgdx.info.runner.factory.Labels;
import com.dvimer.libgdx.info.utils.MyLabel;

/**
 * Created by dvime_000 on 02.10.2017.
 */
public class Runner extends Game {
    public static final int WIDGHT = 800;
    public static final int HIGHT = 640;
    public static Texture BASE_TEXTURE;

    private Stage stage;
    private SpriteBatch batch;

    private Player player;
    private Array<Monster> monsters;
    private Chest spoil;
    private Ground ground;

    private Texture textureGround;
    private Labels labels;


    @Override
    public void create() {
        this.BASE_TEXTURE = new Texture(Gdx.files.internal("tartil.png"));
        this.textureGround = new Texture(Gdx.files.internal("ground.png"));
        this.batch = new SpriteBatch();
        this.stage = new Stage(new ScreenViewport(), batch);

        gameInit();
        addStage();

        player.events.subscribe("hp", labels.getHpValue());
        player.events.subscribe("coin", labels.getCointValue());
    }

    private void addStage() {
        this.stage.addActor(player);
        for (Monster monster : monsters) {
            this.stage.addActor(monster);
        }

        labels.setStage(stage);
        stage.addActor(spoil);

    }

    public void gameInit() {
        this.player = new Player(0, 70);
        this.monsters = new Array<Monster>();

        for (int i = 1; i < 5; i++) {
            monsters.add(new Monster(i * 200, 70));
        }

        this.ground = new Ground(new TextureRegion(textureGround, 0, 0, 200, 200));
        this.spoil = new Chest(700, 70);
        this.labels = new Labels(player);
    }


    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

        for (Monster monster : monsters) {
            if (monster.getBounds().overlaps(player.getBounds())) {
                player.accept(monster);
            }
        }
        if (spoil.getBounds().overlaps(player.getBounds())) {
            player.accept(spoil);
        }
    }
}
