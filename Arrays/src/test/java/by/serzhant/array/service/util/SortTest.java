package by.serzhant.array.service.util;

import by.serzhant.array.entity.Array;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SortTest {

    @DataProvider(name = "array.txt-data-provider-sort-positive")
    public Object[][] dataProviderArraySortPositive() {
        Array<?> array = new Array<>(new Double[]{3d, 5d, -2d, 21d, 0d, -4d});
        Array<?> sortArray = new Array<>(new Double[]{-4d, -2d, 0d, 3d, 5d, 21d});

        Array<?> array2 = new Array<>(new Double[]{6d, 5d, 4d, -3d, 0d, 1d});
        Array<?> sortArray2 = new Array<>(new Double[]{-3d, 0d, 1d, 4d, 5d, 6d});

        Object[][] date = new Object[2][2];

        date[0][0] = array;
        date[0][1] = sortArray;

        date[1][0] = array2;
        date[1][1] = sortArray2;

        return date;
    }

    @DataProvider(name = "array.txt-data-provider-sort-negative")
    public Object[][] dataProviderArraySortNegative() {
        Array<?> array = new Array<>(new Double[]{3d, 5d, -2d, 21d, 0d, -4d});
        Array<?> sortArray = new Array<>(new Double[]{-2d, -4d, 3d, 0d, 5d, 21d});

        Array<?> array2 = new Array<>(new Double[]{6d, 5d, 4d, -3d, 0d, 1d});
        Array<?> sortArray2 = new Array<>(new Double[]{-1d, 0d, 4d, 3d, 5d, 3d});

        Object[][] date = new Object[2][2];

        date[0][0] = array;
        date[0][1] = sortArray;

        date[1][0] = array2;
        date[1][1] = sortArray2;

        return date;
    }

    @Test(dataProvider = "array-data-provider-sort-positive")
    public void bubbleSortPositiveTest(Array<?> inputArray, Array<?> inputSortArray) {
        Sort sort = new Sort();

        Assert.assertEquals(inputSortArray, sort.bubbleSort(inputArray));
    }

    @Test(dataProvider = "array-data-provider-sort-negative")
    public void bubbleSortNegativeTest(Array<?> inputArray, Array<?> inputSortArray) {
        Sort sort = new Sort();
        Assert.assertNotEquals(inputSortArray, sort.bubbleSort(inputArray));
    }

    @Test(dataProvider = "array-data-provider-sort-positive")
    public void hashSortPositiveTest(Array<?> inputArray, Array<?> inputSortArray) {
        Sort sort = new Sort();
        Assert.assertEquals(inputSortArray, sort.hashSort(inputArray));
    }

    @Test(dataProvider = "array-data-provider-sort-negative")
    public void hashSortNegativeTest(Array<?> inputArray, Array<?> inputSortArray) {
        Sort sort = new Sort();
        Assert.assertNotEquals(inputSortArray, sort.hashSort(inputArray));
    }

    @Test(dataProvider = "array-data-provider-sort-positive")
    public void insertionSortPositiveTest(Array<?> inputArray, Array<?> inputSortArray) {
        Sort sort = new Sort();
        Assert.assertEquals(inputSortArray, sort.insertionSort(inputArray));
    }

    @Test(dataProvider = "array-data-provider-sort-negative")
    public void insertionSortNegativeTest(Array<?> inputArray, Array<?> inputSortArray) {
        Sort sort = new Sort();
        Assert.assertNotEquals(inputSortArray, sort.insertionSort(inputArray));
    }

    @Test(dataProvider = "array-data-provider-sort-positive")
    public void mergeSortPositiveTest(Array<?> inputArray, Array<?> inputSortArray) {
        Sort sort = new Sort();
        Assert.assertEquals(inputSortArray, sort.mergeSort(inputArray));
    }

    @Test(dataProvider = "array-data-provider-sort-negative")
    public void mergeSortNegativeTest(Array<?> inputArray, Array<?> inputSortArray) {
        Sort sort = new Sort();
        Assert.assertNotEquals(inputSortArray, sort.mergeSort(inputArray));
    }

    @Test(dataProvider = "array-data-provider-sort-positive")
    public void selectionSortPositiveTest(Array<?> inputArray, Array<?> inputSortArray) {
        Sort sort = new Sort();
        Assert.assertEquals(inputSortArray, sort.selectionSort(inputArray));
    }

    @Test(dataProvider = "array-data-provider-sort-negative")
    public void selectionSortNegativeTest(Array<?> inputArray, Array<?> inputSortArray) {
        Sort sort = new Sort();
        Assert.assertNotEquals(inputSortArray, sort.selectionSort(inputArray));
    }

    @Test(dataProvider = "array-data-provider-sort-positive")
    public void shellSortPositiveTest(Array<?> inputArray, Array<?> inputSortArray) {
        Sort sort = new Sort();
        Assert.assertEquals(inputSortArray, sort.shellSort(inputArray));
    }

    @Test(dataProvider = "array-data-provider-sort-negative")
    public void shellSortNegativeTest(Array<?> inputArray, Array<?> inputSortArray) {
        Sort sort = new Sort();
        Assert.assertNotEquals(inputSortArray, sort.shellSort(inputArray));
    }
}
