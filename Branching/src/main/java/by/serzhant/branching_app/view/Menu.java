package by.serzhant.branching_app.view;

import by.serzhant.branching_app.controller.CommandsFactory;
import by.serzhant.branching_app.service.commands.Command;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Menu {
    private final static Logger LOGGER = LogManager.getLogger(Menu.class);

    public Menu() {
        run();
    }

    private void run() {
        Printer printer = new Printer();
        Reader reader = new Reader();
        CommandsFactory factory = CommandsFactory.getInstance();

        while (true) {
            printer.printMenu();

            String inputValue = reader.readInputValue();

            if (inputValue.equals("0")) {
                printer.printExitMessage();
                LOGGER.info("Завершение работы");
                return;
            }

            Command command = factory.getCommand(inputValue);
            LOGGER.info("Выполнение программы № - {}",inputValue);

            Object result = command.execute();
            printer.printResult(result);

            LOGGER.info("Результат выполения - {}",printer.getResult(result));
        }
    }
}
