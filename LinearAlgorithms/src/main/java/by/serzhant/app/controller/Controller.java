package by.serzhant.app.controller;

import by.serzhant.app.executers.CalculateFunction;
import by.serzhant.app.services.Informer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {
    private static Logger logger = LogManager.getLogger(Controller.class);

    private static final String NAME_TASK_2 = "2";
    private static final String NAME_TASK_7 = "7";
    private static final String NAME_TASK_17 = "17";
    private static final String NAME_TASK_22 = "22";
    private static final String NAME_TASK_32 = "32";
    private static final String TASK = "Задача № ";

    public Controller() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            while (true) {
                System.out.println(TASK + NAME_TASK_2);
                System.out.println(TASK + NAME_TASK_7);
                System.out.println(TASK + NAME_TASK_17);
                System.out.println(TASK + NAME_TASK_22);
                System.out.println(TASK + NAME_TASK_32);
                System.out.println("0 для выхода");
                System.out.println("Введите номер задачи:");

                switch (reader.readLine()) {
                    case NAME_TASK_2:
                        Informer informer = new Informer();
                        informer.printResult(new CalculateFunction());
                        logger.info("Вычисление функции");
                        break;
                    case NAME_TASK_7:

                        break;
                    case NAME_TASK_17:

                        break;
                    case NAME_TASK_22:

                        break;
                    case NAME_TASK_32:

                        break;
                    case "0":
                        return;
                    default:
                        System.out.println("Ошибка");
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
