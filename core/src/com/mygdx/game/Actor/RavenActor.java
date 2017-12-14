package com.mygdx.game.Actor;

import com.badlogic.gdx.audio.Sound;
import com.mygdx.game.MyBaseClasses.Scene2D.MyStage;
import com.mygdx.game.Szamitasok.Ballistics;
import com.mygdx.game.Stage.ControlStage;
import com.mygdx.game.Stage.GameStage;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.Szamitasok.Lagrange;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;

/**
 * Created by tanulo on 2017. 11. 27..
 */

public class RavenActor extends OneSpriteAnimatedActor {


    Ballistics ballistics;
    GameStage gameStage;
    ControlStage controlStage;
    VarActor varActor;
    Lagrange lagrange;
    double v = 2;
    boolean dead = false, balra = true;
    byte level;
    Sound raven_sound = Assets.manager.get(Assets.HOLLO_SOUND);

    public RavenActor(float x, float y, Lagrange lagrange, double v, byte level, MyStage myStage, VarActor varActor) {
        super(Assets.manager.get(Assets.RAVEN_TEXTURE));
        setFps(20);
        this.v = v;
        //this.info = info;
        this.lagrange = lagrange;
        this.level = level;
        this.gameStage = gameStage;
        this.varActor=varActor;
        setSize(0.5f, 0.5f);
        setPosition(-5,-5);

    }

    public void dead(){
        dead=true;
        setFps(0);
        raven_sound.play();

        
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        /*
        if(balra) {
            setX(getX() - 0.02f);
            sprite.setFlip(false, false);
            if (getX()<=0){
                balra = false;
            }
        }
        else if(!dead)
        {
            setX(getX()+0.02f);
            sprite.setFlip(true, false);
            if(getX()>10.24f) {
                balra = true;
            }
        }

        if(dead){
            rotateBy(-10);
            setY(getY()-0.02f);
            varActor.deadTime= System.currentTimeMillis();
            if(getY()<=0){
                getStage().getActors().removeValue(this, true);
                varActor.setCanSpawnNewRaven(true);
            }
        }
        */

    }
}
