package com.mygdx.game.Actor;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;

/**
 * Created by Martin on 2017.12.01..
 */

public class CloudActor extends OneSpriteStaticActor {

    boolean balra = true;
    float speed=0;

    public CloudActor(float x, float y,float a,float b,Texture texture, float speed) {
        super(texture);
        setSize(a, b);
        setPosition(x, y);
        this.speed = speed;
    }



    @Override
    public void act(float delta) {
        super.act(delta);
        if(!balra) {
            setX(getX() + speed);
            //sprite.setFlip(false, false);
            if (getX()>=getStage().getWidth()-this.getWidth() ){
                balra = true;
        }
        }
        else if(balra)
        {
            setX(getX()-speed);
            //sprite.setFlip(true, false);
            if(getX()<=0f) {
                balra = false;
            }
        }
    }
}
