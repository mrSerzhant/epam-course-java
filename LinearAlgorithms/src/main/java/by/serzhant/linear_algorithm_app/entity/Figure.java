package by.serzhant.linear_algorithm_app.entity;

import java.util.Objects;

public class Figure {
    private double firstSide;
    private double secondSide;

    public Figure(double firstSide) {
        this.firstSide = firstSide;
        this.secondSide = firstSide * 2;
    }

    public double getFirstSide() {
        return firstSide;
    }

    public double getSecondSide() {
        return secondSide;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figure figure = (Figure) o;
        return Double.compare(figure.firstSide, firstSide) == 0 &&
                Double.compare(figure.secondSide, secondSide) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstSide, secondSide);
    }

    @Override
    public String toString() {
        return String.format("Первая сторона %f, вторая сторона %f", firstSide, secondSide);
    }
}
