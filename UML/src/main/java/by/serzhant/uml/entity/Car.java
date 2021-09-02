package by.serzhant.uml.entity;

import by.serzhant.uml.entity.property.Movable;
import by.serzhant.uml.entity.typecar.Sedan;

import java.util.Objects;

public abstract class Car implements Movable {
    private String type;
    private Engine engine;
    private Chassis chassis;
    private FuelTank fuelTank;

    public Car(String type, Engine engine, Chassis chassis, FuelTank fuelTank) {
        this.type = type;
        this.engine = engine;
        this.chassis = chassis;
        this.fuelTank = fuelTank;
    }

    public String getType() {
        return type;
    }

    public Engine getEngine() {
        return engine;
    }

    public Chassis getChassis() {
        return chassis;
    }

    public FuelTank getFuelTank() {
        return fuelTank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(type, car.type) &&
                Objects.equals(engine, car.engine) &&
                Objects.equals(chassis, car.chassis) &&
                Objects.equals(fuelTank, car.fuelTank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, engine, chassis, fuelTank);
    }

    @Override
    public String toString() {
        return type;
    }
}
