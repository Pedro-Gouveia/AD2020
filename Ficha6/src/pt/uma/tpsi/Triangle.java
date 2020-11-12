package pt.uma.tpsi;

public class Triangle extends Shape{

    //atributos
    private Point a;
    private Point b;
    private Point c;

    //construtor por omissao
    public Triangle() {
        a = new Point();
        b = new Point();
        c = new Point();
    }

    @Override
    public double getArea() {
        return calcArea();
    }

    @Override
    public double getPerimeter() {
        return 0;
    }

    //contrutor com parametros
    public Triangle(final Point a, final Point b, final Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    //getters
    public Point getA(){
        return a;
    }
    public Point getB(){
        return b;
    }
    public Point getC(){
        return c;
    }

    //setters
    public void setA(Point a){
        this.a = a;
    }
    public void setB(Point b){
        this.b = b;
    }
    public void setC(Point c){
        this.c = c;
    }
    public void setABC(Point a , Point b, Point c){
        this.a = a;
        this.b = b;
        this.c = c;
    }


    public double calcBase() {
        return b.distanceTo(c);
    }

    public double calcHeight() {
        return b.distanceTo(a);
    }

    public double calcArea() {
        return (calcBase()*calcHeight())/2;
    }

}
