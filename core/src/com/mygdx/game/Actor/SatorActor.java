package com.mygdx.game.Actor;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MainScreen;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import com.mygdx.game.Stage.GameStage;
import com.mygdx.game.Vege.VegeScreen;

/**
 * Created by Majzer on 26/11/2017.
 */

public class SatorActor extends OneSpriteStaticActor {

    float life=2000;

    public SatorActor(float x, float y) {
        super(Assets.manager.get(Assets.TENT_TEXTURE));
        setSize(1.43f, 1.0f);
        setPosition(x,y);
    }

    public float getLife() {
        return life;
    }

    public void decLife(float damage){
         life -= damage;
        if(getStage()!=null){
         if(life<=0){
             if(((GameStage)(getStage())).getPalya()==2) {
                 ((GameStage)(getStage())).game.setScreen(new VegeScreen(((GameStage)(getStage())).game));
                 clear();
                 ((GameStage)(getStage())).dispose();
             }
             else if(((GameStage)(getStage())).getPalya()==1) {
                 ((GameStage)(getStage())).game.setScreen(new MainScreen(((GameStage)(getStage())).game, ((GameStage)(getStage())).getPalya()+1), false);
                 clear();
                 ((GameStage)(getStage())).dispose();
             }
         }
        }
     }

}
