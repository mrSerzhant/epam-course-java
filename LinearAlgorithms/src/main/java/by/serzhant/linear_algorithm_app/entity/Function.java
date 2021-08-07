package by.serzhant.linear_algorithm_app.entity;

import java.util.Objects;

public class Function {
    public static final int CONST_ELEMENT = 3;
    private Numeral validNumeral;

    public Function(Numeral numeral){
        validNumeral = numeral;
    }

    public Numeral getValidNumeral() {
        return validNumeral;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Function function = (Function) o;
        return validNumeral.equals(function.validNumeral);
    }

    @Override
    public int hashCode() {
        return Objects.hash(validNumeral);
    }

    @Override
    public String toString() {
        return "Элемент функции " + validNumeral;
    }
}
