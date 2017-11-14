package com.mygdx.game.MyBaseClasses;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.GameStage;
import com.mygdx.game.InfoLabelActor;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;

/**
 * Created by Majzer on 27/10/2017.
 */

public class VarActor extends OneSpriteStaticActor {

    public InfoLabelActor infoLabelActor;

    public VarActor(Texture texture) {
        super(texture);
        setSize(1.80f, 3.60f);
        setPosition(0, 0.85f);

    }



    public void doAngry(GameStage gameStage){
        setElapsedTime(0);
        if (infoLabelActor == null){
            ((GameStage)getStage()).controlStage.addActor(infoLabelActor = new InfoLabelActor("Nem tudok olyan messze dobni!", 20,300, ((GameStage)getStage()).getLabelStyle()){
                @Override
                public void act(float delta) {
                    super.act(delta);
                    if (elapsedTime>2){
                        setVisible(false);
                    }
                }
            });
        }else{
            infoLabelActor.setVisible(true);
        }
        /*final Label label = new Label("Nem tudok olyan messze dobni!", gameStage.getLabelStyle()){
            public float elapsedTime= 0;
            @Override
            public void setVisible(boolean visible) {
                super.setVisible(visible);
                if (visible){
                    elapsedTime = 0;
                }
            }

            @Override
            public void act(float delta) {
                super.act(delta);
                elapsedTime += delta;
                if (elapsedTime>2f){
                    setVisible(false);
                }
            }
        };
        label.setPosition(0, 1);
        label.setHeight(1);
        label.setTouchable(Touchable.disabled);
        label.setVisible(true);
        gameStage.addActor(label);
        */
    }
}
