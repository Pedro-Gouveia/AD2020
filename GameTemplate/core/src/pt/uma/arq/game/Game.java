package pt.uma.arq.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.arq.entities.Fleet;
import pt.uma.arq.entities.PlayerShip;
import pt.uma.arq.entities.SmallShip;

public class Game extends ApplicationAdapter {
    private SpriteBatch batch;

    private BackgroundManagement backgroundManagement;
    private BitmapFont font;
    private Animator animator;

    private PlayerShip player;
    private SmallShip smallShip;
    private Fleet fleet;

    @Override
    public void create() {

        Gdx.graphics.setWindowedMode(600, 800);

        batch = new SpriteBatch();
        font = new BitmapFont(Gdx.files.internal("gamefont.fnt"),
                Gdx.files.internal("gamefont.png"), false);

        backgroundManagement = new BackgroundManagement(batch);

        player = new PlayerShip(batch);
        player.create();

        smallShip = new SmallShip(batch);
        smallShip.create();

    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        player.handleInput();

        batch.begin();
        // PLACE RENDERS HERE
        backgroundManagement.render();
        font.draw(batch, "HEALTH: ", 420, 780);
        player.render();
        smallShip.render();

        batch.end();
    }



    @Override
    public void dispose() {
        batch.dispose();
    }
}