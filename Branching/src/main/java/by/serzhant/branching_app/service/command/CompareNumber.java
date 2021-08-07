package by.serzhant.branching_app.service.command;

import by.serzhant.branching_app.database.dataprocessing.DaoReader;
import by.serzhant.branching_app.service.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CompareNumber implements Command {
    private final static Logger LOGGER = LogManager.getLogger(CompareNumber.class);
    private static final String DAO_PATH = "./Branching/src/main/java/by/serzhant/branching_app/database/task2/inputvaluesfortask2";

    @Override
    public Object execute() {
        DaoReader reader = new DaoReader();
        Validator validator = new Validator();

        List<String> listInputValues = reader.readDaoFile(DAO_PATH);

        if (validator.isValidInputValue(listInputValues)) {
            double firstValue;
            double secondValue;

            try {
                firstValue = Double.parseDouble(listInputValues.get(0));
                secondValue = Double.parseDouble(listInputValues.get(1));
            } catch (RuntimeException e) {
                LOGGER.error("Ошибка в парсинге данных");
                return Command.ERROR_MESSAGE;
            }

            String response = Command.NO_MESSAGE;
            if (firstValue < secondValue) {
                response = Command.YES_MESSAGE;
                LOGGER.info(Command.SUCCESS_EXECUTION_MESSAGE +" {}", response);
                return response;
            }

            return response;
        }

        return Command.ERROR_MESSAGE;
    }
}
