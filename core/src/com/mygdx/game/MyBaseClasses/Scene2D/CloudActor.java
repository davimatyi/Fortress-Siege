package com.mygdx.game.MyBaseClasses.Scene2D;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;

/**
 * Created by Martin on 2017.12.01..
 */

public class CloudActor extends OneSpriteStaticActor {

    boolean balra = true;

    public CloudActor(float x, float y,Texture texture) {
        super(texture);
        //setSize(2f, 4.5f);
        setPosition(x, y);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(!balra) {
            setX(getX() + 2f);
            //sprite.setFlip(false, false);
            if (getX()>=10.24f){
                balra = true;
            }
        }
        else if(balra)
        {
            setX(getX()-0.5f);
            //sprite.setFlip(true, false);
            if(getX()<=0f) {
                balra = false;
            }
        }
    }
}
