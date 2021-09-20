package by.serzhant.service.validator;

import by.serzhant.thread.service.parser.Parser;
import by.serzhant.thread.service.validator.Validator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ValidatorTest {

    @DataProvider(name = "data-validMatrix-equals")
    public Object[][] dataProviderValidMatrixPositive() {
        List<String> dataList = new ArrayList<>();
        dataList.add("4");
        dataList.add("0 4 5 3");
        dataList.add("4 0 1 5");
        dataList.add("4 5 0 3");
        dataList.add("4 5 4 0");
        return new Object[][]{{dataList}};
    }

    @DataProvider(name = "data-validMatrix-notEquals")
    public Object[][] dataProviderValidMatrixNegative() {
        List<String> dataList1 = new ArrayList<>();

        List<String> dataList2 = new ArrayList<>();
        dataList1.add("0 4 5 3");
        dataList1.add("4 0 1 5");
        dataList1.add("4 5 0 3");
        dataList1.add("4 5 4 0");

        List<String> dataList3 = new ArrayList<>();
        dataList1.add("4");
        dataList1.add("0 4 5 3");
        dataList1.add("4 0 1 5");
        dataList1.add("4 5 2 3");
        dataList1.add("4 5 4 0");

        List<String> dataList4 = new ArrayList<>();
        dataList1.add("4");
        dataList1.add("0 4 5 3");
        dataList1.add("4 0 1 5");
        dataList1.add("4 5 2 3");

        return new Object[][]{{dataList1}, {dataList2}, {dataList3}, {dataList4}};
    }

    @Test(dataProvider = "data-validMatrix-equals")
    public void validMatrixDataTestPositive(List<String> inputData) {
        Validator validator = new Validator();
        Assert.assertTrue(validator.isValidMatrixData(inputData));
    }

    @Test(dataProvider = "data-validMatrix-notEquals")
    public void validMatrixDataTestNegative(List<String> inputData) {
        Validator validator = new Validator();
        Assert.assertFalse(validator.isValidMatrixData(inputData));
    }

    @DataProvider(name = "data-validElement-equals")
    public Object[][] dataProviderValidElementPositive() {
        List<String> dataList = new ArrayList<>();
        dataList.add("4 9");
        return new Object[][]{{dataList}};
    }

    @Test(dataProvider = "data-validElement-equals")
    public void validElementTestPositive(List<String> inputData) {
        Validator validator = new Validator();
        Assert.assertTrue(validator.isValidCountElement(inputData));
    }

    @DataProvider(name = "data-validElement-notEquals")
    public Object[][] dataProviderValidElementNegative() {
        List<String> dataList = new ArrayList<>();

        List<String> dataList2 = new ArrayList<>();
        dataList.add("4");

        List<String> dataList3 = new ArrayList<>();
        dataList3.add("5 3");

        return new Object[][]{{dataList},{dataList2},{dataList3}};
    }

    @Test(dataProvider = "data-validElement-notEquals")
    public void validElementTestNegative(List<String> inputData) {
        Validator validator = new Validator();
        Assert.assertFalse(validator.isValidCountElement(inputData));
    }

}
