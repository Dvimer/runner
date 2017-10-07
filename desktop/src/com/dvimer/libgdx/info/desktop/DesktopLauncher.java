package com.dvimer.libgdx.info.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.dvimer.libgdx.info.runner.Runner;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = Runner.WIDGHT;
        config.height = Runner.HIGHT;
        new LwjglApplication(new Runner(), config);
    }
}
