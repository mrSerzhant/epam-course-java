package by.serzhant.uml.view;

import by.serzhant.uml.controller.Controller;
import by.serzhant.uml.view.console_processing.ConsolePrinter;
import by.serzhant.uml.view.console_processing.ConsoleReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

        while (true) {
            consolePrinter.printMenu();

            String inputValue = consoleReader.readInputValue();

            if (inputValue.equals("0")) {
                consolePrinter.printExitMessage();
                LOGGER.info("Завершение работы");
                return;
            }

            Controller controller = new Controller();
            Object response = controller.executeTask(inputValue);
            LOGGER.info("Выполнение программы № - {}", inputValue);

            consolePrinter.printResult(response);
        }
    }
}
