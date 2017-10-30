package com.dvimer.libgdx.info.runner.item;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by dvime_000 on 12.10.2017.
 */
public class Chest extends GameObject {

    private Player player;

    public Chest(Player player, int x, int y) {
        super(new TextureRegion(new Texture(Gdx.files.internal("chest.png"))), x, y);
        this.player = player;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        moveBy(-200 * delta, 0);

        if (getBounds().overlaps(player.getBounds())) {
            player.addCoin(random.nextInt(75));
            moveBy(random.nextInt(1000), 0);
        }
    }
}
