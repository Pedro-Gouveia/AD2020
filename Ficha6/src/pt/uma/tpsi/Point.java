package pt.uma.tpsi;

public class Point {

    //atributos
    private double x;
    private double y;

    //construtor por omissao
    public Point() {
        x = 0.0;
        y = 0.0;
    }

    //construtor com parametros
    public Point(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    //getters
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }

    //setters
    public void setX(double x){
        this.x = x;
    }
    public void setY(double y){
        this.y = y;
    }
    public void setYX(double x , double y){
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Point other) {
        return Math.sqrt(Math.pow(other.x - this.x, 2) + Math.pow(other.y-this.y, 2));
    }

}