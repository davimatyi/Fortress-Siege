package com.mygdx.game.MyBaseClasses;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.GameStage;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.InfoLabelActor;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;

/**
 * Created by Majzer on 27/10/2017.
 */

public class VarActor extends OneSpriteStaticActor {

    public InfoLabelActor infoLabelActor;
    static int life = 1000;
    //Sound osszeolik = Assets.manager.get(Assets.OSSZEOMLAS_SOUND);
    Texture var2 = Assets.manager.get(Assets.VAR2_TEXTURE);
    Texture var1 = Assets.manager.get(Assets.VAR1_TEXTURE);
    Texture var3 = Assets.manager.get(Assets.VAR3_TEXTURE);

    public VarActor(Texture texture) {
        super(texture);
        setSize(2.52f, 3.5f);
        setPosition(0, 2.1f);

    }

    public void decLife(int damage){
        life -= damage;
        if(life<1){
            //osszeomlik.play();
            getStage().getActors().removeValue(this, true);
            new VarActor(var3);
        } else if(life<334){
            getStage().getActors().removeValue(this, true);
            new VarActor(var2);
        } else if(life<667){
            getStage().getActors().removeValue(this, true);
            new VarActor(var1);
        }
    }
}
