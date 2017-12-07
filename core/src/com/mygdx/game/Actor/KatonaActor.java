package com.mygdx.game.Actor;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.MainScreen;
import com.mygdx.game.MyBaseClasses.Scene2D.MyStage;
import com.mygdx.game.Szamitasok.Ballistics;
import com.mygdx.game.Stage.ControlStage;
import com.mygdx.game.Stage.GameStage;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.InfoLabelActor;
import com.mygdx.game.Szamitasok.Lagrange;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;
import com.mygdx.game.MyBaseClasses.Scene2D.ShapeType;
import com.mygdx.game.Vege.VegeScreen;

import java.util.Random;

/**
 * Created by tanulo on 2017. 10. 26..
 */

public class KatonaActor extends OneSpriteAnimatedActor {

    InfoLabelActor info;

    Ballistics ballistics;
    GameStage gameStage;
    ControlStage controlStage;
    Lagrange lagrange;
    double v=2;
    boolean dead = false, mozoghat = true;
    byte level;
    int randomFps;


    //public static boolean letrehozta=true;

    public int vel(int a, int b) {
        return (int)Math.floor(Math.random()*(b-a+1)+a);
    }


    public KatonaActor(float x, float y, Lagrange lagrange, double v, byte level, MyStage myStage) {
        super(Assets.manager.get(Assets.WALK_TEXTURE));
        setFps(16);
        this.v = v;
        //this.info = info;
        this.lagrange = lagrange;
        this.level=level;
        this.gameStage = (GameStage) myStage;
        setSize(0.5f, 0.5f);
        setPosition(x - getWidth() / 2, y - getHeight() / 2);
        Random random = new Random();
        randomFps = random.nextInt(3)+15;
        //this.gameStage = gameStage;
        /*final Label lblMagassag = new Label("", gameStage.getLabelStyle()){

            public float elapsedTime= 0;

            @Override
            public void setVisible(boolean visible) {
                super.setVisible(visible);
                if (visible){
                    elapsedTime = 0;
                }
            }

            @Override
            public void act(float delta) {
                super.act(delta);
                elapsedTime += delta;
                if (elapsedTime>2f){
                    setVisible(false);
                }
            }
        };

        lblMagassag.setPosition(getX(),getY()-10);
        lblMagassag.setText("Magasság: "+getY());
        lblMagassag.setTouchable(Touchable.disabled);
        lblMagassag.setVisible(true);*/






        /*final Label lblTavolsag = new Label("", gameStage.getLabelStyle()){

            public float elapsedTime= 0;

            @Override
            public void setVisible(boolean visible) {
                super.setVisible(visible);
                if (visible){
                    elapsedTime = 0;
                }
            }

            @Override
            public void act(float delta) {
                super.act(delta);
                elapsedTime += delta;
                if (elapsedTime>2f){
                    setVisible(false);
                }
            }
        };
        lblTavolsag.setPosition(getX(),getY()-10);
        lblTavolsag.setText("Távolság: "+getX());
        lblTavolsag.setTouchable(Touchable.disabled);
        lblTavolsag.setVisible(true);
        gameStage.addActor(lblTavolsag);*/
    }


    public void halal(){
        Assets.manager.get(Assets.HALAL_SOUND).play(-100f);
        setFps(0);
        dead=true;
        int point=0;
        int coin=0;
            gameStage.addPoint(level*100);
            gameStage.addCoin(level);
            coin = gameStage.getCoin();
        gameStage.setLblCoin(coin+" gold");
        gameStage.setLblPoint(point+" point");
        coin = gameStage.getCoin();
        point = gameStage.getPoint();
        if(point>=7500){
            //System.exit(0);
            if(((GameStage) getStage()).getPalya()==2) {
                ((MyStage)getStage()).game.setScreen(new VegeScreen(((MyStage)getStage()).game));
                gameStage.clear();
            }
            else if(gameStage.getPalya()==1) {
                ((MyStage)getStage()).game.setScreen(new MainScreen(((GameStage) getStage()).game, ((GameStage) getStage()).getPalya()+1), false);
                gameStage.clear();
            }

        }
    }

/*
    public KatonaActor(float x, float y, final GameStage gameStage) {
        super(Assets.manager.get(Assets.IBM_TEXTURE));
        setSize(100, 100);
        setPosition(x - getWidth() / 2, y - getHeight() / 2);
        this.gameStage = gameStage;
    }
*/


    @Override
    public void act(float delta) {
        super.act(delta);
        for (Actor a :getStage().getActors()) {
            if (a instanceof VarActor){
                if(((VarActor)a).overlaps(ShapeType.Rectangle, this)){
                    setTextureAtlas(Assets.manager.get(Assets.PUNCH_TEXTURE));
                    mozoghat=false;
                    setFps(randomFps);
                    //System.out.println(getX());
                    if(getX()>2.46){
                        setX(getX()-0.01f);
                    }
                    else ((VarActor)a).decLife(level/4.5f);
                }
            }
        }
        if(mozoghat){
            setX(10.24f-elapsedTime/(float)v - getWidth()/2);

            if(gameStage.getPalya()!=3)
            setY(lagrange.getY(10.24f-elapsedTime/(float)v) - 0.03f);


        }

        if(dead){
            rotateBy(-3);
            if(getRotation()<=-90) getStage().getActors().removeValue(this, true);
        }


        //setSize(getWidth() + (float)Math.cos(elapsedTime*10)/40, getHeight() + (float)Math.sin(elapsedTime*10)/40);
     /*   if(!letrehozta) {
            getStage().getActors().removeValue(this, true);
            letrehozta = true;
        } */
    }


}
