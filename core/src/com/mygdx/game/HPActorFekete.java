package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import com.mygdx.game.MyBaseClasses.VarActor;

/**
 * Created by Majzer on 30/11/2017.
 */

public class HPActorFekete extends OneSpriteStaticActor{

    VarActor varActor;

    public HPActorFekete(Texture texture, VarActor varActor) {
        super(texture);
        this.varActor = varActor;
        setPosition(0.4f,1.2f);
        setSize(1.5f,0.1f);
    }

    @Override
    public void act(float delta) {
    }
}
