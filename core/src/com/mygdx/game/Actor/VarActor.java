package com.mygdx.game.Actor;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Stage.GameStage;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.InfoLabelActor;
import com.mygdx.game.MyBaseClasses.Scene2D.MyStage;
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
    Texture var2Top = Assets.manager.get(Assets.VAR2_TOP_TEXTURE);
    Texture var3Top = Assets.manager.get(Assets.VAR3_TOP_TEXTURE);
    public static boolean elso1 = true, elso2 = true, elso3 = true, first=true, canSpawnNewRaven=false;
    static long deadTime= System.currentTimeMillis();
    GameStage gameStage;
    static VarActor varActor;
    VarTopActor varTopActor;
    MyStage myStage;


    public VarActor(Texture texture, GameStage gameStage, VarTopActor varTopActor) {


        super(texture);
        setSize(2.5f, 2.3f);
        setPosition(-0.2f, 2f);
        this.gameStage = gameStage;
        this.varTopActor = varTopActor;
    }

    public static float getLife() {
        return life;
    }

    public static void addHp(int hp){
        life+=hp;
        System.out.println(hp +" "+life);
    }

    public void decLife(float damage){
        life -= damage;
        //System.out.println("damage = " + damage);
        //System.out.println("life = " + life);

        if(life<1&&elso3){
            System.out.println("Vesztettél");
            osszeomlas.play();
            setTexture(var3);
            varTopActor.setTexture(var3Top);
            elso3=false;
            elso2=true;
            //System.exit(0);
            //myStage = (MyStage) getStage();
            //myStage.game.setScreen(mainMenuScreen);
        } else if(life<334&&elso2){
            if(isTextureChanged(var2))
                System.out.println("..");
            sebesules.play();
            setTexture(var2);
            varTopActor.setTexture(var2Top);
            elso2=false;
            elso1=true;
        } else if(life<667&&elso1){
            System.out.println("...");
            elso1=false;
            sebesules.play();
            setTexture(var1);
            varTopActor.setTexture(Assets.manager.get(Assets.CASTLE_TOP_TEXTURE));
        }
        else if(life>=667){
            setTexture(Assets.manager.get(Assets.CASTLE_TEXTURE));
            varTopActor.setTexture(Assets.manager.get(Assets.CASTLE_TOP_TEXTURE));
        }
    }

    public boolean isTextureChanged(Texture texture){
        return texture == this.getTexture();
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
            gameStage.addRaven(deadTime, canSpawnNewRaven);
            //System.out.println(deadTime + " " +canSpawnNewRaven);
        decLife(0);
    }

}
