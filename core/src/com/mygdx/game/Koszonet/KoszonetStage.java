package com.mygdx.game.Koszonet;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.FortressSiege;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.Scene2D.CloudActor;
import com.mygdx.game.MyBaseClasses.Scene2D.MyStage;
import com.mygdx.game.UI.MyButton;

/**
 * Created by tanulo on 2017. 12. 04..
 */

public class KoszonetStage extends MyStage {

    public static Label lbl;

    public KoszonetStage(Viewport viewport, Batch batch, FortressSiege game) {
        super(viewport, batch, game);
    }

    public Label.LabelStyle getLabelStyle() {
        Label.LabelStyle style;
        style = new com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle();
        style.font = Assets.manager.get(Assets.MEDIEVAL_30_FONT);
        style.fontColor = Color.WHITE;
        return style;
    }

    @Override
    public void init() {
        lbl = new Label("Köszönet szüleinknek akik nélkül ez nem jöhetett volna létre", getLabelStyle());
        lbl.setPosition(getViewport().getWorldHeight()/2-lbl.getHeight(),getViewport().getWorldWidth()/2-lbl.getWidth()/2);
        addActor(lbl);
    }

    @Override
    protected void resized() {

    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
