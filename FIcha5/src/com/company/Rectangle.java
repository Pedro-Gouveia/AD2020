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
        if (
        //se p2(x) < topLeftPoint(x) ou p2(x) > topLeftPoint(x) + width
        ){
            return false;
        }
        else if(
        // se p2(y) > topLeftPoint(y) ou p2(y) < topLeftPoint(y) - height
        ){
            return false;
        }
        return true;
    }

}
