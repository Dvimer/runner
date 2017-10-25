package com.dvimer.libgdx.info.runner.item;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by dvime_000 on 10.10.2017.
 */
public class Ground extends GameObject {

    public Ground(int x, int y) {
        super(new TextureRegion(new Texture("ground.png")));
        setPosition(x,y);
        setSize(getWidth()*5,getHeight()*5);
    }


    @Override
    public void act(float delta) {
        super.act(delta);
        moveBy(-100*delta,0);
        if (getX() <0 - getWidth()){
            setX(800f);
        }
    }
}
