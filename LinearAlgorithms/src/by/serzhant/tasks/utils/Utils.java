package by.serzhant.tasks.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Utils {
    private static final String ERROR_MESSAGE = "Ошибка";
    private static final String INFORM_MESSAGE = "Введите число:";

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static double getInputValue() {
        while (true) {
            System.out.println(INFORM_MESSAGE);

            try {
                return Double.parseDouble(reader.readLine());
            } catch (Exception e) {
                System.out.println(ERROR_MESSAGE);
            }
        }
    }

    public static int getInputNaturalValue() {
        int tempValue;

        while (true) {
            System.out.println(INFORM_MESSAGE);

            try {
                tempValue = Integer.parseInt(reader.readLine());

                if (tempValue >= 1) {
                    return tempValue;
                }

                System.out.println(ERROR_MESSAGE);
            } catch (Exception e) {
                System.out.println(ERROR_MESSAGE);
            }
        }
    }

    public static int getInputSpecialNaturalValue() {
        int tempValue;

        while (true) {
            System.out.println(INFORM_MESSAGE);

            try {
                tempValue = Integer.parseInt(reader.readLine());

                if (tempValue >= 0) {
                    return tempValue;
                }

                System.out.println(ERROR_MESSAGE);
            } catch (Exception e) {
                System.out.println(ERROR_MESSAGE);
            }
        }
    }

    public static void printResult(String str) {
        System.out.println("Результат: " + str + "\n");
    }
}
