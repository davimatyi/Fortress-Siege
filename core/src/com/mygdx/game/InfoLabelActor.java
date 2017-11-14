package com.mygdx.game;

import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;


/**
 * Created by tanulo on 2017. 10. 27..
 */

public class InfoLabelActor extends Label {

    private static final float MAGNIFY = 0.05f;
    private static final float FONT_SCALE = 0.7f;
    private float elapsedTime = 0f;

    public InfoLabelActor(String text, float x, float y, LabelStyle labelStyle) {
        super(text, labelStyle);
        setFontScale(FONT_SCALE);
        setPosition(x, y);
        setSize(450, 100);
        setAlignment(Align.left);
        setWrap(true);
        setVisible(true);
        setTouchable(Touchable.disabled);
        setColor(.9f, .9f, .9f, 1);
    }

    @Override
    public void act(float delta) {
        elapsedTime += delta;
        super.act(delta);
        setFontScale(FONT_SCALE + (float) Math.sin(elapsedTime * 5.0f) * MAGNIFY);
        if (elapsedTime>3){
            //getStage().getActors().removeValue(this, true);
        }
    }
}
