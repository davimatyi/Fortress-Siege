package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.DemoLoading.LoadingScreen;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.Game.MyGame;

public class MyGdxGame extends MyGame {

	public Button.ButtonStyle getButtonStyleV0_2() {
		Button.ButtonStyle ButtonStyle = new TextButton.TextButtonStyle();
		ButtonStyle.up = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.V0_BUTTON_2_TEXTURE)));
		ButtonStyle.over = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.V0_BUTTON_2_TEXTURE)));
		ButtonStyle.down = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.V0_BUTTONDOWN_2_TEXTURE)));
		return ButtonStyle;
	}

	public Button.ButtonStyle getButtonStyleV0_1() {
		Button.ButtonStyle ButtonStyle = new TextButton.TextButtonStyle();
		ButtonStyle.up = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.V0_BUTTON_1_TEXTURE)));
		ButtonStyle.over = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.V0_BUTTON_1_TEXTURE)));
		ButtonStyle.down = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.V0_BUTTONDOWN_1_TEXTURE)));
		return ButtonStyle;
	}

	public Button.ButtonStyle getButtonStyleSzog() {
		Button.ButtonStyle ButtonStyle = new TextButton.TextButtonStyle();
		ButtonStyle.up = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.SZOG_TEXTURE)));
		ButtonStyle.over = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.SZOG_TEXTURE)));
		ButtonStyle.down = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.SZOG_TEXTURE)));
		return ButtonStyle;
	}


	public TextButton.TextButtonStyle getTextButtonStyle() {
		TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
		textButtonStyle.font = Assets.manager.get(Assets.ARIAL_30_FONT);
		textButtonStyle.up = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.V0_BUTTON_1_TEXTURE)));
		textButtonStyle.over = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.V0_BUTTON_1_TEXTURE)));
		textButtonStyle.down = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.V0_BUTTONDOWN_1_TEXTURE)));
		return textButtonStyle;
	}



	public Slider.SliderStyle getSliderStyle(){
		Slider.SliderStyle sliderStyle = new Slider.SliderStyle();
		sliderStyle.knobDown = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.KNOB_TEXTURE)));
		sliderStyle.knobOver = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.KNOB_TEXTURE)));
		sliderStyle.knob = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.KNOB_TEXTURE)));
		sliderStyle.background = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.SLIDER_TEXTURE)));
		return sliderStyle;
	}



	@Override
	public void create () {
		Assets.prepare();
		setScreen(new LoadingScreen(this));
	}

}