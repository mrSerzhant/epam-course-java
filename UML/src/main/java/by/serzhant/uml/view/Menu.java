package by.serzhant.uml.view;

import by.serzhant.uml.controller.Controller;
import by.serzhant.uml.view.consoleprocessing.ConsolePrinter;
import by.serzhant.uml.view.consoleprocessing.ConsoleReader;
import by.serzhant.uml.view.consoleprocessing.RequestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс является связующим звеном между пользователем и внутренней системой программы
 */

public class Menu {
    private static final Logger LOGGER = LogManager.getLogger(Menu.class);

    public Menu() {
        run();
    }

    private void run() {
        ConsoleReader consoleReader = new ConsoleReader();
        ConsolePrinter.printSetLanguageInfo();

        ConsolePrinter consolePrinter = new ConsolePrinter(consoleReader.readInputValue());

        Controller controller = new Controller();
        RequestController requestController = new RequestController(consolePrinter);

        while (true) {
            consolePrinter.printMenu();

            String inputValue = consoleReader.readInputValue();

            if (inputValue.equals("0") || inputValue.isEmpty()) {
                consolePrinter.printExitMessage();
                LOGGER.info("Завершение работы");
                return;
            }

            Object response = controller.executeTask(requestController.execute(inputValue));
            LOGGER.info("Выполнение программы № - {}", inputValue);

            consolePrinter.printResult(response);
        }
    }
}
