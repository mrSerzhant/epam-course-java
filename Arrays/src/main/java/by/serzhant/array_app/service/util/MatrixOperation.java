package by.serzhant.array_app.service.util;

import by.serzhant.array_app.entity.Matrix;

import java.util.Arrays;

public class MatrixOperation {

    public Matrix<?> sumMatrix(Matrix<?> inputFirstMatrix, Matrix<?> inputSecondMatrix) {
        int row = inputFirstMatrix.getRowLength();
        int column = inputSecondMatrix.getMatrix()[0].length;

        Double[][] newMatrix = new Double[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                newMatrix[i][j] = inputFirstMatrix.getMatrix()[i][j].doubleValue() +
                        inputSecondMatrix.getMatrix()[i][j].doubleValue();
            }
        }

        return new Matrix<>(newMatrix);
    }

    public Matrix<?> subtractMatrix(Matrix<?> inputFirstMatrix, Matrix<?> inputSecondMatrix) {
        int row = inputFirstMatrix.getRowLength();
        int column = inputSecondMatrix.getMatrix()[0].length;

        Double[][] newMatrix = new Double[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                newMatrix[i][j] = inputFirstMatrix.getMatrix()[i][j].doubleValue() -
                        inputSecondMatrix.getMatrix()[i][j].doubleValue();
            }
        }

        return new Matrix<>(newMatrix);
    }

    public Matrix<?> multiplicationMatrix(Matrix<?> inputFirstMatrix, Matrix<?> inputSecondMatrix) {
        int column = inputFirstMatrix.getRowLength();
        int row = inputSecondMatrix.getMatrix()[0].length;

        Double[][] newMatrix = new Double[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {

                newMatrix[i][j] = 0D;

                for (int k = 0; k < inputSecondMatrix.getRowLength(); k++) {
                    newMatrix[i][j] = newMatrix[i][j] + inputFirstMatrix.getMatrix()[i][k].doubleValue() * inputSecondMatrix.getMatrix()[k][j].doubleValue();
                }
            }
        }

        return new Matrix<>(newMatrix);
    }
}