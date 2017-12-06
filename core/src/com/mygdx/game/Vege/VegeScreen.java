package com.mygdx.game.Vege;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.mygdx.game.FortressSiege;
import com.mygdx.game.Menu.MainMenuScreen;
import com.mygdx.game.MyBaseClasses.Scene2D.MyScreen;

/**
 * Created by tanulo on 2017. 12. 04..
 */

public class VegeScreen extends MyScreen {

    protected VegeStage vegeStage;
    long ido = System.currentTimeMillis();
    boolean nyert;

    public VegeScreen(FortressSiege game, boolean nyert) {
        super(game);
        this.nyert = nyert;
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        if(System.currentTimeMillis()-ido>2500){
           game.dispose();
        }
        vegeStage.act(delta);
        vegeStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        vegeStage.resize(width, height);
    }


    @Override
    public void dispose() {
        vegeStage.dispose();
        super.dispose();
    }

    @Override
    public void init() {
        vegeStage = new VegeStage(new ExtendViewport(1280,720,new OrthographicCamera(1280,720)), spriteBatch, game, nyert);
        Gdx.input.setInputProcessor(vegeStage);
        //rgb(0, 184, 230)
        //rgb(66, 98, 244)
        setBackGroundColor(0,0,0);

    }
}