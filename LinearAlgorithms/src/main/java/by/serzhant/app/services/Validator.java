package by.serzhant.app.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Validator {
    private static final Logger logger = LogManager.getLogger(Validator.class);



    public boolean isValidNumber(String number) {
        try {
            Double.parseDouble(number);
            return true;
        } catch(NumberFormatException error) {
            logger.info(error.toString());
            return false;
        }
    }


}
