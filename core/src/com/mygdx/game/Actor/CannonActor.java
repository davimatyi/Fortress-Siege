package com.mygdx.game.Actor;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;

/**
 * Created by tanulo on 2017. 12. 05..
 */

public class CannonActor extends OneSpriteStaticActor {
    public CannonActor(Texture texture, float x, float y) {
        super(texture);
        setX(x); setY(y);
        setSize(getWidth()/250,getHeight()/250);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
