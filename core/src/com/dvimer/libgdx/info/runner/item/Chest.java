package com.dvimer.libgdx.info.runner.item;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.dvimer.libgdx.info.runner.Runner;
import com.dvimer.libgdx.info.runner.visiter.Visitor;

/**
 * Created by dvime_000 on 12.10.2017.
 */
public class Chest extends GameObject implements Visitor {

    private Player player;

    public Chest(Player player, int x, int y) {
        super(new TextureRegion(new Texture(Gdx.files.internal("chest.png"))));
        this.player = player;
        setPosition(x, y);
    }

    @Override
    public void act(float delta) {
        moveBy(-200 * delta, 0);

        if (getBounds().overlaps(player.getBounds())) {
            player.visit(this);
        }

    }

    @Override
    public void visitPlayer(Player player) {
        player.addCoin(random.nextInt(75));
        moveBy(random.nextInt(1000), 0);
    }
}
