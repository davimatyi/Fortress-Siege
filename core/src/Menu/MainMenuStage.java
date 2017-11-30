package Menu;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.FortressSiege;
import com.mygdx.game.MainScreen;
import com.mygdx.game.MyBaseClasses.Game.MyGame;
import com.mygdx.game.MyBaseClasses.Scene2D.MyStage;
import com.mygdx.game.MyBaseClasses.VarActor;
import com.mygdx.game.UI.MyButton;

import java.awt.Menu;

/**
 * Created by tanulo on 2017. 11. 30..
 */

public class MainMenuStage extends MyStage {

    TextButton btnHeal;

    public MainMenuStage(Viewport viewport, Batch batch, FortressSiege game) {
        super(viewport, batch, game);
    }

    @Override
    public void init() {
        btnHeal = new MyButton("", game.getTextButtonStyle());
        btnHeal.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new MainScreen(game));
            }
        });
        addActor(btnHeal);
        btnHeal.setPosition(10,10);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    protected void resized() {

    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
