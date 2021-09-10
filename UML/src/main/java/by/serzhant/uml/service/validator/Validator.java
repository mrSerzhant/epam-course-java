package by.serzhant.uml.service.validator;

import by.serzhant.uml.entity.Car;
import by.serzhant.uml.entity.Wheel;
import by.serzhant.uml.entity.typecar.Sedan;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

public class Validator {
    private static final Logger LOGGER = LogManager.getLogger(Validator.class);
    private static final String ERROR_MESSAGE = "Incorrect Input Value";
    private static final String SUCCESS_MESSAGE = "Correct Input Value";

    public boolean isCorrectCarNumber(String inputString, List<Car> inputCarList) {
        if (isNumeral(inputString) && Integer.parseInt(inputString) > 0
                && Integer.parseInt(inputString) < inputCarList.size() + 1) {

            LOGGER.info(SUCCESS_MESSAGE);
            return true;
        }

        LOGGER.error(ERROR_MESSAGE);
        return false;
    }

    public boolean isValidEnginePower(String inputValue) {
        try {
            int powerValue = Integer.parseInt(inputValue);
            return powerValue > 0;
        } catch (NumberFormatException e) {
            LOGGER.error("Invalid engine power");
            return false;
        }
    }

    public boolean isValidCountWheels(String inputValue) {
        try {
            int countWheels = Integer.parseInt(inputValue);

            return countWheels >= 0;
        } catch (NumberFormatException e) {
            LOGGER.error("Invalid count of wheels");
            return false;
        }
    }

    public boolean isValidDiameterWheel(String inputValue) {
        try {
            int diameter = Integer.parseInt(inputValue);

            return diameter > 0;
        } catch (NumberFormatException e) {
            LOGGER.error("Invalid diameter of wheel");
            return false;
        }
    }

    public boolean isValidFuelCapacity(String inputValue) {
        try {
            int fuelCapacity = Integer.parseInt(inputValue);
            return fuelCapacity >= 0;
        } catch (NumberFormatException e) {
            LOGGER.error("Invalid fuel capacity");
            return false;
        }

    }

    public boolean isValidData(List<Car> inputList) {
        return !inputList.isEmpty();
    }

    public boolean isMovableCar(Car car) {
        Map<String, Wheel> chassis = car.getChassis().getChassis();

        if (car instanceof Sedan) {
            return chassis.size() == 4;
        }

        return false;
    }

    private boolean isNumeral(String inputString) {
        try {
            Integer.parseInt(inputString);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
