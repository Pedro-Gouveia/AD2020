package pt.uma.arq.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import jdk.internal.icu.util.CodePointTrie;
import pt.uma.arq.entities.*;

public class Game extends ApplicationAdapter {
    private SpriteBatch batch;

    private BackgroundManagement backgroundManagement;
    private BitmapFont font;

    private PlayerShip player;
    private Fleet fleet;
    private int health;
    private int score;
    //private Laser laser;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public void create() {

        Gdx.graphics.setWindowedMode(600, 800);

        batch = new SpriteBatch();
        font = new BitmapFont(Gdx.files.internal("gamefont.fnt"),
                Gdx.files.internal("gamefont.png"), false);

        backgroundManagement = new BackgroundManagement(batch);

        setHealth(100);
        setScore(0);

        player = new PlayerShip(batch);
        player.create();

        fleet = new Fleet(batch);
        fleet.create();

        //laser = new Laser(batch);
        //laser.create();

    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        player.handleInput();

        batch.begin();
        // PLACE RENDERS HERE
        backgroundManagement.render();
        font.draw(batch, "HEALTH: " + getHealth(), 420, 780);
        font.draw(batch, "SCORE: " + getScore(), 10, 780);

        /*
        if (health <= 0){
            font.draw(batch, "YOU LOST!" , 300, 400);
        }
        */

        player.render();
        fleet.render();
        //laser.render();

        batch.end();
    }


    @Override
    public void dispose() {
        batch.dispose();
    }
}