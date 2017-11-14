package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.DosActor;
import com.mygdx.game.MyBaseClasses.MySlider;
import com.mygdx.game.MyBaseClasses.Scene2D.MyStage;

/**
 * Created by tanulo on 2017. 10. 25..
 */

public class ControlStage extends MyStage {


    GameStage gameStage;
    float slider_ertek;


    public GameStage getGameStage() {
        return gameStage;
    }

    public float getSlider() {
        return slider_ertek;
    }

    public ControlStage(Batch batch, MyGdxGame game, final GameStage gameStage) {
        super(new ExtendViewport(1024,768), batch, game);
        this.gameStage = gameStage;
        gameStage.setControlStage(this);

        //V0 változtató slider
        final MySlider slider = new MySlider(1,50, 0.01f, false, game.getSliderStyle());
        slider.setValue(10);
        gameStage.setV0(slider.getValue());
        slider.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                //System.out.println(((Slider)actor).getValue() + " m/s");
                gameStage.setV0(slider.getValue());
            }
        });
        slider.setPosition(getViewport().getWorldWidth()/2-200, getViewport().getWorldHeight()-50);
        slider.setUnits("m/s");
        slider.setSize(600,20);
        addActor(slider);

        final MySlider speedSlider = new MySlider(0.01f, 1,0.001f, false,game.getSliderStyle());
        speedSlider.setValue(1);
        speedSlider.setUnits("x speed");
        gameStage.setTimeScale(speedSlider.getValue());
        speedSlider.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                gameStage.setTimeScale(speedSlider.getValue());
            }
        });
        speedSlider.setPosition(getViewport().getWorldWidth()/2-200, getViewport().getWorldHeight()-100);
        speedSlider.setSize(600,20);
        addActor(speedSlider);
        setCameraResetToLeftBottomOfScreen();
    }



    public Label.LabelStyle getLabelStyle() {
        Label.LabelStyle style;
        style = new com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle();
        style.font = Assets.manager.get(Assets.ARIAL_30_FONT);
        style.fontColor = Color.RED;
        return style;
    }




    @Override
    public void init() {

        final Label lblV0 = new Label("Kilövési sebesség", getLabelStyle());
        lblV0.setPosition(getViewport().getWorldWidth() / 2 - 475, getViewport().getWorldHeight() - 55);
        lblV0.setTouchable(Touchable.disabled);
        addActor(lblV0);
        final Label lblSpeed = new Label("Lejátszási sebesség", getLabelStyle());
        lblSpeed.setPosition(getViewport().getWorldWidth() / 2 - 475, getViewport().getWorldHeight() - 105);
        lblSpeed.setTouchable(Touchable.disabled);
        addActor(lblSpeed);
    }

}