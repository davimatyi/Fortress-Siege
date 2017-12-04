package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.*;
import com.mygdx.game.MyBaseClasses.Game.MyGame;
import com.mygdx.game.MyBaseClasses.Scene2D.CloudActor;
import com.mygdx.game.MyBaseClasses.Scene2D.MyActor;
import com.mygdx.game.MyBaseClasses.Scene2D.MyStage;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import com.mygdx.game.UI.MyButton;

import java.util.Random;

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
    VarTopActor varTopActor;
    SatorTopActor satorTopActor;
    SatorActor satorActor;
    RavenActor ravenActor;
    HPActorFekete hpActorFekete;
    HPActorPiros hpActorPiros;
    CloudActor cloudActor;
    MyActor actor;
    float offsetX = 0.23f;
    float offsetY = 5.8f;
    float timeScale = 1;
    long ido1, ido2=0, idoKatona=System.currentTimeMillis();
    byte level = 1;
    static int point=0, coin=0;

    public static int getPoint() {
        return point;
    }

    public void addPoint(int point){this.point+=point;}

    public static int getCoin() {return coin;}

    public static int removeCoin(int coinminus){
        coin-=coinminus;
        System.out.println(coin);
        return coin;
    }

    public void addCoin(int coin){this.coin+=coin;}

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

    boolean isNextLevel(){
        return System.currentTimeMillis()-idoKatona>15000;
    }

    public void addRaven(long ido, boolean canSpawnNewRaven){
        //System.out.println(System.currentTimeMillis()+" "+ido + " " + (System.currentTimeMillis()-ido) + " " + canSpawnNewRaven);
        if(System.currentTimeMillis() - ido > 1000 && canSpawnNewRaven) {
            addActor(ravenActor=new RavenActor(10, (float)(new Random().nextInt(2)+5+new Random().nextDouble()), lagrange, 3, level, getGameStage(), varActor));
            VarActor.canSpawnNewRaven = false;

        }
    }

    public void addKatona(){
        //System.out.println("level = " + level);
        switch (level){
            case 1: {
                if(isNextLevel()){
                    level++;
                    idoKatona = System.currentTimeMillis();
                }
                addActor(new KatonaActor(0,0, lagrange, new Random().nextDouble()+4, level, getGameStage()));
                break;
            }
            case 2: {
                if(isNextLevel()){
                    level++;
                    idoKatona = System.currentTimeMillis();
                }
                addActor(new KatonaActor(0,0, lagrange, new Random().nextDouble()+3, level, getGameStage()));
                break;
            }
            case 3: {
                if(isNextLevel()){
                    level++;
                    idoKatona = System.currentTimeMillis();
                }
                addActor(new KatonaActor(0,0, lagrange, new Random().nextDouble()+2, level, getGameStage()));
                break;
            }
            case 4: {
                addActor(new KatonaActor(0, 0, lagrange, new Random().nextDouble()+1, level, getGameStage()));
            }
        }
        }


    public GameStage(final Batch batch, final FortressSiege game) {
        super(new ExtendViewport(10.24f,7.68f), batch, game);
        bg = new OneSpriteStaticActor(Assets.manager.get(Assets.BACKGROUND_TEXTURE));
        bg.setSize(((ExtendViewport)getViewport()).getMinWorldWidth(), ((ExtendViewport)getViewport()).getMinWorldHeight());
        lagrange = new Lagrange();
/*
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
        lagrange.addpoint(10.219999f, 2.6f);*/

        lagrange.addpoint(0.059999943, 1.91);
        lagrange.addpoint(0.26000023, 1.9899999);
        lagrange.addpoint(0.3800001, 2.1);
        lagrange.addpoint(0.6700001, 2.2199998);
        lagrange.addpoint(1.0999999, 2.3599997);
        lagrange.addpoint(1.4300001, 2.4199996);
        lagrange.addpoint(1.72, 2.4599998);
        lagrange.addpoint(2.1699998, 2.4899998);
        lagrange.addpoint(2.34, 2.4499998);
        lagrange.addpoint(2.61, 2.3999999);
        lagrange.addpoint(2.6699998, 2.3999999);
        lagrange.addpoint(3.03, 2.4299998);
        lagrange.addpoint(3.5099998, 2.5099998);
        lagrange.addpoint(4.23, 2.5699997);
        lagrange.addpoint(4.7599998, 2.62);
        lagrange.addpoint(5.23, 2.6599998);
        lagrange.addpoint(6.0899997, 2.7499995);
        lagrange.addpoint(6.33, 2.77);
        lagrange.addpoint(6.5899997, 2.7299998);
        lagrange.addpoint(6.8599997, 2.6699996);
        lagrange.addpoint(7.06, 2.6299996);
        lagrange.addpoint(7.16, 2.6299996);
        lagrange.addpoint(7.3199997, 2.6499999);
        lagrange.addpoint(7.5299997, 2.6699996);
        lagrange.addpoint(7.72, 2.7099998);
        lagrange.addpoint(7.97, 2.7199998);
        lagrange.addpoint(8.37, 2.7199998);
        lagrange.addpoint(8.87, 2.7099998);
        lagrange.addpoint(9.379999, 2.6799998);
        lagrange.addpoint(9.94, 2.6699996);
        lagrange.addpoint(10.16, 2.6599998);


        addActor(bg);
        addKatona();


        addActor(satorActor = new SatorActor(Assets.manager.get(Assets.TENT_TEXTURE)));
        addActor(satorTopActor = new SatorTopActor(Assets.manager.get(Assets.TENT_TOP_TEXTURE)));
        addActor(varTopActor = new VarTopActor(Assets.manager.get(Assets.CASTLE_TOP_TEXTURE)));
        addActor(varActor = new VarActor(Assets.manager.get(Assets.CASTLE_TEXTURE),getGameStage(),varTopActor));
        addActor(ravenActor=new RavenActor(10, 5, lagrange, 3, level, getGameStage(), varActor));
        addActor(hpActorFekete =new HPActorFekete(Assets.manager.get(Assets.HP_FEKETE_TEXTURE), varActor));
        addActor(hpActorPiros=new HPActorPiros(Assets.manager.get(Assets.HP_PIROS_TEXTURE)));

        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);

                KatonaActor katonaActor;

                    try {
                        //InfoLabelActor infoLabelActor;
                        //controlStage.addActor(infoLabelActor = new InfoLabelActor("Távolság: " + x + " m\n Magasság: "+y+" m \n Szög (1): "+round(new Ballistics(x - getOffsetX(), y - getOffsetY(), v0).getAnglesByDeg()[0])+"°°\n Szög (2): "+round(new Ballistics(x - getOffsetX(), y - getOffsetY(), v0).getAnglesByDeg()[1])+"°\n Sebesség: " + round(v0) +" m/s", x*100+50, y*100-100, game.getLabelStyle()));
                        ido1 = System.currentTimeMillis();
                        System.out.println(ido1);
                        if (ido1 - ido2 > 2000) {
                            addActor(new LovedekActor(new Ballistics(x - getOffsetX(), y - getOffsetY(), v0), 0, getGameStage(), varActor, satorActor, ravenActor, lagrange));
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
        });
        //setCameraResetToLeftBottomOfScreen();
        ExtendViewport v = (ExtendViewport)getViewport();

        //float f = (v.getWorldWidth() / v.getMinWorldWidth());
        //System.out.println(f);

        //setCameraMoveToXY(v.getWorldWidth()/2/f,v.getWorldHeight()/2,1/f,100000,100000);
        //setCameraZoomXY(v.getWorldWidth()/2/f,v.getWorldHeight()/2,1/f);
        fitWorldToWidth();


        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                System.out.println("lagrange.addpoint(" + x + ", " + y + ");");
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
    protected void resized() {
        super.resized();
        //ExtendViewport v = (ExtendViewport)getViewport();
        //float f = (v.getWorldWidth() / v.getMinWorldWidth());
        //setCameraMoveToXY(v.getWorldWidth()/2/f,v.getWorldHeight()/2,1/f,100000,100000);
        //setCameraZoomXY(v.getWorldWidth()/2/f,v.getWorldHeight()/2,1/f);
        fitWorldToWidth();
    }

    @Override
    public void init() {
        addActor(cloudActor = new CloudActor(0,getHeight()-Assets.manager.get(Assets.CLOUD_TEXTURE).getHeight()-120 ,170f*1.3f, 100f*1.3f,Assets.manager.get(Assets.CLOUD_TEXTURE)));
        addActor(cloudActor = new CloudActor(getWidth()-Assets.manager.get(Assets.CLOUD_TEXTURE).getWidth(), 0, 170f*1.3f , 100f*1.3f , Assets.manager.get(Assets.CLOUD_TEXTURE)));
        //addActor(cloudActor = new CloudActor(0, , 170f*1.3f , 100f*1.3f,Assets.manager.get(Assets.CLOUD_TEXTURE)));
        //addActor(cloudActor = new CloudActor(getWidth()-Assets.manager.get(Assets.CLOUD_TEXTURE).getWidth(), getHeight()-910,170f*1.3f, 100f*1.3f,Assets.manager.get(Assets.CLOUD_TEXTURE)));
    }
}
