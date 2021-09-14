package by.serzhant.uml.service.validator;

import by.serzhant.uml.entity.Car;

import by.serzhant.uml.service.util.DataParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ValidatorTest {
    public static Object[][] EnginePowerTestData() {
        return new Object[][]{{"200"}, {"221"}, {"420"}, {"1"}, {"500"}, {"32"}, {"99"}};
    }

    public static Object[][] EnginePowerTestDataNegative() {
        return new Object[][]{{"-200"}, {"-221"}, {"-420"}, {"-1"}, {"-500"}, {"-32"}, {"-9"}};
    }

    @ParameterizedTest
    @MethodSource("EnginePowerTestData")
    public void isValidEnginePowerTest(String inputValue) {
        Validator validator = new Validator();
        Assertions.assertTrue(validator.isValidEnginePower(inputValue));
    }

    @ParameterizedTest
    @MethodSource("EnginePowerTestDataNegative")
    public void isValidEnginePowerTestNegative(String inputValue) {
        Validator validator = new Validator();
        Assertions.assertFalse(validator.isValidEnginePower(inputValue));
    }

    public static Object[][] CountWheelTestData() {
        return new Object[][]{{"1"}, {"3"}, {"0"}, {"10"}, {"20"}, {"8"}, {"5"}};
    }

    public static Object[][] CountWheelTestDataNegative() {
        return new Object[][]{{"-1"}, {"-3"}, {"-33"}, {"-10"}, {"-20"}, {"-8"}, {"-5"}};
    }

    @ParameterizedTest
    @MethodSource("CountWheelTestData")
    public void isValidCountWheelsTest(String inputValue) {
        Validator validator = new Validator();
        Assertions.assertTrue(validator.isValidCountWheels(inputValue));
    }

    @ParameterizedTest
    @MethodSource("CountWheelTestDataNegative")
    public void isValidCountWheelsTestNegative(String inputValue) {
        Validator validator = new Validator();
        Assertions.assertFalse(validator.isValidCountWheels(inputValue));
    }

    public static Object[][] DiameterWheelTestData() {
        return new Object[][]{{"1"}, {"3"}, {"2"}, {"10"}, {"20"}, {"8"}, {"5"}};
    }

    public static Object[][] DiameterWheelTestDataNegative() {
        return new Object[][]{{"-1"}, {"-3"}, {"-33"}, {"-10"}, {"-20"}, {"-8"}, {"-5"}};
    }

    @ParameterizedTest
    @MethodSource("DiameterWheelTestData")
    public void isValidDiameterWheelTest(String inputValue) {
        Validator validator = new Validator();
        Assertions.assertTrue(validator.isValidDiameterWheel(inputValue));
    }

    @ParameterizedTest
    @MethodSource("DiameterWheelTestDataNegative")
    public void isValidDiameterWheelTestNegative(String inputValue) {
        Validator validator = new Validator();
        Assertions.assertFalse(validator.isValidDiameterWheel(inputValue));
    }

    public static Object[][] FuelCapacityTestData() {
        return new Object[][]{{"1"}, {"3"}, {"2"}, {"0"}, {"20"}, {"8"}, {"5"}};
    }

    public static Object[][] FuelCapacityTestDataNegative() {
        return new Object[][]{{"-1"}, {"-3"}, {"-33"}, {"-10"}, {"-20"}, {"-8"}, {"-5"}};
    }

    @ParameterizedTest
    @MethodSource("FuelCapacityTestData")
    public void isValidFuelCapacityTest(String inputValue) {
        Validator validator = new Validator();
        Assertions.assertTrue(validator.isValidFuelCapacity(inputValue));
    }

    @ParameterizedTest
    @MethodSource("FuelCapacityTestDataNegative")
    public void isValidFuelCapacityTestNegative(String inputValue) {
        Validator validator = new Validator();
        Assertions.assertFalse(validator.isValidFuelCapacity(inputValue));
    }

    public static Object[][] DataTestData() {
        Path path = Paths.get("src/test/resources/testdata/CarList");
        List<String> dataList;

        try {
            dataList = Files.readAllLines(path);
        } catch (IOException e) {
            dataList = new ArrayList<>();
        }

        DataParser parser = new DataParser();
        return new Object[][]{{parser.parse(dataList)}};
    }

    public static Object[][] DataTestDataNegative() {
        List<Car> listCar = new ArrayList<>();
        return new Object[][]{{listCar}};
    }

    @ParameterizedTest
    @MethodSource("DataTestData")
    public void isValidDataTest(List<Car> inputValue) {
        Validator validator = new Validator();
        Assertions.assertTrue(validator.isValidData(inputValue));
    }

    @ParameterizedTest
    @MethodSource("DataTestDataNegative")
    public void isValidDataTestNegative(List<Car> inputValue) {
        Validator validator = new Validator();
        Assertions.assertFalse(validator.isValidData(inputValue));
    }

    public static Object[][] MovableCarTestData() {
        Path path = Paths.get("src/test/resources/testdata/MovableCar");
        List<String> dataList;

        try {
            dataList = Files.readAllLines(path);
        } catch (IOException e) {
            dataList = new ArrayList<>();
        }

        DataParser parser = new DataParser();
        return new Object[][]{{parser.parse(dataList).get(0)}};
    }

    public static Object[][] MovableCarTestDataNegative() {
        Path path = Paths.get("src/test/resources/testdata/UnMovableCar");
        List<String> dataList;

        try {
            dataList = Files.readAllLines(path);
        } catch (IOException e) {
            dataList = new ArrayList<>();
        }

        DataParser parser = new DataParser();
        return new Object[][]{{parser.parse(dataList).get(0)}};
    }

    @ParameterizedTest
    @MethodSource("MovableCarTestData")
    public void isMovableCarDataTest(Car car) {
        Validator validator = new Validator();
        Assertions.assertTrue(validator.isMovableCar(car));
    }

    @ParameterizedTest
    @MethodSource("MovableCarTestDataNegative")
    public void isMovableCarTestNegative(Car car) {
        Validator validator = new Validator();
        Assertions.assertFalse(validator.isMovableCar(car));
    }
}
