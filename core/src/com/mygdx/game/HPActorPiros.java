package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import com.mygdx.game.MyBaseClasses.VarActor;

/**
 * Created by Majzer on 30/11/2017.
 */

public class HPActorPiros extends OneSpriteStaticActor {

    public HPActorPiros(Texture texture) {
        super(texture);
        setPosition(0.4f,1.2f);
        setSize(1.5f,0.1f);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        setSize(VarActor.getLife()/666.6f, 0.1f);
    }
}
