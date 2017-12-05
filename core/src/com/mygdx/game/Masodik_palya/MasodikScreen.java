package com.mygdx.game.Masodik_palya;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.audio.Music;
import com.mygdx.game.FortressSiege;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.Scene2D.MyScreen;
import com.mygdx.game.Stage.GameStage;

/**
 * Created by tanulo on 2017. 12. 04..
 */

public class MasodikScreen extends MyScreen {
    com.mygdx.game.Stage.GameStage gameStage;
    com.mygdx.game.Stage.ControlStage controlStage;
    Music sound = Assets.manager.get(Assets.HATTER_SOUND);

    //Texture hatter = Assets.manager.get(Assets.BACKGROUND_TEXTURE);
    //SpriteBatch spriteBatch = new SpriteBatch();

    public MasodikScreen(FortressSiege game) {
        super(game);
        setBackGroundColor(0.5f, 0.2f,0f);
        gameStage = new GameStage(spriteBatch, game);
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
