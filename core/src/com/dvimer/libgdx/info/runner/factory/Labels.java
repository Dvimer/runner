package com.dvimer.libgdx.info.runner.factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.dvimer.libgdx.info.runner.item.Player;

/**
 * Created by dvime_000 on 13.10.2017.
 */
public class Labels extends Group{

    private MyLabel hpTitle;
    private MyLabel mpTitle;
    private MyLabel mpValue;
    private MyLabel hpValue;
    private MyLabel coinTitle;
    private MyLabel coinValue;

    public Labels(Player player) {
        labelInit(player);
    }

    private void labelInit(Player player) {
        hpTitle = new MyLabel(20, Gdx.graphics.getHeight() - 50, "HP");
        hpValue = new MyLabel(60, Gdx.graphics.getHeight() - 50, player.getHp());
        mpTitle = new MyLabel(20, Gdx.graphics.getHeight() - 80, "MP");
        mpValue = new MyLabel(60, Gdx.graphics.getHeight() - 80, player.getMp());
        coinTitle = new MyLabel(500, Gdx.graphics.getHeight() - 80, "COIN");
        coinValue = new MyLabel(570, Gdx.graphics.getHeight() - 80, player.getCoin());
        initLable();
    }

    public MyLabel getMpValue() {
        return mpValue;
    }

    public MyLabel getHpValue() {
        return hpValue;
    }

    public MyLabel getCoinValue() {
        return coinValue;
    }

    private void initLable(){

        addActor(hpTitle.getLabel());
        addActor(mpTitle.getLabel());
        addActor(hpValue.getLabel());
        addActor(mpValue.getLabel());
        addActor(coinValue.getLabel());
        addActor(coinTitle.getLabel());
    }
}
