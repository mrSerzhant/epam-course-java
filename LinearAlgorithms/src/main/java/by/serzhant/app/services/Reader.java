package by.serzhant.app.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {
    private static final String INFORM_MESSAGE = "Введите число:";
    private static final String ERROR_MESSAGE = "Введите число:";

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Validator validator = new Validator();


    public double readNumber() {
        while (true) {
            System.out.println(INFORM_MESSAGE);

            try {
                String inputMessage = reader.readLine();

                if (validator.isValidNumber(inputMessage)) {
                    return Double.parseDouble(inputMessage);
                }
            } catch (IOException e) {
                System.out.println(ERROR_MESSAGE);
            }
        }
    }


}
