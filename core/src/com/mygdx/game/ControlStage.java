package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.Scene2D.MyStage;

/**
 * Created by tanulo on 2017. 10. 25..
 */

public class ControlStage extends MyStage {


    GameStage gameStage;
    float slider_ertek;
    public static  Label lblCoin, lblPoint;


    public GameStage getGameStage() {
        return gameStage;
    }

    public float getSlider() {
        return slider_ertek;
    }

    public ControlStage(Batch batch, FortressSiege game, final GameStage gameStage) {
        super(new ExtendViewport(1024,768), batch, game);
        this.gameStage = gameStage;
        gameStage.setControlStage(this);

        //V0 változtató slider
     /*   final MySlider slider = new MySlider(1,50, 0.01f, false, game.getSliderStyle());
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
        setCameraResetToLeftBottomOfScreen(); */
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

        lblCoin = new Label("0 arany", getLabelStyle());
        lblCoin.setPosition(getViewport().getWorldWidth() - 150, getViewport().getWorldHeight() - 55);
        lblCoin.setTouchable(Touchable.disabled);
        addActor(lblCoin);
        lblPoint = new Label("0 pont", getLabelStyle());
        lblPoint.setPosition(getViewport().getWorldWidth() - 150, getViewport().getWorldHeight() - 105);
        lblPoint.setTouchable(Touchable.disabled);
        addActor(lblPoint);
    }

}