package Menu;

import com.badlogic.gdx.Gdx;
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

    TextButton btnStart, btnExit;

    public MainMenuStage(Viewport viewport, Batch batch, FortressSiege game) {
        super(viewport, batch, game);
    }

    @Override
    public void init() {
        btnStart = new MyButton("", game.btnStart());
        btnStart.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new MainScreen(game));
            }
        });
        addActor(btnStart);
        btnStart.setPosition(350,550);

        btnExit = new MyButton("", game.btnExit());
        btnExit.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                Gdx.app.exit();
            }
        });
        addActor(btnExit);
        btnExit.setPosition(350, btnStart.getY()-150);
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
