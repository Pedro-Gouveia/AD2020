package pt.uma.tpsi;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

class Task extends TimerTask {

    int count = 0;

    /*
    private Random rand = new Random();
    double prob = rand.nextDouble();
    */

    public void run()
    {
        System.out.println("count = "+count);

        count++;
    }



    public static void main(String[] args) {

        Task task = new Task();
        Timer time = new Timer();
        time.schedule(task,2000,500);

        while(true)
        {
            if(task.count == 10)
            {
                time.cancel();
                break;
            }
        }
    }
}

