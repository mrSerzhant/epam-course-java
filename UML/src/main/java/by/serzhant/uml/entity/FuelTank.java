package by.serzhant.uml.entity;

import java.util.Objects;

public class FuelTank {
    private double capacity;

    public FuelTank() {
    }

    public FuelTank(double capacity) {
        this.capacity = capacity;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FuelTank fuelTank = (FuelTank) o;
        return Double.compare(fuelTank.capacity, capacity) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(capacity);
    }

    @Override
    public String toString() {
        return "fuel_capacity" + capacity;
    }
}
