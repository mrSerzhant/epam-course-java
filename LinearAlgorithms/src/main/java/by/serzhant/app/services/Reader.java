package by.serzhant.app.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {
    private static final String INFORM_MESSAGE = "Введите число:";
    private static final String ERROR_MESSAGE = "Ошибка ввода";
    private static final Logger LOGGER = LogManager.getLogger(Reader.class);
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Validator validator = new Validator();

    public double readNumeral() {
        while (true) {
            System.out.println(INFORM_MESSAGE);

            try {
                String inputMessage = reader.readLine();

                if (validator.isNumeral(inputMessage)) {
                    LOGGER.info(inputMessage);
                    return Double.parseDouble(inputMessage);
                }
                System.out.println(ERROR_MESSAGE);
            } catch (IOException e) {
                System.out.println(ERROR_MESSAGE);
            }
        }
    }

    public double readPositiveNumeral() {
        while (true) {
            System.out.println(INFORM_MESSAGE);

            try {
                String inputMessage = reader.readLine();

                if (validator.isPositiveNumeral(inputMessage)) {
                    LOGGER.info(inputMessage);
                    return Double.parseDouble(inputMessage);
                }
                System.out.println(ERROR_MESSAGE);
            } catch (IOException e) {
                System.out.println(ERROR_MESSAGE);
            }
        }
    }

    public double readValidTime() {
        while (true) {
            System.out.println(INFORM_MESSAGE);

            try {
                String inputMessage = reader.readLine();

                if (validator.isValidTime(inputMessage)) {
                    LOGGER.info(inputMessage);
                    return Double.parseDouble(inputMessage);
                }
                System.out.println(ERROR_MESSAGE);
            } catch (IOException e) {
                System.out.println(ERROR_MESSAGE);
            }
        }
    }

    public double readValidHours() {
        while (true) {
            System.out.println(INFORM_MESSAGE);

            try {
                String inputMessage = reader.readLine();

                if (validator.isValidHours(inputMessage)) {
                    LOGGER.info(inputMessage);
                    return Double.parseDouble(inputMessage);
                }
                System.out.println(ERROR_MESSAGE);
            } catch (IOException e) {
                System.out.println(ERROR_MESSAGE);
            }
        }
    }
}
