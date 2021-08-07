package by.serzhant.branching_app.service.command;

import by.serzhant.branching_app.database.data_processing.DaoReader;
import by.serzhant.branching_app.service.validator.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class FindPositiveSum implements Command {
    private final static Logger LOGGER = LogManager.getLogger(FindPositiveSum.class);
    private static final String DAO_PATH = "./Branching/src/main/java/by/serzhant/branching_app/database/task32/inputvaluesfortask32";

    @Override
    public Object execute() {
        DaoReader reader = new DaoReader();
        Validator validator = new Validator();

        List<String> listInputValues = reader.readDaoFile(DAO_PATH);

        if (validator.isValidInputValue(listInputValues)) {
            double firstValue;
            double secondValue;
            double thirdValue;

            try {
                firstValue = Double.parseDouble(listInputValues.get(0));
                secondValue = Double.parseDouble(listInputValues.get(1));
                thirdValue = Double.parseDouble(listInputValues.get(2));
            } catch (RuntimeException e) {
                LOGGER.error("Ошибка в парсинге данных");
                return Command.ERROR_MESSAGE;
            }

            if (firstValue + secondValue > 0) {
                LOGGER.info(Command.SUCCESS_EXECUTION_MESSAGE + "{}", firstValue + secondValue);
                return firstValue + secondValue;
            } else if (firstValue + thirdValue > 0) {
                LOGGER.info(Command.SUCCESS_EXECUTION_MESSAGE + "{}", firstValue + thirdValue);
                return firstValue + thirdValue;
            } else if (secondValue + thirdValue > 0) {
                LOGGER.info(Command.SUCCESS_EXECUTION_MESSAGE + "{}", secondValue + thirdValue);
                return secondValue + thirdValue;
            }

            return Command.INVALID_RESULT_MESSAGE;
        }

        return Command.ERROR_MESSAGE;
    }
}
