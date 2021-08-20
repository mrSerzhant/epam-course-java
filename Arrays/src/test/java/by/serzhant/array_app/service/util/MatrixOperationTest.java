package by.serzhant.array_app.service.util;

import by.serzhant.array_app.entity.Matrix;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MatrixOperationTest {

    @DataProvider(name = "matrix-sum-data-provider-positive")
    public Object[][] dataProviderMatrixSumPositive() {
        Double[][] matrix1 = {{4d, 3d, 5d}, {1d, 8d, 4d}};
        Double[][] matrix2 = {{3d, 2d, 1d}, {2d, -1d, -2d}};
        Double[][] matrixResult = {{7d, 5d, 6d}, {3d, 7d, 2d}};

        Object[][] date = new Object[1][3];

        date[0][0] = new Matrix<>(matrix1);
        date[0][1] = new Matrix<>(matrix2);
        date[0][2] = new Matrix<>(matrixResult);

        return date;
    }

    @DataProvider(name = "matrix-sum-data-provider-negative")
    public Object[][] dataProviderMatrixSumNegative() {
        Double[][] matrix1 = {{4d, 3d, 5d}, {1d, 8d, 4d}};
        Double[][] matrix2 = {{3d, 2d, 1d}, {2d, -1d, -2d}};
        Double[][] matrixResult = {{7d, 5d, 3d}, {3d, 3d, 1d}};

        Object[][] date = new Object[1][3];

        date[0][0] = new Matrix<>(matrix1);
        date[0][1] = new Matrix<>(matrix2);
        date[0][2] = new Matrix<>(matrixResult);

        return date;
    }

    @DataProvider(name = "matrix-subtract-data-provider-positive")
    public Object[][] dataProviderMatrixSubtractPositive() {
        Double[][] matrix1 = {{4d, 3d, 5d}, {1d, 8d, 4d}};
        Double[][] matrix2 = {{3d, 2d, 1d}, {2d, -1d, -2d}};
        Double[][] matrixResult = {{1d, 1d, 4d}, {-1d, 9d, 6d}};

        Object[][] date = new Object[1][3];

        date[0][0] = new Matrix<>(matrix1);
        date[0][1] = new Matrix<>(matrix2);
        date[0][2] = new Matrix<>(matrixResult);

        return date;
    }

    @DataProvider(name = "matrix-subtract-data-provider-negative")
    public Object[][] dataProviderMatrixSubtractNegative() {
        Double[][] matrix1 = {{4d, 3d, 5d}, {1d, 8d, 4d}};
        Double[][] matrix2 = {{3d, 2d, 1d}, {2d, -1d, -2d}};
        Double[][] matrixResult = {{1d, 1d, 2d}, {3d, 7d, 2d}};

        Object[][] date = new Object[1][3];

        date[0][0] = new Matrix<>(matrix1);
        date[0][1] = new Matrix<>(matrix2);
        date[0][2] = new Matrix<>(matrixResult);

        return date;
    }

    @DataProvider(name = "matrix-mult-data-provider-positive")
    public Object[][] dataProviderMatrixMultPositive() {
        Double[][] matrix1 = {{4d, 3d, 5d}, {1d, 8d, 4d}};
        Double[][] matrix2 = {{3d, 2d, 1d}, {2d, -1d, -2d}, {2d, -1d, -2d}};
        Double[][] matrixResult = {{28d, 0d, -12d}, {27d, -10d, -23d}};

        Object[][] date = new Object[1][3];

        date[0][0] = new Matrix<>(matrix1);
        date[0][1] = new Matrix<>(matrix2);
        date[0][2] = new Matrix<>(matrixResult);

        return date;
    }

    @DataProvider(name = "matrix-mult-data-provider-negative")
    public Object[][] dataProviderMatrixMultNegative() {
        Double[][] matrix1 = {{4d, 3d, 5d}, {1d, 8d, 4d}};
        Double[][] matrix2 = {{3d, 2d, 1d}, {2d, -1d, -2d}, {2d, -1d, -2d}};
        Double[][] matrixResult = {{1d, 1d, 2d}, {3d, 7d, 2d}};

        Object[][] date = new Object[1][3];

        date[0][0] = new Matrix<>(matrix1);
        date[0][1] = new Matrix<>(matrix2);
        date[0][2] = new Matrix<>(matrixResult);

        return date;
    }

    @Test(dataProvider = "matrix-sum-data-provider-positive")
    public void sumMatrixPositiveTest(Matrix<?> firstMatrix, Matrix<?> secondMatrix, Matrix<?> matrixResult) {
        MatrixOperation matrixOperation = new MatrixOperation();

        Matrix<?> calculateMatrix =  matrixOperation.sumMatrix(firstMatrix, secondMatrix);

        for(int i = 0; i < matrixResult.getRowLength(); i++){
            Assert.assertEquals(matrixResult.getMatrix()[i], calculateMatrix.getMatrix()[i]);
        }
    }

    @Test(dataProvider = "matrix-sum-data-provider-negative")
    public void sumMatrixNegativeTest(Matrix<?> firstMatrix, Matrix<?> secondMatrix, Matrix<?> matrixResult) {
        MatrixOperation matrixOperation = new MatrixOperation();

        Matrix<?> calculateMatrix =  matrixOperation.sumMatrix(firstMatrix, secondMatrix);

        for(int i = 0; i < matrixResult.getRowLength(); i++){
            Assert.assertNotEquals(matrixResult.getMatrix()[i], calculateMatrix.getMatrix()[i]);
        }
    }

    @Test(dataProvider = "matrix-mult-data-provider-positive")
    public void subtractMatrixPositiveTest(Matrix<?> firstMatrix, Matrix<?> secondMatrix, Matrix<?> matrixResult) {
        MatrixOperation matrixOperation = new MatrixOperation();

        Matrix<?> calculateMatrix =  matrixOperation.multiplicationMatrix(firstMatrix, secondMatrix);

        for(int i = 0; i < matrixResult.getRowLength(); i++){
            Assert.assertEquals(matrixResult.getMatrix()[i], calculateMatrix.getMatrix()[i]);
        }
    }

    @Test(dataProvider = "matrix-subtract-data-provider-negative")
    public void subtractMatrixNegativeTest(Matrix<?> firstMatrix, Matrix<?> secondMatrix, Matrix<?> matrixResult) {
        MatrixOperation matrixOperation = new MatrixOperation();

        Matrix<?> calculateMatrix =  matrixOperation.subtractMatrix(firstMatrix, secondMatrix);

        for(int i = 0; i < matrixResult.getRowLength(); i++){
            Assert.assertNotEquals(matrixResult.getMatrix()[i], calculateMatrix.getMatrix()[i]);
        }
    }
}
