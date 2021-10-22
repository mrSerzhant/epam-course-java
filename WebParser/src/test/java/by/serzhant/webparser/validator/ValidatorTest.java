package by.serzhant.webparser.validator;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.URL;

public class ValidatorTest {

    @Test()
    public void fileValidatorPositive() {
        URL xmlUrl = ValidatorTest.class.getClassLoader().getResource("valid.xml");
        URL xsdUrl = ValidatorTest.class.getClassLoader().getResource("xsd/schema.xsd");

        FileValidator validator = new FileValidator();
        Assert.assertTrue(validator.isValidXML(xmlUrl.getPath(), xsdUrl.getPath()));
    }

    @Test()
    public void fileValidatorNegative() {
        URL xmlUrl = ValidatorTest.class.getClassLoader().getResource("invalid.xml");
        URL xsdUrl = ValidatorTest.class.getClassLoader().getResource("xsd/schema.xsd");

        FileValidator validator = new FileValidator();
        Assert.assertFalse(validator.isValidXML(xmlUrl.getPath(), xsdUrl.getPath()));
    }
}
