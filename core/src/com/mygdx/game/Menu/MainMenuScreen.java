package com.mygdx.game.Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.mygdx.game.FortressSiege;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.Scene2D.MyScreen;

/**
 * Created by tanulo on 2017. 11. 30..
 */

public class MainMenuScreen extends MyScreen {
    protected MainMenuStage mainMenuStage;
    public Music nature = Assets.manager.get(Assets.MENU_SOUND);

    public MainMenuScreen(FortressSiege game) {
        super(game);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        mainMenuStage.act(delta);
        mainMenuStage.draw();
    }

     @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        mainMenuStage.resize(width, height);
    }


    @Override
    public void dispose() {
        mainMenuStage.dispose();
        super.dispose();
    }

    @Override
    public void init() {

        mainMenuStage = new MainMenuStage(new ExtendViewport(Assets.SCREEN_WIDTH,Assets.SCREEN_HEIGHT,new OrthographicCamera(Assets.SCREEN_WIDTH,HEIGHT)), spriteBatch, game);
        Gdx.input.setInputProcessor(mainMenuStage);
        //rgb(0, 184, 230)
        //rgb(66, 98, 244)
        setBackGroundColor(0f, 0.31f, 1);

    }
}
