package com.dvimer.libgdx.info.runner;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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
    public static Texture BASE_TEXTURE;
    private SpriteBatch batch;
    private MyLabel labelHp;
    private MyLabel labelMp;
    private MyLabel countHp;
    private MyLabel countMp;

    @Override
    public void create() {
        this.BASE_TEXTURE = new Texture(Gdx.files.internal("tartil.png"));
        player = new Player(0, 0);
        this.batch = new SpriteBatch();
        this.stage = new Stage(new ScreenViewport(), batch);
        this.labelHp = new MyLabel(20, Gdx.graphics.getHeight() - 50, "HP");
        this.labelMp = new MyLabel(20, Gdx.graphics.getHeight() - 80, "MP");
        this.countHp = new MyLabel(60, Gdx.graphics.getHeight() - 50, player.getHp());
        this.countMp = new MyLabel(60, Gdx.graphics.getHeight() - 80, player.getMp());

        gameInit();
        addStage();
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
    }

    public void gameInit() {
        this.player = new Player(0, 0);

        this.monsters = new Array<Monster>();

        for (int i = 1; i < 5; i++) {
            monsters.add(new Monster(i * 100, 0));
        }

        MoveToAction moveAction = new MoveToAction();
        moveAction.setPosition(0f, 0f);
        moveAction.setDuration(2f);
        for (Monster monster : monsters) {
            monster.addAction(moveAction);
        }

    }


    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

        for (Monster monster : monsters) {
            if (monster.getBounds().overlaps(player.getBounds())) {
                monster.moveBy(40, 0);
                player.getDamage(monster);
                monster.getDamage(player);
                countHp.updateText(player.getHp());
                if (monster.getHp() <= 0) {
                    monster.moveBy(800, 0);
                    monster.setHp(100);
                }
            }
        }

    }


}
