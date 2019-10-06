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

    public VegeScreen(FortressSiege game) {
        super(game);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        //System.out.println(System.currentTimeMillis()-ido);
        if(System.currentTimeMillis()-ido>5000){
            game.setScreen(new MainMenuScreen(game));
           dispose();
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
        vegeStage = new VegeStage(new ExtendViewport(Assets.SCREEN_WIDTH,Assets.SCREEN_HEIGHT,new OrthographicCamera(Assets.SCREEN_WIDTH,HEIGHT)), spriteBatch, game);
        Gdx.input.setInputProcessor(vegeStage);
        //rgb(0, 184, 230)
        //rgb(66, 98, 244)
        setBackGroundColor(0f, 0.31f, 1);

    }
}
