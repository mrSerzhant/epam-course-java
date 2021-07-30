package by.serzhant.app.entity;

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

    public void setRealNumeral(int realNumeral) {
        this.realNumeral = realNumeral;
    }
}

