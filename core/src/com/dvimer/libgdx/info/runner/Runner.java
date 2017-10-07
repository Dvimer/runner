package com.dvimer.libgdx.info.runner;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
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
    private Monster monster;
    private Texture texture;
    private SpriteBatch batch;
    private Charachter character;
    private MyLabel myLabel;


    @Override
    public void create() {
        this.texture = new Texture(Gdx.files.internal("tartil.png"));
        this.batch = new SpriteBatch();
        this.stage = new Stage(new ScreenViewport(), batch);

        this.character = new Charachter();
        this.stage.addActor(character);

        this.player = new Player(new TextureRegion(texture, 32, 465, 300, 300));
        this.player.setPosition(0, 0);
        this.stage.addActor(player);

        this.monster = new Monster(new TextureRegion(texture, 369, 465, 300, 300));
        this.monster.setPosition(400, 0);
        this.stage.addActor(monster);

        this.myLabel = new MyLabel(stage);

    }

    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

        monster.moveBy(-3, 0);
        if (monster.getPolygon().overlaps(player.getPolygon())) {
            monster.moveBy(40, 0);
            player.getDamage(monster);
            monster.getDamage(player);
            if (monster.getHp() <= 0) {
                monster.moveBy(800,0);
                monster.setHp(100);
            }
        }
    }


}
