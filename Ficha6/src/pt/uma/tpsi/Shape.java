package pt.uma.tpsi;

import java.awt.*;

public abstract class Shape {
    private Point position;

    public Shape(){
        position = new Point();
    }

    public Shape(Point position){
        this.position = position;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    //definir methods
    public abstract double getArea();

    public abstract double getPerimeter();

}
