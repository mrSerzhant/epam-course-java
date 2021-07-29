package by.serzhant.app.entity;

public class Number {
    private double validNumber;
    private int realNumber;

    public Number(double validNumber) {
        this.validNumber = validNumber;
    }

    public Number(int realNumber) {
        this.realNumber = realNumber;
    }

    public double getValidNumber() {
        return validNumber;
    }

    public int getRealNumber() {
        return realNumber;
    }

}
