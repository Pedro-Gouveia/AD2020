package pt.uma.arq.entities;

import pt.uma.arq.game.Animator;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class Fleet {

    private Animator animator;
    private int x;
    private int y;

    private ArrayList<Ship> ships;

        public Fleet(){
            this.ships = new ArrayList<Ship>();
        }

        public Fleet(ArrayList<Ship> ships) {
            this.ships = ships;
        }

        public ArrayList<Ship> getShips() {
            return ships;
        }

        public void setShips(ArrayList<Ship> ships) {
            this.ships = ships;
        }

        public void add(Ship ship){
            this.ships.add(ship);
        }

        public void addSmallShip(Ship smallShip){
            //ships.add(new SmallShip);
        }

    public void create(){
        animator.create();
    }

    public void render(){
        animator.render(x,y);
    }

}
