package com.mygdx.game.MyBaseClasses;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.Ballistics;
import com.mygdx.game.ControlStage;
import com.mygdx.game.GameStage;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.InfoLabelActor;
import com.mygdx.game.Lagrange;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;
import com.mygdx.game.MyBaseClasses.Scene2D.ShapeType;

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


    //public static boolean letrehozta=true;

    public int vel(int a, int b) {
        return (int)Math.floor(Math.random()*(b-a+1)+a);
    }


    public KatonaActor(float x, float y, Lagrange lagrange, double v, byte level, GameStage gameStage) {
        super(Assets.manager.get(Assets.WALK_TEXTURE));
        setFps(16);
        this.v = v;
        //this.info = info;
        this.lagrange = lagrange;
        this.level=level;
        this.gameStage = gameStage;
        setSize(0.5f, 0.5f);
        setPosition(x - getWidth() / 2, y - getHeight() / 2);
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
        Assets.manager.get(Assets.HALAL_SOUND).play();
        setFps(0);
        dead=true;
        gameStage.addPoint(level*100);
        gameStage.addCoin(level);
        int point = gameStage.getPoint();
        int coin = gameStage.getCoin();
        System.out.println(point);
        System.out.println(coin);
        ControlStage.lblCoin.setText(coin+" arany");
        ControlStage.lblPoint.setText(point+" pont");
        if(point>=10000){
            System.out.println("Nyertél");
            System.exit(0);
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
                    mozoghat=false;
                    setFps(0);
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
