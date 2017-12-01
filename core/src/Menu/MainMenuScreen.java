package Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.mygdx.game.FortressSiege;
import com.mygdx.game.MainScreen;
import com.mygdx.game.MyBaseClasses.Scene2D.MyScreen;

/**
 * Created by tanulo on 2017. 11. 30..
 */

public class MainMenuScreen extends MyScreen {
    protected MainMenuStage mainMenuStage;

    public MainMenuScreen(FortressSiege game) {
        super(game);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        mainMenuStage.act(delta);
        mainMenuStage.draw();
    }

     @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        mainMenuStage.resize(width, height);
    }


    @Override
    public void dispose() {
        mainMenuStage.dispose();
        super.dispose();
    }

    @Override
    public void init() {
        mainMenuStage = new MainMenuStage(new ExtendViewport(1280,720,new OrthographicCamera(1280,720)), spriteBatch, game);
        Gdx.input.setInputProcessor(mainMenuStage);
        //rgb(0, 82, 102)
        setBackGroundColor(0f,0f,0f);

    }
}
