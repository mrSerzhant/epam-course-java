package by.serzhant.uml.entity.typecar;

import by.serzhant.uml.entity.Car;
import by.serzhant.uml.entity.Chassis;
import by.serzhant.uml.entity.Engine;
import by.serzhant.uml.entity.FuelTank;

import java.util.Objects;

public class Sedan extends Car {
    private String brand;

    public Sedan(String brand, Engine engine, Chassis chassis, FuelTank fuelTank) {
        super("sedan", engine, chassis, fuelTank);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public String move() {
        int fuelCapacity = super.getFuelTank().getCapacity();

        if (fuelCapacity < 30) {
            return "not_enough_capacity";
        }

        super.getFuelTank().setCapacity(fuelCapacity - 30);

        return "move";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Sedan sedan = (Sedan) o;
        return Objects.equals(brand, sedan.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), brand);
    }
}
