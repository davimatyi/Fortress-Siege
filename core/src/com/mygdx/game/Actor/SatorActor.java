package com.mygdx.game.Actor;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;

/**
 * Created by Majzer on 26/11/2017.
 */

public class SatorActor extends OneSpriteStaticActor {

    static float life=2000;

    public SatorActor(float x, float y) {
        super(Assets.manager.get(Assets.TENT_TEXTURE));
        setSize(1.43f, 1.0f);
        setPosition(x,y);
    }

     public void decLife(float damage){
         life -= damage;
         if(life<=0){
             System.out.println("Nyertél");
             System.exit(0);
         }
     }

}
