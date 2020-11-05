package pt.uma.tpsi;


public class Point {

    // atributos
    private double x;
    private double y;

    //construtor por omissao
    public Point() {
        x = 0.0;
        y = 0.0;
    }

    //construtor com parametros
    public Point(double x, double y){
        // this. usado para diferenciar variaveis
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
    public void setXY(double x, double y){
        this.x = x;
        this.y = y;
    }

    //
    public double distanceTo(Point other){
        double distance = Math.sqrt(Math.pow(other.x - this.x, 2) + Math.pow(other.y - this.y, 2));
                                    // a.distanceTo(b)
                                    // b == other, foi passado na função
        return distance;
    }

}
