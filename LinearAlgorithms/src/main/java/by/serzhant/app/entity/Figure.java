package by.serzhant.app.entity;

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
}
