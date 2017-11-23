package com.mygdx.game.MyBaseClasses;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.GameStage;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.InfoLabelActor;
import com.mygdx.game.MyBaseClasses.Scene2D.MyActor;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteActor;
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
    static boolean elso1 = true, elso2 = true, elso3 = true;
    GameStage gameStage;
    static VarActor varActor;

    public VarActor(Texture texture, GameStage gameStage) {
        super(texture);
        setSize(2.52f, 3.5f);
        setPosition(0, 2f);
        this.gameStage = gameStage;
    }

    public void decLife(int damage){
        life -= damage;
        if(life<1 && elso3){
            //osszeomlik.play();
            setTexture(var3);
            elso3=false;
        } else if(life<334 && elso2){
            setTexture(var2);
            elso2=false;
        } else if(life<667 && elso1){
            setTexture(var1);
            elso1=false;
        }
    }

    @Override
    public void act(float delta){
    }

}
