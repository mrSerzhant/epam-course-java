package by.serzhant.thread.view;

import by.serzhant.thread.controller.Controller;
import by.serzhant.thread.view.console_processing.ConsolePrinter;
import by.serzhant.thread.view.console_processing.ConsoleReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 Класс является связующим звеном между пользователем и внутренней системой программы
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

        while (true) {
            consolePrinter.printMenu();

            String inputValue = consoleReader.readInputValue();

            if (inputValue.equals("0") || inputValue.isEmpty()) {
                consolePrinter.printExitMessage();
                LOGGER.info("Завершение работы");
                return;
            }

            Object response = controller.executeTask(inputValue);
            LOGGER.info("Выполнение программы № - {}", inputValue);

            consolePrinter.printResult(response);
        }
    }
}
