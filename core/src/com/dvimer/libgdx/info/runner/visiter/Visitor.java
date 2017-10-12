package com.dvimer.libgdx.info.runner.visiter;

import com.dvimer.libgdx.info.runner.Monster;
import com.dvimer.libgdx.info.runner.Player;
import com.dvimer.libgdx.info.runner.Spoil;

/**
 * Created by dvime_000 on 12.10.2017.
 */
public interface Visitor {
    void visitPlayer(Player player);
}
