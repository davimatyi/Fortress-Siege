package com.mygdx.game.Actor;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;

/**
 * Created by tanulo on 2017. 12. 05..
 */

public class CannonActor extends OneSpriteStaticActor {
    public CannonActor(float x, float y) {
        super(Assets.manager.get(Assets.CANNON_TEXTURE));
        setX(x); setY(y);
        setSize(getWidth()/275/1.5f,getHeight()/275/1.5f);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
