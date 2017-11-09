package com.mygdx.game;

import com.badlogic.gdx.audio.Sound;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.IBMActor;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import com.mygdx.game.MyBaseClasses.Scene2D.ShapeType;

/**
 * Created by tanulo on 2017. 10. 25..
 */

public class FloppyActor extends OneSpriteStaticActor {
    Sound sound = Assets.manager.get(Assets.STAR_SOUND);
    Sound soundXP = Assets.manager.get(Assets.XP_SOUND);


    IBMActor ibmActor;
    Ballistics ballistics;
    int indexOfAngles;


    public FloppyActor(Ballistics ballistics, int indexOfAngles, IBMActor ibmActor) {
        super(Assets.manager.get(Assets.FLOPPYDISK_TEXTURE));
        this.ballistics = ballistics;
        this.ibmActor = ibmActor;
        this.indexOfAngles = indexOfAngles;
        setSize(50,50);
    }


    @Override
    public void act(float delta) {
        super.act(delta);

        float[] pos = ballistics.getXYbyTime(elapsedTime,indexOfAngles);
        setPosition(pos[0]-getWidth()/2,pos[1]-getHeight()/2);
        rotateBy(-ballistics.getV0()*(1/getElapsedTime())); // pörgetés átállítása
        if (elapsedTime>ballistics.getTimeOfFlight(indexOfAngles)){
            getStage().getActors().removeValue(this, true);
            sound.play();
        }
        if(ibmActor.overlaps(ShapeType.Rectangle, this)){
            ibmActor.decLife();
            getStage().getActors().removeValue(this, true);
        }
    }
}
