package com.dvimer.libgdx.info.runner.factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.dvimer.libgdx.info.runner.Player;
import com.dvimer.libgdx.info.utils.MyLabel;

/**
 * Created by dvime_000 on 13.10.2017.
 */
public class Labels extends Group{

    private Player player;
    private MyLabel hpTitle;
    private MyLabel mpTitle;
    private MyLabel mpValue;
    private MyLabel hpValue;
    private MyLabel cointTitle;
    private MyLabel cointValue;

    public Labels(Player player) {
        this.player = player;
        labelInit(player);
    }

    private void labelInit(Player player) {
        hpTitle = new MyLabel(20, Gdx.graphics.getHeight() - 50, "HP");
        hpValue = new MyLabel(60, Gdx.graphics.getHeight() - 50, player.getHp());
        mpTitle = new MyLabel(20, Gdx.graphics.getHeight() - 80, "MP");
        mpValue = new MyLabel(60, Gdx.graphics.getHeight() - 80, player.getCoin());
        cointTitle = new MyLabel(500, Gdx.graphics.getHeight() - 80, "COIN");
        cointValue = new MyLabel(570, Gdx.graphics.getHeight() - 80, "0");
        initLable();
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

    public MyLabel getCointTitle() {
        return cointTitle;
    }

    private void initLable(){

        addActor(hpTitle.getLabel());
        addActor(mpTitle.getLabel());
        addActor(hpValue.getLabel());
        addActor(mpValue.getLabel());
        addActor(cointValue.getLabel());
        addActor(cointTitle.getLabel());
    }
}
