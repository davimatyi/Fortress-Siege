package com.mygdx.game.DemoLoading;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.mygdx.game.GlobalClasses.*;
import com.mygdx.game.Koszonet.KoszonetScreen;
import com.mygdx.game.MyBaseClasses.Scene2D.MyScreen;
import com.mygdx.game.FortressSiege;


public class LoadingScreen extends MyScreen {


    public LoadingScreen(FortressSiege game) {
		super(game);
    }
	BitmapFont bitmapFont = new BitmapFont();

    @Override
	public void show() {
	    Assets.manager.finishLoading();
		Assets.load();
	}

	@Override
	public void render(float delta) {
		super.render(delta);

		spriteBatch.begin();
		bitmapFont.draw(spriteBatch,"Loading: " + Assets.manager.getLoadedAssets() + "/" + (Assets.manager.getQueuedAssets()+ Assets.manager.getLoadedAssets()) + " (" + ((int)(Assets.manager.getProgress()*100f)) + "%)", Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2);
		spriteBatch.end();
		if (Assets.manager.update()) {
			Assets.afterLoaded();
			game.setScreen(new KoszonetScreen(game));
		}
	}

	@Override
	public void dispose(){
		super.dispose();
	}

	@Override
	public void hide() {

	}

	@Override
	public void init() {
		setBackGroundColor(0f, 0f, 0f);
	}
}
