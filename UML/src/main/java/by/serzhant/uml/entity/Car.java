package by.serzhant.uml.entity;

import java.util.Objects;

public abstract class Car {
    private String brand;
    private Engine engine;
    private Chassis chassis;
    private FuelTank fuelTank;

    public Car(String brand, Engine engine, FuelTank fuelTank) {
        this.brand = brand;
        this.engine = engine;
        this.fuelTank = fuelTank;
    }

    public String move() {
        if (fuelTank.getCapacity() < 30) {
            return "not enough capacity";
        }

        fuelTank.setCapacity(fuelTank.getCapacity() - 30);

        return "move";
    }

    public FuelTank getFuelTank() {
        return fuelTank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(brand, car.brand) &&
                Objects.equals(engine, car.engine) &&
                Objects.equals(chassis, car.chassis) &&
                Objects.equals(fuelTank, car.fuelTank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, engine, chassis, fuelTank);
    }

    @Override
    public String toString() {
        return String.format(brand, fuelTank);
    }
}
