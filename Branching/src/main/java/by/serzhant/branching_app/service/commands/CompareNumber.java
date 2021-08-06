package by.serzhant.branching_app.service.commands;

import by.serzhant.branching_app.service.DaoReader;
import by.serzhant.branching_app.service.Validator;
import by.serzhant.branching_app.view.Menu;
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

        if (validator.isValidInputValue(listInputValues) && listInputValues.size() == 2) {
            int firstValue;
            int secondValue;

            try {
                firstValue = Integer.parseInt(listInputValues.get(0));
                secondValue = Integer.parseInt(listInputValues.get(1));
            } catch (NumberFormatException e) {
                LOGGER.error("Ошибка в парсинге данных");
                return Validator.ERROR_MESSAGE;
            }

            String response = "no";
            if (firstValue < secondValue) {
                response = "yes";
                LOGGER.info("Расчет выполнел, результат {}", response);
                return response;
            }

            return response;
        }

        return Validator.ERROR_MESSAGE;
    }
}
