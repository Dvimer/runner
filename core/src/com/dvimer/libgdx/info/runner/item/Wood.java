package com.dvimer.libgdx.info.runner.item;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.dvimer.libgdx.info.runner.Runner;

/**
 * Created by dvime_000 on 25.10.2017.
 */
public class Wood extends GameObject {

    public Wood(int x, int y) {
        super(new TextureRegion(new Texture(Gdx.files.internal("derevo.png"))));
        setPosition(x,y);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        moveBy(-100 * delta, 0);
        if (getX()<0-getWidth()){
            setX(Runner.WIDGHT + random.nextInt(250));
        }
    }
}
