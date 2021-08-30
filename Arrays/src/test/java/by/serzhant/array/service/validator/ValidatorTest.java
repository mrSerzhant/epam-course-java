package by.serzhant.array.service.validator;

import by.serzhant.array.entity.Array;
import by.serzhant.array.entity.Matrix;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ValidatorTest {

    @DataProvider(name = "array.txt-data-provider-positive")
    public Object[][] dataProviderArrayPositive() {
        Double[] array1 = {3d, 5d, -2d, 21d, 0d, 0d};
        Double[] array2 = {0d, 0d, 0d, 10d, 5d, 3d};
        return new Object[][]{{array1}, {array2}};
    }

    @DataProvider(name = "array.txt-data-provider-negative")
    public Object[][] dataProviderArrayNegative() {
        Double[] array = {};
        return new Object[][]{{array}};
    }

    @DataProvider(name = "matrix-data-provider-positive")
    public Object[][] dataProviderMatrixPositive() {
        Double[][] array1 = {{3d, 5d, -2d, 21d, 0d, 0d}, {2d, 3d, -4d, 11d, 10d, 100d}, {-3d, 25d, -23d, 21d, 30d, 2d}};
        Double[][] array2 = {{3d, 5d}, {2d, 3d}, {30d, 2d}};
        return new Object[][]{{array1}, {array2}};
    }

    @DataProvider(name = "matrix-data-provider-negative")
    public Object[][] dataProviderMatrixNegative() {
        Double[][] array1 = {{3d, 5d, -2d, 21d, 0d, 0d}, {2d, 3d, -4d}, {-3d, 25d, -23d, 21d}};
        Double[][] array2 = {{3d, 5d, 4d}, {2d, 3d}, {30d}};
        return new Object[][]{{array1}, {array2}};
    }

    @DataProvider(name = "matrix-equals-data-provider-positive", parallel = true)
    public Object[][] dataProviderMatrixEqualsPositive() {
        Object[][] date = new Object[1][2];

        Double[][] d1 = {{4d, 5d}, {1d, 3d}};
        Double[][] d2 = {{3d, 2d}, {2d, 3d}};

        date[0][0] = d1;
        date[0][1] = d2;

        return date;
    }

    @DataProvider(name = "matrix-equals-data-provider-negative", parallel = true)
    public Object[][] dataProviderMatrixEqualsNegative() {
        Object[][] date = new Object[2][2];

        Double[][] d1 = {{4d, 5d}, {1d, 3d}, {3d, 4d}};
        Double[][] d2 = {{3d, 2d}, {2d, 3d}};

        Double[][] d3 = {{4d, 5d, 5d}, {1d, 3d}};
        Double[][] d4 = {{3d, 2d}, {2d, 3d, 2d}};

        date[0][0] = d1;
        date[0][1] = d2;

        date[1][0] = d3;
        date[1][1] = d4;

        return date;
    }

    @DataProvider(name = "matrix-multiplication-data-provider-positive", parallel = true)
    public Object[][] dataProviderMultiplicationPositive() {
        Object[][] date = new Object[1][2];

        Double[][] d1 = {{4d, 5d}, {1d, 3d}};
        Double[][] d2 = {{3d}, {2d}};

        date[0][0] = d1;
        date[0][1] = d2;

        return date;
    }

    @DataProvider(name = "matrix-multiplication-data-provider-negative", parallel = true)
    public Object[][] dataProviderMultiplicationNegative() {
        Object[][] date = new Object[1][2];

        Double[][] d1 = {{4d, 5d}, {1d, 3d}};
        Double[][] d2 = {{3d, 2d}, {2d, 1d}, {4d, 7d}};

        date[0][0] = d1;
        date[0][1] = d2;

        return date;
    }

    @Test(dataProvider = "array-data-provider-positive")
    public void isValidArrayPositiveTest(Double[] inputArray) {
        Validator validator = new Validator();
        Assert.assertTrue(validator.isValidArray(new Array<>(inputArray)));
    }

    @Test(dataProvider = "array-data-provider-negative")
    public void isValidArrayNegativeTest(Double[] inputArray) {
        Validator validator = new Validator();
        Assert.assertFalse(validator.isValidArray(new Array<>(inputArray)));
    }

    @Test(dataProvider = "matrix-data-provider-positive")
    public void isValidMatrixPositiveTest(Double[][] inputArray) {
        Validator validator = new Validator();
        Assert.assertTrue(validator.isValidMatrix(new Matrix<>(inputArray)));
    }

    @Test(dataProvider = "matrix-data-provider-negative")
    public void isValidMatrixNegative(Double[][] inputArray) {
        Validator validator = new Validator();
        Assert.assertFalse(validator.isValidMatrix(new Matrix<>(inputArray)));
    }

    @Test(dataProvider = "matrix-equals-data-provider-positive")
    public void isEqualsMatrixPositive(Double[][] inputArray, Double[][] inputArray2) {
        Validator validator = new Validator();
        Assert.assertTrue(validator.isEqualMatrix(new Matrix<>(inputArray), new Matrix<>(inputArray2)));
    }

    @Test(dataProvider = "matrix-equals-data-provider-negative")
    public void isEqualsMatrixNegative(Double[][] inputArray, Double[][] inputArray2) {
        Validator validator = new Validator();
        Assert.assertFalse(validator.isEqualMatrix(new Matrix<>(inputArray), new Matrix<>(inputArray2)));
    }

    @Test(dataProvider = "matrix-multiplication-data-provider-positive")
    public void isValidForMultiplicationPositive(Double[][] inputArray, Double[][] inputArray2) {
        Validator validator = new Validator();
        Assert.assertTrue(validator.isValidForMultiplication(new Matrix<>(inputArray), new Matrix<>(inputArray2)));
    }

    @Test(dataProvider = "matrix-multiplication-data-provider-negative")
    public void isValidForMultiplicationNegative(Double[][] inputArray, Double[][] inputArray2) {
        Validator validator = new Validator();
        Assert.assertFalse(validator.isValidForMultiplication(new Matrix<>(inputArray), new Matrix<>(inputArray2)));
    }
}
