package by.serzhant.array_app.service.validator;

import by.serzhant.array_app.entity.Array;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Validator {
    private static final Logger LOGGER = LogManager.getLogger(Validator.class);

    public boolean isValidArray(Array<?> inputArray){
        if (inputArray == null || inputArray.getLength() == 0) {
            LOGGER.error("Incorrect Input Array");
            return false;
        }

        return true;
    }
}
