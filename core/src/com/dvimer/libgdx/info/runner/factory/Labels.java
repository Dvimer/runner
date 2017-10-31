package com.dvimer.libgdx.info.runner.factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.dvimer.libgdx.info.runner.item.Player;

/**
 * Created by dvime_000 on 13.10.2017.
 */
public class Labels extends Group {

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
        hpTitle = new MyLabel("HP", 20, Gdx.graphics.getHeight() - 50);
        hpValue = new MyLabel(player.getHp(), 60, Gdx.graphics.getHeight() - 50);
        mpTitle = new MyLabel("MP", 20, Gdx.graphics.getHeight() - 80);
        mpValue = new MyLabel(player.getMp(), 60, Gdx.graphics.getHeight() - 80);
        coinTitle = new MyLabel("COIN", 500, Gdx.graphics.getHeight() - 80);
        coinValue = new MyLabel(player.getCoin(), 580, Gdx.graphics.getHeight() - 80);
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

    private void initLable() {

        addActor(hpTitle);
        addActor(mpTitle);
        addActor(hpValue);
        addActor(mpValue);
        addActor(coinValue);
        addActor(coinTitle);
    }
}
