package com.mygdx.game.Actor;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.Scene2D.MyStage;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import com.mygdx.game.Stage.GameStage;

/**
 * Created by tanulo on 2017. 12. 05..
 */

public class CannonActor extends OneSpriteStaticActor {
    public CannonActor(MyStage myStage) {
        super(Assets.manager.get(Assets.CANNON_TEXTURE));
        if(((GameStage)myStage).getPalya()==2)
            setPosition(0.55999994f, 4.3569f);
        else
        setPosition(0.55999994f, 4.6599994f);
        setSize(getWidth()/275/1.5f,getHeight()/275/1.5f);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
