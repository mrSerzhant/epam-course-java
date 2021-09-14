package by.serzhant.uml.service.util;

import by.serzhant.uml.entity.*;
import by.serzhant.uml.entity.typecar.Sedan;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataParserTest {

    public static Object[][] DataParseTestData() {
        FuelTank fuelTank = new FuelTank(50);

        Map<String, Wheel> mapWheels = new HashMap<>();
        mapWheels.put("1", new Wheel(35));
        mapWheels.put("2", new Wheel(35));
        mapWheels.put("3", new Wheel(35));
        mapWheels.put("4", new Wheel(35));

        Chassis chassis = new Chassis(mapWheels);

        Engine engine = new Engine("XZ", 330);
        Car car = new Sedan("bmw", engine, chassis, fuelTank);

        return new Object[][]{{car}};
    }

    public static Object[][] DataParseTestDataNegative() {
        FuelTank fuelTank = new FuelTank(80);

        Map<String, Wheel> mapWheels = new HashMap<>();
        mapWheels.put("1", new Wheel(35));
        mapWheels.put("2", new Wheel(35));
        mapWheels.put("3", new Wheel(35));

        Chassis chassis = new Chassis(mapWheels);

        Engine engine = new Engine("XZ", 350);
        Car car = new Sedan("bmw", engine, chassis, fuelTank);

        return new Object[][]{{car}};
    }

    @ParameterizedTest
    @MethodSource("DataParseTestData")
    public void DataParseTest(Car car) {
        Path path = Paths.get("src/test/resources/testdata/MovableCar");
        List<String> dataList;

        try {
            dataList = Files.readAllLines(path);
        } catch (IOException e) {
            dataList = new ArrayList<>();
        }

        DataParser parser = new DataParser();
        Assertions.assertEquals(car, parser.parse(dataList).get(0));
    }

    @ParameterizedTest
    @MethodSource("DataParseTestDataNegative")
    public void DataParseTestNegative(Car car) {
        Path path = Paths.get("src/test/resources/testdata/MovableCar");
        List<String> dataList;

        try {
            dataList = Files.readAllLines(path);
        } catch (IOException e) {
            dataList = new ArrayList<>();
        }

        DataParser parser = new DataParser();
        Assertions.assertNotEquals(car, parser.parse(dataList).get(0));
    }
}
