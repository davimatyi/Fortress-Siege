package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.FortressSiege;

/**
 * Created by tanulo on 2017. 11. 30..
 */

public class DesktopLauncher169 {
    public static void main (String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.height = 720;
        config.width = 1280;
        new LwjglApplication(new FortressSiege(), config);
    }
}
