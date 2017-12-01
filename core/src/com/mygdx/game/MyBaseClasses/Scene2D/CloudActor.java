package com.mygdx.game.MyBaseClasses.Scene2D;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;

/**
 * Created by Martin on 2017.12.01..
 */

public class CloudActor extends OneSpriteStaticActor {

    public CloudActor(Texture texture) {
        super(texture);
        //setSize(2f, 4.5f);
        setPosition(0f, 0f);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        setX(getX()+0.1f);
    }
}
