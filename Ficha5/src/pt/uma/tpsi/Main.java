package pt.uma.tpsi;

public class Main {

    public static void main(String[] args) {

        Point p = new Point();

        p.setX(2.0);
        p.setY(5.0);
        p.setXY(2.0, 5.0);

	    Point a = new Point(1, 1);
	    Point b = new Point(1, 10);
        Point c = new Point(1, 8);

	    // this.x == a
        // double distance = a.distanceTo(b);

        // this.x == c
        double distance = c.distanceTo(b);


        System.out.println(distance);

    }
}
