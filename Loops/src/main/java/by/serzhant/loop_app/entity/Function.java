package by.serzhant.loop_app.entity;

import java.util.Objects;

public class Function {
    private double result;


    public void initFunction(int inputParam) {
        result = inputParam;
    }

    public void initSinFunction(int inputParam) {
        result = Math.sin(inputParam) * Math.sin(inputParam);
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
