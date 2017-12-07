package com.mygdx.game.Actor;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.Scene2D.MyStage;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import com.mygdx.game.Stage.GameStage;

/**
 * Created by tanulo on 2017. 11. 29..
 */

public class VarTopActor extends OneSpriteStaticActor {

    VarActor varActor;

    public VarTopActor(VarActor varActor, MyStage myStage) {
        super(Assets.manager.get(Assets.CASTLE_TOP_TEXTURE));
        this.varActor = varActor;
        setSize(2.5f, 1.1f);
        if(((GameStage)myStage).getPalya()==2)
            setPosition(-0.2f, 4f);
        else
        setPosition(-0.2f, 4.3f);
    }
}
