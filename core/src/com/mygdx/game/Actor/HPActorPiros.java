package com.mygdx.game.Actor;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import com.mygdx.game.Actor.VarActor;

/**
 * Created by Majzer on 30/11/2017.
 */

public class HPActorPiros extends OneSpriteStaticActor {

    VarActor varActor;

    public HPActorPiros(VarActor varActor) {
        super(Assets.manager.get(Assets.HP_PIROS_TEXTURE));
        setPosition(0.4f,1.2f);
        setSize(1.5f,0.1f);
        this.varActor = varActor;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        setSize(varActor.getLife()/666.6f, 0.1f);
    }
}
