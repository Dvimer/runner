package com.dvimer.libgdx.info.runner.factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.dvimer.libgdx.info.runner.Player;
import com.dvimer.libgdx.info.utils.MyLabel;

/**
 * Created by dvime_000 on 13.10.2017.
 */
public class Labels {

    private Player player;
    private MyLabel hpTitle;
    private MyLabel mpTitle;
    private MyLabel mpValue;
    private MyLabel hpValue;
    private MyLabel cointValue;

    public Labels(Player player) {
        this.player = player;
        labelInit(player);
    }

    private void labelInit(Player player) {
        hpTitle = new MyLabel(20, Gdx.graphics.getHeight() - 50, "HP");
        mpTitle = new MyLabel(60, Gdx.graphics.getHeight() - 50, player.getHp());
        mpValue = new MyLabel(20, Gdx.graphics.getHeight() - 80, "MP");
        hpValue = new MyLabel(60, Gdx.graphics.getHeight() - 80, player.getCoin());
        cointValue = new MyLabel(500, Gdx.graphics.getHeight() - 80, "COIN");
    }

    public MyLabel getHpTitle() {
        return hpTitle;
    }

    public MyLabel getMpTitle() {
        return mpTitle;
    }

    public MyLabel getMpValue() {
        return mpValue;
    }

    public MyLabel getHpValue() {
        return hpValue;
    }

    public MyLabel getCointValue() {
        return cointValue;
    }

    public void setStage(Stage stage) {
        stage.addActor(hpTitle.getLabel());
        stage.addActor(mpTitle.getLabel());
        stage.addActor(hpValue.getLabel());
        stage.addActor(mpValue.getLabel());
        stage.addActor(cointValue.getLabel());
    }
}
