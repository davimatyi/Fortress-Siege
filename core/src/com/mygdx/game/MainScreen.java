package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.audio.Sound;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.Scene2D.MyScreen;

/**
 * Created by Majzer on 22/10/2017.
 */

public class MainScreen extends MyScreen {

    GameStage gameStage;
    ControlStage controlStage;
    Sound sound = Assets.manager.get(Assets.HATTER_SOUND);

    //Texture hatter = Assets.manager.get(Assets.BACKGROUND_TEXTURE);
    //SpriteBatch spriteBatch = new SpriteBatch();

    public MainScreen(FortressSiege game) {
        super(game);
        setBackGroundColor(0.5f, 0.2f,0f);
        gameStage = new GameStage(spriteBatch, game);
        controlStage = new ControlStage(spriteBatch, game, gameStage);
        sound.setVolume(1, -100f);
        sound.loop();
        InputMultiplexer im = new InputMultiplexer();
        im.addProcessor(controlStage);
        im.addProcessor(gameStage);
        Gdx.input.setInputProcessor(im);

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        //spriteBatch.begin();
        //spriteBatch.draw(hatter,0,0);
        //spriteBatch.end();
        gameStage.act(delta);
        gameStage.draw();
        controlStage.act(delta);
        controlStage.draw();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        gameStage.resize(width, height);
        controlStage.resize(width, height);
    }

    @Override
    public void init() {

    }
}
