package com.mygdx.game.MyBaseClasses;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.GameStage;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;

/**
 * Created by tanulo on 2017. 10. 26..
 */

public class DosActor extends OneSpriteStaticActor {

    GameStage  gameStage;

    public DosActor(Texture texture, float x, float y, GameStage gameStage) {
        super(texture);
        setSize(1.024f,0.768f);
        setPosition(x, y);
        this.gameStage = gameStage;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(getX() > 0) setX(getX()-1*elapsedTime*10);
        if(getX()<0) setX(0);
        if(getY() > 0) setY(getY()-1*elapsedTime*10);
        if(getY()<0) setY(0);
        if(getWidth()<gameStage.getViewport().getWorldWidth())
            setWidth(10.24f*elapsedTime*4);
        if(getHeight()<gameStage.getViewport().getWorldHeight())
            setHeight(7.68f*elapsedTime*4);
        if(3.0 < elapsedTime)  {
            getStage().getActors().removeValue(this, true);
        }
        Color c = getColor();
        sprite.setAlpha(1f-elapsedTime / 3f);

    }
}
