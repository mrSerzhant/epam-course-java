package by.serzhant.loop_app.view;

import by.serzhant.loop_app.controller.CommandsFactory;
import by.serzhant.loop_app.service.command.Command;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
