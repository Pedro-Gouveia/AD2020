package pt.uma.tpsi;

public class Car extends Vehicle {

    public Car(){
        super();
    }

    public Car (final int year, final String brand, final String model, final double price, final String color){
        super(year, brand, model, price, color);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
