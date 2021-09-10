package by.serzhant.uml.entity;

import java.util.Objects;

public class Engine {
    private String brand;
    private int power;

    public Engine(String brand, int power) {
        this.brand = brand;
        this.power = power;
    }

    public String getBrand() {
        return brand;
    }

    public int getPower() {
        return power;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engine engine = (Engine) o;
        return power == engine.power && Objects.equals(brand, engine.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, power);
    }

    @Override
    public String toString() {
        return String.format("engine: brand - %s, power - %d, ", brand, power);
    }
}
