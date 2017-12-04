package com.mygdx.game.Actor;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;

/**
 * Created by tanulo on 2017. 11. 29..
 */

public class VarTopActor extends OneSpriteStaticActor {

    public VarTopActor(Texture texture) {
        super(texture);
        setSize(2.5f, 1.1f);
        setPosition(-0.2f, 4.3f);
    }
}
