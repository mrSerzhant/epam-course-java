package by.serzhant.app.services;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ValidatorTest {

    @DataProvider(name = "data-provider")
    public Object[][] dataProviderNumeral() {
        return new Object[][]{{"-5"}, {"25"}, {"0"}, {"0.43"}, {"32"}, {"-4.5923"}};
    }

    @DataProvider(name = "positive-data-provider")
    public Object[][] dataProviderPositiveNumeral() {
        return new Object[][]{{"5"}, {"25"}, {"0"}, {"0.43"}, {"32"}, {"4.5923"}};
    }

    @DataProvider(name = "time-data-provider")
    public Object[][] dataProviderValidTime() {
        return new Object[][]{{"0"}, {"25"}, {"0"}, {"6"}, {"32"}, {"59"}};
    }

    @DataProvider(name = "hour-data-provider")
    public Object[][] dataProviderValidHour() {
        return new Object[][]{{"0"}, {"21"}, {"1"}, {"6"}, {"2"}, {"23"}};
    }

    @Test(dataProvider = "data-provider")
    public void isNumeralTest(String str) {
        Validator validator = new Validator();
        Assert.assertEquals(true, validator.isNumeral(str));
    }

    @Test (dataProvider = "positive-data-provider")
    public void isPositiveNumeralTest(String str) {
        Validator validator = new Validator();
        Assert.assertEquals(true, validator.isPositiveNumeral(str));
    }

    @Test (dataProvider = "time-data-provider")
    public void isValidTimeTest(String str) {
        Validator validator = new Validator();
        Assert.assertEquals(true, validator.isValidTime(str));
    }

    @Test (dataProvider = "hour-data-provider")
    public void isValidTimeHour(String str) {
        Validator validator = new Validator();
        Assert.assertEquals(true, validator.isValidHour(str));
    }
}
