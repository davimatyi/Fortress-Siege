package com.mygdx.game.Actor;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import com.mygdx.game.Actor.VarActor;

/**
 * Created by Majzer on 30/11/2017.
 */

public class HPActorFekete extends OneSpriteStaticActor{

    public HPActorFekete(VarActor varActor) {
        super(Assets.manager.get(Assets.HP_FEKETE_TEXTURE));
        setPosition(0.4f,1.2f);
        setSize(1.5f,0.1f);
    }

    public HPActorFekete(SatorActor satorActor){
        super(Assets.manager.get(Assets.HP_FEKETE_TEXTURE));
        setPosition(satorActor.getX()-satorActor.getWidth()/4,satorActor.getY()-0.4f);
        setSize(1.5f,0.1f);
    }

    @Override
    public void act(float delta) {
    }
}
