package by.serzhant.service.parser;

import by.serzhant.thread.service.parser.Parser;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ParserTest {

    @DataProvider(name = "data-diapason-equals")
    public Object[][] dataProviderParseDiapasonPositive() {
        return new Object[][]{{"5 9"}, {"3 4"}, {"0 1"}, {"4 -5"}};
    }

    @DataProvider(name = "data-diapason-notEquals")
    public Object[][] dataProviderParseDiapasonNegative() {
        return new Object[][]{{"5 D"}, {"3 a"}, {"s d"}, {"D -5"}};
    }

    @Test(dataProvider = "data-diapason-equals")
    public void parseDiapasonTestPositive(String inputData) {
        Parser parser = new Parser();
        Assert.assertEquals(2, parser.parseDiapason(inputData).size());
    }

    @Test(dataProvider = "data-diapason-notEquals")
    public void parseDiapasonTestNegative(String inputData) {
        Parser parser = new Parser();
        Assert.assertNotEquals(2, parser.parseDiapason(inputData).size());
    }

    @DataProvider(name = "data-matrix-equals")
    public Object[][] dataProviderParseMatrixPositive() {
        List<String> dataList = new ArrayList<>();
        dataList.add("4");
        dataList.add("3 4 5 3");
        dataList.add("4 2 1 5");
        dataList.add("4 5 4 3");
        return new Object[][]{{dataList}};
    }

    @Test(dataProvider = "data-matrix-equals")
    public void parseMatrixTestPositive(List<String> inputData) {
        Parser parser = new Parser();
        Integer[][] matrix = {{3, 4, 5, 3}, {4, 2, 1, 5}, {4, 5, 4, 3}};
        Assert.assertEquals(matrix, parser.parseMatrixElement(inputData));
    }

    @DataProvider(name = "badData-matrix-equals")
    public Object[][] dataProviderParseMatrixNegative() {
        List<String> dataList = new ArrayList<>();
        dataList.add("4");
        dataList.add("3 4 53");
        dataList.add("s S1 5");
        dataList.add("4 5 a 3");
        return new Object[][]{{dataList}};
    }

    @Test(dataProvider = "badData-matrix-equals")
    public void parseMatrixTestNegative(List<String> inputData) {
        Parser parser = new Parser();
        Integer[][] matrix = new Integer[0][0];
        Assert.assertEquals(matrix, parser.parseMatrixElement(inputData));
    }

    @DataProvider(name = "tempData-matrix-equals")
    public Object[][] dataProviderParseTempMatrixPositive() {
        List<String> dataList = new ArrayList<>();
        dataList.add("3 4 5 3");
        dataList.add("4 2 1 5");
        dataList.add("4 5 4 3");
        return new Object[][]{{dataList}};
    }

    @Test(dataProvider = "data-matrix-equals")
    public void parseTempMatrixTestPositive(List<String> inputData) {
        Parser parser = new Parser();
        Integer[][] matrix = {{3, 4, 5, 3}, {4, 2, 1, 5}, {4, 5, 4, 3}};
        Assert.assertEquals(matrix, parser.parseMatrixElement(inputData));
    }

    @DataProvider(name = "badTempData-matrix-equals")
    public Object[][] dataProviderParseTempMatrixNegative() {
        List<String> dataList = new ArrayList<>();
        dataList.add("3 4 53");
        dataList.add("s S1 5");
        dataList.add("4 5 a 3");
        return new Object[][]{{dataList}};
    }

    @Test(dataProvider = "badTempData-matrix-equals")
    public void parseTempMatrixTestNegative(List<String> inputData) {
        Parser parser = new Parser();
        Integer[][] matrix = new Integer[0][0];
        Assert.assertEquals(matrix, parser.parseMatrixElement(inputData));
    }
}
