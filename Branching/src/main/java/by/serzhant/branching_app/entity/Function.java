package by.serzhant.branching_app.entity;

import java.util.Objects;

public class Function {
    private double result;

    public Function(double a, double b, double c, double x) {
        result = a * x * x + b * x + c;
    }

    public double getResult() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Function function = (Function) o;
        return Double.compare(function.result, result) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }

    @Override
    public String toString() {
        return "Результат функции: " + result;
    }
}
