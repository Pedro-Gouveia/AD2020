package pt.uma.arq.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.arq.game.Animator;

public class PlayerShip extends Ship{

    public PlayerShip(SpriteBatch batch){
        animator = new Animator(batch, "ship.png", 5, 2);
        x = 300;
        y = 50;
    }

    public void create(){
        animator.create();
    }

    public void render(){
        animator.render(x, y);
    }

    public void handleInput(){
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            if (x < 0){
                x = 600;
            } else {
                x -= 10;
            }
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            if (x > 600){
                x = 0;
            } else {
                x += 10;
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)){

        }
    }
}
