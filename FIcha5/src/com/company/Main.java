package com.company;

public class Main {

    public static void main(String[] args) {
        //Ex. 2
        Point p = new Point();
        p.setX(5.0);
        p.setY(10.0);
        p.setYX(6.0, 8.0);

        Point a = new Point(1,1);
        Point b = new Point( 1,2);

        double distance = a.distanceTo(b);
        //System.out.println(distance);

        //Ex. 3
        Triangle t = new Triangle();

        /*
        A
        |
        |
        |______________
        B             C
        */

        t.setA(new Point(1,4));
        t.setB(new Point(1,1));
        t.setC(new Point(6,1));
        //t.setABC(new Point(1,1), new Point(1,4), new Point(6,1));

        double base = t.calcBase();
        //System.out.println(base);

        double height = t.calcHeight();
        //System.out.println(height);

        double area = t.calcArea();
        //System.out.println(area);

        //Ex. 4
        Rectangle r = new Rectangle();
        r.setTopLeftPoint(new Point(1,4));
        r.setHeight(3.0);
        r.setWidth(5.0);

        double areaRectangle = r.calcArea();
        System.out.println(areaRectangle);

        double perimeter = r.calcPerimeter();
        System.out.println(perimeter);

        Point p2 = new Point(6,7);
        boolean containsPoint = r.containsPoint(p2);
        System.out.println(containsPoint);

    }
}
