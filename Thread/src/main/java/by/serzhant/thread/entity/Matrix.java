package by.serzhant.thread.entity;

import java.util.Arrays;
import java.util.Objects;

public class Matrix {
    private Integer[][] matrix;
    private int row;

    public Matrix(Integer[][] matrix) {
        this.matrix = matrix;
        this.row = matrix.length;
    }

    public void changeElement(int posI, int element) {
        matrix[posI][posI] = element;
    }

    public Integer getElement(int posI) {
        return matrix[posI][posI];
    }

    public int getRowLength() {
        return row;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix1 = (Matrix) o;
        return row == matrix1.row && Arrays.equals(matrix, matrix1.matrix);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(row);
        result = 31 * result + Arrays.hashCode(matrix);
        return result;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(matrix);
    }
}
