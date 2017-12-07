package com.mygdx.game.Actor;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MainScreen;
import com.mygdx.game.Menu.MainMenuScreen;
import com.mygdx.game.Stage.GameStage;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.InfoLabelActor;
import com.mygdx.game.MyBaseClasses.Scene2D.MyStage;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import com.mygdx.game.Vege.VegeScreen;

/**
 * Created by Majzer on 27/10/2017.
 */

public class VarActor extends OneSpriteStaticActor {

    public InfoLabelActor infoLabelActor;
    float life = 1000;
    long ido1Katona, ido2Katona =System.currentTimeMillis(), ido1Raven, ido2Raven=System.currentTimeMillis();
    Sound osszeomlas = Assets.manager.get(Assets.OSSZEOMLAS_SOUND);
    Sound sebesules = Assets.manager.get(Assets.SEBESULES_SOUND);
    Sound trumpet_2 = Assets.manager.get(Assets.TROMBITA_2_SOUND);
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


    public VarActor(MyStage myStage, VarTopActor varTopActor) {


        super(Assets.manager.get(Assets.CASTLE_TEXTURE));
        setSize(2.5f, 2.3f);
        if(((GameStage)myStage).getPalya()==2){
            //-0.2f, 1.7f
            setPosition(-0.3f, 1.7f);
        }
        else{
            //-0.2f, 2f
            setPosition(-0.2f, 2f);
        }
        this.gameStage = (GameStage) myStage;
        this.varTopActor = varTopActor;
    }

    public float getLife() {
        return life;
    }

    public void addHp(int hp){
        life+=hp;
        System.out.println(hp +" "+life);
    }

    public void decLife(float damage){
        life -= damage;
        //System.out.println("damage = " + damage);
        //System.out.println("life = " + life);

        if(life<1){
            osszeomlas.play();
            setTexture(var3);
            varTopActor.setTexture(var3Top);
            trumpet_2.play();
            //System.exit(0);
           ((MyStage)getStage()).game.setScreen(new MainScreen(((GameStage) getStage()).game, ((GameStage) getStage()).getPalya()), false);
            //((MyStage)getStage()).game.setScreen(new MainScreen(((GameStage) getStage()).game, ((GameStage) getStage()).getPalya()+1), false);
        } else if(life<334){
            if(hang334){
                sebesules.play();
                hang334=false;
            }
            setTexture(var2);
            varTopActor.setTexture(var2Top);
        } else if(life<667){
            if(hang667){
                sebesules.play();
                hang667=false;
            }
            hang334=true;
            setTexture(var1);
            varTopActor.setTexture(Assets.manager.get(Assets.CASTLE_TOP_TEXTURE));
        }
        else if(life>=667){
            setTexture(Assets.manager.get(Assets.CASTLE_TEXTURE));
            varTopActor.setTexture(Assets.manager.get(Assets.CASTLE_TOP_TEXTURE));
            hang667=true;
        }
    }

    boolean hang667=true, hang334=true;

    int sebesulesHang(int db){
        db++;
        sebesules.play();
        return db;
    }

    public boolean isTextureChanged(Texture texture){
        return texture == this.getTexture();
    }

    @Override
    public void act(float delta){
        ido1Katona = System.currentTimeMillis();
        ido1Raven = System.currentTimeMillis();
        gameStage.nezoke();
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
