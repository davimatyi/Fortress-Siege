package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.*;
import com.mygdx.game.MyBaseClasses.Scene2D.MyActor;
import com.mygdx.game.MyBaseClasses.Scene2D.MyStage;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;

/**
 * Created by tanulo on 2017. 10. 25..
 */

public class GameStage extends MyStage {

    Ballistics ballistics;
    Lagrange lagrange;

    public void setControlStage(ControlStage controlStage) {
        this.controlStage = controlStage;
    }

    ControlStage controlStage;
    KatonaActor katonaActor;
    OneSpriteStaticActor bg;
    VarActor varActor;
    MyActor actor;
    float offsetX = 0.2f;
    float offsetY = 1.8f;
    float timeScale = 1;
    long ido1, ido2=0;

    public void setTimeScale(float timeScale) {
        this.timeScale = timeScale;
    }

    public float getOffsetX() {
        return offsetX;
    }

    public float getOffsetY() {
        return offsetY;
    }

    public GameStage getGameStage() {
        return this;
    }

    public void setV0(float v0) {
        this.v0 = v0;
    }


    float v0 = 10;
    int i = 0;

    public float round(float f){
        return ((float)((int)(f*10f)))/10f;
    }

    public GameStage(final Batch batch, final FortressSiege game) {
        super(new ExtendViewport(10.24f,7.68f), batch, game);
        bg = new OneSpriteStaticActor(Assets.manager.get(Assets.BACKGROUND_TEXTURE));
        bg.setSize(getViewport().getWorldWidth(), getViewport().getWorldHeight());
        lagrange = new Lagrange();
        //lagrange.addpoint(-1, 1.0499998f);
        lagrange.addpoint(0.07999992f, 1.9499998f);
        lagrange.addpoint(0.9000001f, 2.23f);
        lagrange.addpoint(2.0f, 2.5f);
        lagrange.addpoint(2.6799998f, 2.4199996f);
        lagrange.addpoint(3.27f, 2.4799995f);
        lagrange.addpoint(4.2999997f, 2.59f);
        lagrange.addpoint(5.25f,2.6999998f);
        lagrange.addpoint(6.1099997f, 2.77f);
        lagrange.addpoint(7.1499996f, 2.62f);
        lagrange.addpoint(7.67f, 2.6999998f);
        lagrange.addpoint(9.299999f, 2.6999998f);
        lagrange.addpoint(10.219999f, 2.6f);
        //lagrange.addpoint(12.219999f, 2.09998f);
        addActor(bg);
        addActor(new KatonaActor(0,0, lagrange,4));

        addActor( varActor = new VarActor(Assets.manager.get(Assets.CASTLE_TEXTURE),getGameStage()));

        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                for (Actor actor : getActors().toArray()) {
                    if(actor.toString().equals("KatonaActor")) i++;
                }
                if(i > 3) System.out.println("Nem rakhatsz le többet!");
                else {
                    KatonaActor katonaActor;

                    try {
                        //InfoLabelActor infoLabelActor;
                        //controlStage.addActor(infoLabelActor = new InfoLabelActor("Távolság: " + x + " m\n Magasság: "+y+" m \n Szög (1): "+round(new Ballistics(x - getOffsetX(), y - getOffsetY(), v0).getAnglesByDeg()[0])+"°°\n Szög (2): "+round(new Ballistics(x - getOffsetX(), y - getOffsetY(), v0).getAnglesByDeg()[1])+"°\n Sebesség: " + round(v0) +" m/s", x*100+50, y*100-100, game.getLabelStyle()));
                        ido1 = System.currentTimeMillis();
                        System.out.println(ido1);
                        if (ido1 - ido2 > 5000) {
                            addActor(new LovedekActor(new Ballistics(10.24f-x - getOffsetX(), y - getOffsetY(), v0), 1, getGameStage(), varActor));
                            ido2=ido1;
                        }


                        //addActor(new LovedekActor(new Ballistics(x - getOffsetX(), y - getOffsetY(), v0), 1, getGameStage()));

                    }
                    catch (Exception e)
                    {
                        System.out.println(e.toString());
                        katonaActor = null;
                    }

                }
                i=0;
            }
        });
        setCameraResetToLeftBottomOfScreen();


        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                System.out.println("x=" + x + "  y=" + y);
            }
        });
        setDebugAll(true);
    }

    public Label.LabelStyle getLabelStyle() {
        Label.LabelStyle style;
        style = new com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle();
        style.font = Assets.manager.get(Assets.ARIAL_30_FONT);
        style.fontColor = Color.WHITE;
        return style;
    }


    @Override
    public void init() {
    }
}
