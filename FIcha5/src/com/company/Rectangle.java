package com.company;

public class Rectangle {

    //atributos
    private Point topLeftPoint;
    private double height;
    private double width;

    //construtor por omissao
    public Rectangle(){
        topLeftPoint = new Point();
        height = 0.0;
        width = 0.0;
    }

    //construtor com parametros
    public Rectangle(final Point topLeftPoint, final double height, final double width){
        this.topLeftPoint = topLeftPoint;
        this.height = height;
        this.width = width;
    }

    //getters
    public Point getTopLeftPoint(){
        return topLeftPoint;
    }

    public double getHeight(){
        return height;
    }

    public double getWidth(){
        return width;
    }

    //setters
    public void setTopLeftPoint(Point topLeftPoint){
        this.topLeftPoint = topLeftPoint;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }


    public double calcArea(){
        return width * height;
    }

    public double calcPerimeter(){
        return (width + height) * 2;
    }


    public boolean containsPoint(Point p2){
        if (p2.getX() < topLeftPoint.getX() || p2.getX() > topLeftPoint.getX() + width) {
            return false;
        }
        else if( p2.getY() > topLeftPoint.getY() || p2.getY() < topLeftPoint.getY() - height){
            return false;
        }
        return true;
    }

}
