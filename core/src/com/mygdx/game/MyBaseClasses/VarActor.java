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
    static float life = 1000;
    long ido1Katona, ido2Katona =System.currentTimeMillis(), ido1Raven, ido2Raven=System.currentTimeMillis();
    Sound osszeomlas = Assets.manager.get(Assets.OSSZEOMLAS_SOUND);
    Sound sebesules = Assets.manager.get(Assets.SEBESULES_SOUND);
    Texture var2 = Assets.manager.get(Assets.VAR2_TEXTURE);
    Texture var1 = Assets.manager.get(Assets.VAR1_TEXTURE);
    Texture var3 = Assets.manager.get(Assets.VAR3_TEXTURE);
    static boolean elso1 = true, elso2 = true, elso3 = true, canSpawnNewRaven, first=true;
    GameStage gameStage;
    static VarActor varActor;

    public VarActor(Texture texture, GameStage gameStage) {
        super(texture);
        setSize(2.52f, 3.5f);
        setPosition(0, 2f);
        this.gameStage = gameStage;
    }

    public void decLife(float damage){
        life -= damage;
        //System.out.println("damage = " + damage);
        //System.out.println("life = " + life);
        if(life<1 && elso3){
            System.out.println("Vesztettél");
            osszeomlas.play();
            setTexture(var3);
            elso3=false;
            System.exit(0);
        } else if(life<334 && elso2){
            sebesules.play();
            setTexture(var2);
            elso2=false;
        } else if(life<667 && elso1){
            sebesules.play();
            setTexture(var1);
            elso1=false;
        }
    }

    @Override
    public void act(float delta){
        ido1Katona = System.currentTimeMillis();
        ido1Raven = System.currentTimeMillis();
        //System.out.println("ido1 = " + ido1);
        //System.out.println("ido2Katona = " + ido2Katona);
        //System.out.println("(ido1-ido2Katona) = " + (ido1-ido2Katona));
        if (ido1Katona - ido2Katona > 5000) {
            //System.out.println("Kész");
            gameStage.addKatona();
            ido2Katona = ido1Katona;
        }
        if(canSpawnNewRaven&&first){
            ido2Raven = System.currentTimeMillis();
            first=false;
        }
        if(ido1Raven - ido2Raven > 5000 && canSpawnNewRaven){
            gameStage.addRaven();
            first=true;
            ido2Raven = ido1Raven;
        }
    }

}
