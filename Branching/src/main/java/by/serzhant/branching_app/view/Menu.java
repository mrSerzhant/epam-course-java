package by.serzhant.branching_app.view;

import by.serzhant.branching_app.controller.CommandsFactory;
import by.serzhant.branching_app.service.command.Command;
import by.serzhant.branching_app.view.concolep_rocessing.ConsolePrinter;
import by.serzhant.branching_app.view.concolep_rocessing.ConsoleReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author alexandr
 * @version 1.0
 */

public class Menu {
    private final static Logger LOGGER = LogManager.getLogger(Menu.class);

    public Menu() {
        run();
    }

    private void run() {
        ConsoleReader consoleReader = new ConsoleReader();
        ConsolePrinter.printSetLanguageInfo();

        ConsolePrinter consolePrinter = new ConsolePrinter(consoleReader.readInputValue());
        CommandsFactory factory = CommandsFactory.getInstance();

        while (true) {
            consolePrinter.printMenu();

            String inputValue = consoleReader.readInputValue();

            if (inputValue.equals("0")) {
                consolePrinter.printExitMessage();
                LOGGER.info("Завершение работы");
                return;
            }

            Command command = factory.getCommand(inputValue);
            LOGGER.info("Выполнение программы № - {}", inputValue);

            Object result;

            try {
                result = command.execute();
            } catch (RuntimeException e) {
                LOGGER.error("Неверный аргумент");
                result = consolePrinter.getInvalidArgumentMessage();
            }
            consolePrinter.printResult(result);

            LOGGER.info("Результат выполения - {}", result);
        }
    }
}
