package by.serzhant.array_app.view;


import by.serzhant.array_app.controller.SortsFactory;
import by.serzhant.array_app.entity.Message;
import by.serzhant.array_app.service.command.Command;
import by.serzhant.array_app.view.console_processing.ConsoleReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author alexander
 * @version 1.0
 */

public class Menu {
    private final static Logger LOGGER = LogManager.getLogger(Menu.class);

    public Menu() {
        run();
    }

    private void run() {
    /*
        ConsolePrinter.printSetLanguageInfo();

        ConsolePrinter consolePrinter = new ConsolePrinter(consoleReader.readInputValue());


        while (true) {
            consolePrinter.printMenu();

            String inputValue = consoleReader.readInputValue();

            if (inputValue.equals("0")) {
                consolePrinter.printExitMessage();
                LOGGER.info("Завершение работы");
                return;
            }*/


        ConsoleReader consoleReader = new ConsoleReader();
        SortsFactory factory = SortsFactory.getInstance();
        String inputValue = consoleReader.readInputValue();


        Command command = factory.getCommand(inputValue);
        LOGGER.info("Выполнение программы № - {}", inputValue);

        Message result;

        try {
            result = command.sort();
        } catch (RuntimeException e) {
            LOGGER.error("Неверный аргумент");
            result = null;
            // result = consolePrinter.getInvalidArgumentMessage();
        }

        System.out.println(result.toString());

        //  consolePrinter.printResult(result);
        //  LOGGER.info("Результат выполения - {}", result);
    }
}

