package com.dvimer.libgdx.info.runner;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.dvimer.libgdx.info.runner.visiter.Visitor;

/**
 * Created by dvime_000 on 12.10.2017.
 */
public class Chest extends GameObject implements Visitor {

    public Chest(int x, int y) {
        super(new TextureRegion(Runner.BASE_TEXTURE, 32, 465, 300, 300));
        setPosition(x, y);
    }

    @Override
    public void act(float delta) {
        moveBy(-200 * delta, 0);
    }

    @Override
    public void visitPlayer(Player player) {
        player.addCoin(random.nextInt(75));
        moveBy(random.nextInt(1000), 0);
    }
}
