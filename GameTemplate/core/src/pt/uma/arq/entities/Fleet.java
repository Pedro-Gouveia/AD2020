package pt.uma.arq.entities;

import pt.uma.arq.game.Animator;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.TimerTask;

import java.util.ArrayList;

public class Fleet {

    SpriteBatch batch;

    private ArrayList<Ship> ships;
    public ArrayList<Laser> enemyLasers;

    public Fleet(SpriteBatch batch){

        this.batch = batch;
        this.ships = new ArrayList<Ship>();
        this.enemyLasers = new ArrayList<Laser>();
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

    public void create(){
        for (int i = 0; i < 9; i++) {
            Ship small = new SmallShip(90 + (i * 50), 550, 5, batch);
            small.create();
            ships.add(small);
            Ship medium = new MediumShip(40 + (i * 60), 600, 10, batch);
            medium.create();
            ships.add(medium);
            Ship large = new LargeShip(40 + (i * 60), 650, 20, batch);
            large.create();
            ships.add(large);
        }

        /*
            for (int i = 0; i < 9; i++) {
                Laser enemyLaser = new Laser(90 + (i * 50), 550, batch);
                enemyLaser.create();
                enemyLasers.add(enemyLaser);
            }

            for (int i = 0; i < 9; i++) {
                Laser enemyLaser = new Laser(40 + (i * 60), 600, batch);
                enemyLaser.create();
                enemyLasers.add(enemyLaser);
            }

            for (int i = 0; i < 9; i++) {
                Laser enemyLaser = new Laser(40 + (i * 60), 650, batch);
                enemyLaser.create();
                enemyLasers.add(enemyLaser);
            }
        */

        /*
        public class AnnoyingBeep {
            Toolkit toolkit;
            Timer timer;

            public AnnoyingBeep() {
                toolkit = Toolkit.getDefaultToolkit();
                timer = new Timer();
                timer.schedule(new RemindTask(),
                        0,        //initial delay
                        1 * 1000);  //subsequent rate
            }

            class RemindTask extends TimerTask {
                int numWarningBeeps = 3;

                public void run() {
                    if (numWarningBeeps > 0) {
                        toolkit.beep();
                        System.out.println("Beep!");
                        numWarningBeeps--;
                    } else {
                        toolkit.beep();
                        System.out.println("Time's up!");
                        //timer.cancel(); // Not necessary because
                        // we call System.exit
                        System.exit(0);   // Stops the AWT thread
                        // (and everything else)
                    }
                }
            }
        }
        */

    }

    public void render(){
        for (Ship ship: ships) {
            ship.render();
        }
        for (Laser laser: enemyLasers) {
            laser.renderEnemy();
        }

    }

}
