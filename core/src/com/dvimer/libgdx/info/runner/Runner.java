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
import com.dvimer.libgdx.info.utils.MyLabel;

/**
 * Created by dvime_000 on 02.10.2017.
 */
public class Runner extends Game {
    public static final int WIDGHT = 800;
    public static final int HIGHT = 640;

    private Stage stage;
    private Player player;
    private Array<Monster> monsters;
    private Spoil spoil;

    public static Texture BASE_TEXTURE;

    private Texture textureGround;
    private Ground ground;

    private SpriteBatch batch;
    private MyLabel labelHp;
    private MyLabel labelMp;
    private MyLabel countHp;
    private MyLabel countMp;


    @Override
    public void create() {
        this.BASE_TEXTURE = new Texture(Gdx.files.internal("tartil.png"));
        this.textureGround = new Texture(Gdx.files.internal("ground.png"));
        this.batch = new SpriteBatch();
        this.stage = new Stage(new ScreenViewport(), batch);

        gameInit();

        this.labelHp = new MyLabel(20, Gdx.graphics.getHeight() - 50, "HP");
        this.labelMp = new MyLabel(20, Gdx.graphics.getHeight() - 80, "MP");
        this.countHp = new MyLabel(60, Gdx.graphics.getHeight() - 50, player.getHp());
        this.countMp = new MyLabel(60, Gdx.graphics.getHeight() - 80, player.getCoin());

        addStage();
        player.events.subscribe("hp", countHp);
        player.events.subscribe("coin",countMp);
    }

    private void addStage() {
        this.stage.addActor(player);
        for (Monster monster : monsters) {
            this.stage.addActor(monster);
        }

        stage.addActor(labelHp.getLabel());
        stage.addActor(labelMp.getLabel());
        stage.addActor(countHp.getLabel());
        stage.addActor(countMp.getLabel());
        stage.addActor(spoil);

    }

    public void gameInit() {
        this.player = new Player(0, 70);
        this.monsters = new Array<Monster>();

        for (int i = 1; i < 5; i++) {
            monsters.add(new Monster(i * 100, 70));
        }

        MoveToAction moveAction = new MoveToAction();
        moveAction.setPosition(0f, 0f);
        moveAction.setDuration(2f);
        for (Monster monster : monsters) {
            monster.addAction(moveAction);
        }

        this.ground = new Ground(new TextureRegion(textureGround, 0, 0, 200, 200));

        this.spoil = new Spoil(700, 70);
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
