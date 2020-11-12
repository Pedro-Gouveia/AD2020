package pt.uma.tpsi;

public class Main {

    public static void main(String[] args) {
	// write your code here
       Circle c = new Circle();
       c.setRadius(5.0);

       double areaCircle = c.getArea();
       System.out.println(areaCircle);

       Triangle t = new Triangle();
       t.setA(new Point(1,4));
       t.setB(new Point(1,1));
       t.setC(new Point(6,1));

       double areaTriangle = t.getArea();
       System.out.println(areaTriangle);

       Rectangle r = new Rectangle();
       r.setTopLeftPoint(new Point(1,4));
       r.setHeight(3.0);
       r.setWidth(5.0);

       double areaRectangle = r.calcArea();
       System.out.println(areaRectangle);



    }
}
