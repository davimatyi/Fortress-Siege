package com.mygdx.game.MyBaseClasses;

import com.badlogic.gdx.graphics.Cursor;
import com.mygdx.game.Ballistics;
import com.mygdx.game.ControlStage;
import com.mygdx.game.GameStage;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.Lagrange;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteActor;
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

    public RavenActor(float x, float y, Lagrange lagrange, double v, byte level, GameStage gameStage, VarActor varActor) {
        super(Assets.manager.get(Assets.RAVEN_TEXTURE));
        setFps(20);
        this.v = v;
        //this.info = info;
        this.lagrange = lagrange;
        this.level = level;
        this.gameStage = gameStage;
        this.varActor=varActor;
        setSize(1, 1);
        setPosition(x,y);
    }

    public void dead(){
        dead=true;
        setFps(0);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(balra) {
            setX(getX() - 0.02f);
            sprite.setFlip(false, false);
            if (getX()<=0){
                balra = false;
            }
        }
        else
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
                VarActor.canSpawnNewRaven = true;
            }
        }

    }
}