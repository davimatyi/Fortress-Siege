package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;

/**
 * Created by Majzer on 26/11/2017.
 */

public class SatorActor extends OneSpriteStaticActor {

    static float life=2000;

    public SatorActor(Texture texture) {
        super(texture);
        setSize(1.83f, 2.7f);
        setPosition(8.7f, 2.5f);
    }

     public void decLife(float damage){
         life -= damage;
         if(life<=0){
             System.out.println("Nyertél");
             System.exit(0);
         }
     }

}
