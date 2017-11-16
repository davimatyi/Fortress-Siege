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
    Sound osszeolik = Assets.manager.get(Assets.OSSZEOMLAS_SOUND);
    Texture var3 = Assets.manager.get(Assets.VAR3_TEXTURE);
    Texture var2 = Assets.manager.get(Assets.VAR2_TEXTURE);
    Texture var1 = Assets.manager.get(Assets.VAR1_TEXTURE);

    public VarActor(Texture texture) {
        super(texture);
        setSize(1.80f, 3.60f);
        setPosition(0, 0.85f);

    }

    public void decLife(int damage){
        life -= damage;
        if(life<1){
            osszeolik.play();
        } else if(life<251){
            getStage().getActors().removeValue(this, true);
            new VarActor(var3);
        } else if(life<501){
            getStage().getActors().removeValue(this, true);
            new VarActor(var2);
        } else if(life<751){
            getStage().getActors().removeValue(this, true);
            new VarActor(var1);
        }
    }
}
