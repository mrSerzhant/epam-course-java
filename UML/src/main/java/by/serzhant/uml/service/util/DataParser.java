package by.serzhant.uml.service.util;

import by.serzhant.uml.entity.*;
import by.serzhant.uml.entity.typecar.Sedan;
import by.serzhant.uml.service.validator.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class DataParser {
    private static final Logger LOGGER = LogManager.getLogger(DataParser.class);
    private Validator validator = new Validator();

    public List<Car> parse(List<String> inputList) {
        List<Car> listCar = new ArrayList<>();
        List<String> tempData;

        for (String dataString : inputList) {
            tempData = Arrays.asList(dataString.split(" "));

            String brand;
            String engineBrand;
            int enginePower;
            int countWheels;
            int diameterWheel;
            double fuelCapacity;

            if (tempData.get(0).equals("sedan")) {
                brand = tempData.get(1);
                engineBrand = tempData.get(2);

                if (!validator.isValidEnginePower(tempData.get(3))) {
                    LOGGER.error("can not create car, invalid engine power");
                    continue;
                }

                enginePower = Integer.parseInt(tempData.get(3));

                if (!validator.isValidCountWheels(tempData.get(4))) {
                    LOGGER.error("can not create car, invalid count of wheels");
                    continue;
                }

                countWheels = Integer.parseInt(tempData.get(4));

                if (countWheels > 4) {
                    LOGGER.error("can not create car, invalid count of wheels");
                    continue;
                }

                if (!validator.isValidDiameterWheel(tempData.get(5))) {
                    LOGGER.error("can not create car, invalid diameter of wheels");
                    continue;
                }

                diameterWheel = Integer.parseInt(tempData.get(5));

                if (!validator.isValidFuelCapacity(tempData.get(6))) {
                    fuelCapacity = 0;
                }else{
                    fuelCapacity = Double.parseDouble(tempData.get(6));
                }

                Map<String, Wheel> chassisMap = new HashMap<>();

                for (int i = 0; i < countWheels; i++) {
                    chassisMap.put(String.valueOf(i), new Wheel(diameterWheel));
                }

                FuelTank fuelTank = new FuelTank(fuelCapacity);
                LOGGER.info("{} {}", "FuelTank created", fuelTank);

                Chassis chassis = new Chassis(chassisMap);
                LOGGER.info("{} {}", "Chassis created", chassisMap);

                Engine engine = new Engine(engineBrand, enginePower);
                LOGGER.info("{} {}", "Engine created", engine);

                Car car = new Sedan(brand, engine, chassis, fuelTank);
                LOGGER.info("{} ", "Car created");

                listCar.add(car);
            }
        }

        return listCar;
    }
}
