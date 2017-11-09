package com.mygdx.game.MyBaseClasses;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;

/**
 * Created by tanulo on 2017. 10. 26..
 */

public class DosActor extends OneSpriteStaticActor {


    public DosActor(Texture texture, float x, float y) {
        super(texture);
        setSize(102.4f,76.8f);
        setPosition(x, y);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(getX() > 0) setX(getX()-1*elapsedTime*10);
        if(getX()<0) setX(0);
        if(getY() > 0) setY(getY()-1*elapsedTime*10);
        if(getY()<0) setY(0);
        if(getWidth()<1024)
        setSize(102.4f*elapsedTime*4,76.8f*elapsedTime*4);
        if(3.0 < elapsedTime)  {
            getStage().getActors().removeValue(this, true);
        }

    }
}
