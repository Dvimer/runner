package com.dvimer.libgdx.info.runner.events;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by dvime_000 on 17.10.2017.
 */
public class SpellEvent extends ClickListener {
    @Override
    public void clicked(InputEvent event, float x, float y) {
        super.clicked(event, x, y);
        System.out.println("Скаствал рандомную хрень");
    }
}
