package by.serzhant.linear_algorithm_app.entity;

import java.util.Objects;

public class Numeral {
    private double validNumeral;
    private int realNumeral;

    public Numeral(double validNumeral) {
        this.validNumeral = validNumeral;
    }

    public Numeral(int realNumeral) {
        this.realNumeral = realNumeral;
    }

    public double getValidNumeral() {
        return validNumeral;
    }

    public int getRealNumeral() {
        return realNumeral;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Numeral numeral = (Numeral) o;
        return Double.compare(numeral.validNumeral, validNumeral) == 0 &&
                realNumeral == numeral.realNumeral;
    }

    @Override
    public int hashCode() {
        return Objects.hash(validNumeral, realNumeral);
    }

    @Override
    public String toString() {
        return String.format("Действительное число %f, вещественное число %d", validNumeral, realNumeral);
    }
}
