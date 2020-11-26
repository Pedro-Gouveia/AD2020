package pt.uma.arq.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import pt.uma.arq.game.Animator;

public class SmallShip extends Ship{

    public SmallShip(SpriteBatch batch){
        animator = new Animator(batch, "enemy-small.png", 2, 1);
        attackValue = 5;
    }


    public void create(){
        animator.create();
    }

    public void render(){
        animator.render(x,y);
    }
}
