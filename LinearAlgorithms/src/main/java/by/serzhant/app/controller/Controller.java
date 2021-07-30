package by.serzhant.app.controller;

import by.serzhant.app.executors.*;
import by.serzhant.app.services.Informer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {
    private static final Logger LOGGER = LogManager.getLogger(Controller.class);

    private static final String NAME_TASK_2 = "2";
    private static final String NAME_TASK_7 = "7";
    private static final String NAME_TASK_17 = "17";
    private static final String NAME_TASK_22 = "22";
    private static final String NAME_TASK_32 = "32";
    private static final String TASK = "Задача № ";
    private static final String SUCCESS_MESSAGE = "Вычисление функции выполнено";
    private static final String INFO_MESSAGE = "Выполнение задачи ";

    public Controller() {
        Informer informer = new Informer();

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
                        LOGGER.info(INFO_MESSAGE + NAME_TASK_2);
                        informer.printResult(new CalculateFunction());
                        LOGGER.info(SUCCESS_MESSAGE);
                        break;
                    case NAME_TASK_7:
                        LOGGER.info(INFO_MESSAGE + NAME_TASK_7);
                        informer.printResult(new CalculateRectangleSquare());
                        LOGGER.info(SUCCESS_MESSAGE);
                        break;
                    case NAME_TASK_17:
                        LOGGER.info(INFO_MESSAGE + NAME_TASK_7);
                        informer.printResult(new CalculateMath());
                        LOGGER.info(SUCCESS_MESSAGE);
                        break;
                    case NAME_TASK_22:
                        LOGGER.info(INFO_MESSAGE + NAME_TASK_22);
                        informer.printResult(new TimeTransformer());
                        LOGGER.info(SUCCESS_MESSAGE);
                        break;
                    case NAME_TASK_32:
                        LOGGER.info(INFO_MESSAGE + NAME_TASK_32);
                        informer.printResult(new CalculateTime());
                        LOGGER.info(SUCCESS_MESSAGE);
                        break;
                    case "0":
                        LOGGER.info("Выход");
                        return;
                    default:
                        System.out.println("Ошибка");
                        LOGGER.info("Ошибка выбора");
                        break;
                }
            }
        } catch (IOException e) {
            LOGGER.error("Ошибка чтения");
        }
    }
}
