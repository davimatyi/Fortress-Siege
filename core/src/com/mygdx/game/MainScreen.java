package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.Scene2D.MyScreen;
import com.mygdx.game.Stage.GameStage;

/**
 * Created by Majzer on 22/10/2017.
 */

public class MainScreen extends MyScreen {

    com.mygdx.game.Stage.GameStage gameStage;
    com.mygdx.game.Stage.ControlStage controlStage;
    Music sound = Assets.manager.get(Assets.HATTER_SOUND);

    //Texture hatter = Assets.manager.get(Assets.BACKGROUND_TEXTURE);
    //SpriteBatch spriteBatch = new SpriteBatch();

    public MainScreen(FortressSiege game, int palya) {
        super(game);
        setBackGroundColor(0.5f, 0.2f,0f);
        gameStage = new GameStage(spriteBatch, game, palya);
        controlStage = new com.mygdx.game.Stage.ControlStage(spriteBatch, game, gameStage);
        sound.setVolume(0.4f);
        sound.setLooping(true);
        sound.play();
        InputMultiplexer im = new InputMultiplexer();
        im.addProcessor(controlStage);
        im.addProcessor(gameStage);
        gameStage.addBackEventStackListener();
        controlStage.addBackEventStackListener();
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
