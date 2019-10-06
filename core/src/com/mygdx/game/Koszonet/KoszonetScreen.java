package com.mygdx.game.Koszonet;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.mygdx.game.FortressSiege;
import com.mygdx.game.Menu.MainMenuScreen;
import com.mygdx.game.MyBaseClasses.Scene2D.MyScreen;

/**
 * Created by tanulo on 2017. 12. 04..
 */

public class KoszonetScreen extends MyScreen {

    protected KoszonetStage koszonetStage;
    long ido = System.currentTimeMillis();

    public KoszonetScreen(FortressSiege game) {
        super(game);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        if(System.currentTimeMillis()-ido>2500){
            game.setScreen(new MainMenuScreen(game));
        }
        koszonetStage.act(delta);
        koszonetStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        koszonetStage.resize(width, height);
    }


    @Override
    public void dispose() {
        koszonetStage.dispose();
        super.dispose();
    }

    @Override
    public void init() {
        koszonetStage = new KoszonetStage(new ExtendViewport(Assets.SCREEN_WIDTH,Assets.SCREEN_HEIGHT,new OrthographicCamera(Assets.SCREEN_WIDTH,HEIGHT)), spriteBatch, game);
        Gdx.input.setInputProcessor(koszonetStage);
        //rgb(0, 184, 230)
        //rgb(66, 98, 244)
        setBackGroundColor(0,0,0);

    }
}
