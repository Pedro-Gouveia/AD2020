package pt.uma.tpsi;

public class Circle extends Shape{

    private double radius;

    public Circle(){
        super();
    }

    public Circle (final double radius, Point position){
        this.radius = radius;
        this.position = position;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

}
