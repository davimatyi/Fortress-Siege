package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.mygdx.game.MyBaseClasses.Scene2D.MyStage;

/**
 * Created by tanulo on 2017. 10. 25..
 */

public class ControlStage extends MyStage {

    GameStage gameStage;
    Ballistics ballistics;
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



        //1-es röppálya gomb!!
        Button buttonV0_1;
        addActor(buttonV0_1 = new Button(game.getButtonStyleV0_1()));
        buttonV0_1.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                //Röppályákat tartalmazó tömb 0. elemére mutató változó
            }
        });
        buttonV0_1.setPosition(50, getViewport().getWorldHeight()-buttonV0_1.getWidth()-30);

        //2-es röppálya gomb!!
        Button buttonV0_2;
        addActor(buttonV0_2 = new Button(game.getButtonStyleV0_2()));
        buttonV0_2.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                //Röppályákat tartalmazó tömb 1. elemére mutató változó
            }
        });
        buttonV0_2.setPosition(buttonV0_1.getWidth()*2 , getViewport().getWorldHeight()-buttonV0_2.getHeight()-buttonV0_1.getHeight() );

        //Szükséges szög "gomb"
        Button buttonSzog;
        addActor(buttonSzog = new Button(game.getButtonStyleSzog()));
        buttonSzog.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                //Röppályákat tartalmazó tömb 1. elemére mutató változó
            }
        });
        buttonSzog.setPosition(0,0);

        //V0 változtató slider
        final Slider slider = new Slider(1,200, 1, false, game.getSliderStyle());
        slider.setValue(100);
        slider.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //slider_ertek = ((Slider)actor).getValue();
                //System.out.println(((Slider)actor).getValue() + " m/s");
                gameStage.setV0(slider.getValue());
            }
        });
        slider.setPosition(getViewport().getWorldWidth()/2-200, getViewport().getWorldHeight()-50);
        slider.setSize(600,20);
        //slider.setValue(100);
        addActor(slider);




    }



    @Override
    public void init() {

    }
}
