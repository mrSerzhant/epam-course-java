package by.serzhant.branching_app.service.commands;

import by.serzhant.branching_app.service.DaoReader;
import by.serzhant.branching_app.service.DaoWriter;
import by.serzhant.branching_app.service.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ChangeNumeral implements Command {
    private final static Logger LOGGER = LogManager.getLogger(ChangeNumeral.class);
    private static final String DAO_PATH = "./Branching/src/main/java/by/serzhant/branching_app/database/task17/inputvaluesfortask17";

    @Override
    public Object execute() {
        DaoReader reader = new DaoReader();
        Validator validator = new Validator();

        List<String> listInputValues = reader.readDaoFile(DAO_PATH);

        if (validator.isValidInputValue(listInputValues)) {
            int firstValue;
            int secondValue;

            try {
                firstValue = Integer.parseInt(listInputValues.get(0));
                secondValue = Integer.parseInt(listInputValues.get(1));
            } catch (RuntimeException e) {
                LOGGER.error("Ошибка в парсинге данных");
                return Validator.ERROR_MESSAGE;
            }

            DaoWriter writer = new DaoWriter();

            if (firstValue == secondValue) {
                writer.writeDaoFile(DAO_PATH, 0, 0);
                LOGGER.info("Результат выполнения: 0-0");
                return "0 0";
            } else if (firstValue < secondValue) {
                writer.writeDaoFile(DAO_PATH, secondValue, secondValue);
                LOGGER.info("Результат выполнения {}, {}", secondValue, secondValue);
                return String.format("%d %d", secondValue, secondValue);
            } else {
                writer.writeDaoFile(DAO_PATH, firstValue, firstValue);
                LOGGER.info("Результат выполнения {}, {}", firstValue, firstValue);
                return String.format("%d %d", firstValue, firstValue);
            }
        }

        return Validator.ERROR_MESSAGE;
    }
}
