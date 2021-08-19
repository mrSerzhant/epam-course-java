package by.serzhant.array_app.view;


import by.serzhant.array_app.controller.CommandsFactory;
import by.serzhant.array_app.service.command.Command;
import by.serzhant.array_app.view.console_processing.ConsolePrinter;
import by.serzhant.array_app.view.console_processing.ConsoleReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author alexander
 * @version 1.0
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

            try {
                Object result = command.execute();
                consolePrinter.printResult(result);
            } catch (Exception e) {
                consolePrinter.printResult(e.getMessage());
            }
        }
    }
}
