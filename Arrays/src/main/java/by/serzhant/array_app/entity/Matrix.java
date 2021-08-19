package by.serzhant.array_app.entity;

import java.util.Arrays;

public class Matrix <T extends Number> {
    private T[][] matrix;
    private int row;

    public Matrix(T[][] matrix) {
        this.matrix = matrix;
        this.row = matrix.length;
    }

    public T[][] getMatrix() {
        return matrix;
    }

    public int getRowLength() {
        return row;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix<?> matrix1 = (Matrix<?>) o;
        return Arrays.equals(matrix, matrix1.matrix);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(matrix);
    }

    @Override
    public String toString() {
        return Arrays.deepToString(matrix);

    }
}
