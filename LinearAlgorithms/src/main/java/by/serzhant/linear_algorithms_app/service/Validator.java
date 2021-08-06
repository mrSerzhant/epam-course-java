package by.serzhant.linear_algorithms_app.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Validator {
    private static final Logger logger = LogManager.getLogger(Validator.class);
    private static final String ERROR_MESSAGE = "Некорректный ввод ";

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
            if (Double.parseDouble(numeral) < 0) {
                logger.warn(ERROR_MESSAGE + numeral);
                return false;
            }
            return true;
        } catch (NumberFormatException error) {
            logger.warn(error.toString());
            return false;
        }
    }

    public boolean isValidTime(String numeral) {
        try {
            if (Double.parseDouble(numeral) < 0 || Double.parseDouble(numeral) > 59) {
                logger.warn(ERROR_MESSAGE + numeral);
                return false;
            }
            return true;
        } catch (NumberFormatException error) {
            logger.warn(error.toString());
            return false;
        }
    }

    public boolean isValidHour(String numeral) {
        try {
            if (Double.parseDouble(numeral) < 0 || Double.parseDouble(numeral) > 23) {
                logger.warn(ERROR_MESSAGE + numeral);
                return false;
            }
            return true;
        } catch (NumberFormatException error) {
            logger.warn(error.toString());
            return false;
        }
    }
}
