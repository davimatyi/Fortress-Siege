package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.DemoLoading.LoadingScreen;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.Game.MyGame;

public class FortressSiege extends MyGame {

    public Slider.SliderStyle getSliderStyle(){
        Slider.SliderStyle sliderStyle = new Slider.SliderStyle();
        sliderStyle.knobDown = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.KNOB_TEXTURE)));
        sliderStyle.knobOver = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.KNOB_TEXTURE)));
        sliderStyle.knob = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.KNOB_TEXTURE)));
        sliderStyle.background = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.SLIDER_TEXTURE)));
        return sliderStyle;
    }

    public TextButton.TextButtonStyle btnHeal() {
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = Assets.manager.get(Assets.ARIAL_30_FONT);
        textButtonStyle.up = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.BTN_HEAL_TEXTURE)));
        textButtonStyle.over = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.BTN_HEAL_TEXTURE)));
        textButtonStyle.down = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.BTN_HEAL_DOWN_TEXTURE)));
        return textButtonStyle;
    }

    public TextButton.TextButtonStyle btnStart() {
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = Assets.manager.get(Assets.ARIAL_30_FONT);
        textButtonStyle.up = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.BTN_START_TEXTURE)));
        textButtonStyle.over = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.BTN_START_TEXTURE)));
        textButtonStyle.down = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.BTN_START_DOWN_TEXTURE)));
        return textButtonStyle;
    }

    public TextButton.TextButtonStyle btnExit() {
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = Assets.manager.get(Assets.ARIAL_30_FONT);
        textButtonStyle.up = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.BTN_EXIT_TEXTURE)));
        textButtonStyle.over = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.BTN_EXIT_TEXTURE)));
        textButtonStyle.down = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.BTN_EXIT_DOWN_TEXTURE)));
        return textButtonStyle;
    }

    public TextButton.TextButtonStyle btnTryAgain() {
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = Assets.manager.get(Assets.ARIAL_30_FONT);
        textButtonStyle.up = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.BTN_TRYAGAIN_TEXTURE)));
        textButtonStyle.over = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.BTN_TRYAGAIN_TEXTURE)));
        textButtonStyle.down = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.BTN_TRYAGAIN_DOWN_TEXTURE)));
        return textButtonStyle;
    }

    public Label.LabelStyle getLabelStyle() {
        Label.LabelStyle style;
        style = new com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle();
        style.font = Assets.manager.get(Assets.ARIAL_30_FONT);
        style.fontColor = Color.RED;
        return style;
    }

    @Override
    public void create () {
        Assets.prepare();
        setScreen(new LoadingScreen(this));
    }

}