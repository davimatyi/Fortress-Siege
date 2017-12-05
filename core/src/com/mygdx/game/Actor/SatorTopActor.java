package com.mygdx.game.Actor;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;

/**
 * Created by tanulo on 2017. 11. 29..
 */

public class SatorTopActor extends OneSpriteStaticActor {

    public SatorTopActor(float x, float y) {
        super(Assets.manager.get(Assets.TENT_TOP_TEXTURE));
        setSize(1.43f, 1.0f);
        setPosition(x,y);
    }
}
