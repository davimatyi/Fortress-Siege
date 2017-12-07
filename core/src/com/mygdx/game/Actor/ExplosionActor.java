package com.mygdx.game.Actor;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;

/**
 * Created by tuskeb on 2016. 09. 30..
 */
public class ExplosionActor extends OneSpriteAnimatedActor {
    public ExplosionActor() {
        //super("explosion.atlas");
        super(Assets.manager.get(Assets.EXPLOSION_TEXTURE));
        setFps(20);

        addListener(new ClickListener()
        {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                running = !running;
            }
        });
    }

    @Override
    protected void repeated() {
        if (getStage()!=null) {
            getStage().getActors().removeValue(this, true);
        }
        super.repeated();
    }
}
