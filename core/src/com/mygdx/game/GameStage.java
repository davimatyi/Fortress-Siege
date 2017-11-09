package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.mygdx.game.MyBaseClasses.IBMActor;
import com.mygdx.game.MyBaseClasses.Scene2D.MyActor;
import com.mygdx.game.MyBaseClasses.Scene2D.MyStage;

/**
 * Created by tanulo on 2017. 10. 25..
 */

public class GameStage extends MyStage {

    Ballistics ballistics;
    ControlStage controlStage;
    IBMActor ibmActor;
    GameStage gameStage;
    MyActor actor;

    public GameStage getGameStage() {
        return gameStage;
    }

    public void setV0(float v0) {
        this.v0 = v0;
    }



        float v0 = 100;


    public GameStage(final Batch batch, final MyGdxGame game) {
        super(new ExtendViewport(1024,768), batch, game);
        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                IBMActor ibmActor;
                addActor(ibmActor = new IBMActor(x, y));
                addActor(new FloppyActor(new Ballistics(x,y,v0),0, ibmActor));
                addActor(new FloppyActor(new Ballistics(x,y,v0),1, ibmActor));

            }
        });




        //setDebugAll(true);
    }

    public void addDos(Actor actor) {
        addActor(actor);
    }

    @Override
    public void init() {

    }
}
