package by.serzhant.app.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Validator {
    private static final Logger logger = LogManager.getLogger(Validator.class);


    public boolean isNumeral(String numeral) {
        try {
            Double.parseDouble(numeral);
            return true;
        } catch (NumberFormatException error) {
            logger.warn(error.toString());
            return false;
        }
    }

    public boolean isPositiveNumeral(String numeral) {
        try {
            if (Double.parseDouble(numeral) <= 0) {
                logger.warn("Некоректный ввод " + numeral);
                return false;
            }
            return true;
        } catch (NumberFormatException error) {
            logger.warn(error.toString());
            return false;
        }
    }

}
