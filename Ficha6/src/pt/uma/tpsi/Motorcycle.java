package pt.uma.tpsi;

public class Motorcycle extends Vehicle {

    public Motorcycle(){
        super();
    }

    public Motorcycle (final int year, final String brand, final String model, final double price, final String color){
        super(year, brand, model, price, color);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
