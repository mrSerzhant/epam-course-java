package by.serzhant.uml.entity;

public class Engine {
    private String brand;
    private int power;

    public Engine(String brand, int power) {
        this.brand = brand;
        this.power = power;
    }

    @Override
    public String toString() {
        return String.format("engine: brand - %s, power - %d, ", brand, power);
    }
}
