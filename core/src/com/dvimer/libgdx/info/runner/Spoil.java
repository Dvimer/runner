package com.dvimer.libgdx.info.runner;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.dvimer.libgdx.info.runner.visiter.Visitor;

/**
 * Created by dvime_000 on 12.10.2017.
 */
public class Spoil extends GameObject implements Visitor {

    private int money;

    public Spoil(int x, int y) {
        super(new TextureRegion(Runner.BASE_TEXTURE, 32, 465, 300, 300));
        this.money = random.nextInt(100);
        setPosition(x, y);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }

    @Override
    public void act(float delta) {
        moveBy(-200 * delta, 0);
    }

    @Override
    public void visitPlayer(Player player) {
        int coin = random.nextInt(100);
        player.addCoin(coin);
        moveBy(random.nextInt(300),0);
    }
}
