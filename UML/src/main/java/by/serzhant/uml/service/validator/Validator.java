package by.serzhant.uml.service.validator;

import by.serzhant.uml.entity.Car;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

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

        LOGGER.info(ERROR_MESSAGE);
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
