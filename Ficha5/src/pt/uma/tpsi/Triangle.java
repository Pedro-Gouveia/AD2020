package pt.uma.tpsi;

public class Triangle {

    // atributos
    private Point a;
    private Point b;
    private Point c;

    //construtor por omissao
    public Triangle() {
        a = new Point();
        b = new Point();
        c = new Point();
    }

    //construtor com parametros
    public Triangle(Point a, Point b, Point c){
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

}
