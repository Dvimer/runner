package com.dvimer.libgdx.info.runner.events;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.dvimer.libgdx.info.runner.item.Player;

/**
 * Created by dvime_000 on 17.10.2017.
 */
public class HealEvent extends ClickListener {

    public Player player;
    public HealEvent(Player player) {
        this.player = player;

    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        super.clicked(event, x, y);
        this.player.heal();
    }
}
