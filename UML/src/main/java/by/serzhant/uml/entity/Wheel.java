package by.serzhant.uml.entity;

import java.util.Objects;

public class Wheel {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wheel wheel = (Wheel) o;
        return diameter == wheel.diameter;
    }

    @Override
    public int hashCode() {
        return Objects.hash(diameter);
    }

    private int diameter;

    public Wheel(int diameter) {
        this.diameter = diameter;
    }


    @Override
    public String toString() {
        return String.format("wheel_diameter: %d, ", diameter);
    }
}
