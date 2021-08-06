package by.serzhant.branching_app.service.commands;

import by.serzhant.branching_app.entity.Function;
import by.serzhant.branching_app.service.DaoReader;
import by.serzhant.branching_app.service.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CalculateABSFunction implements Command {
    private final static Logger LOGGER = LogManager.getLogger(CalculateABSFunction.class);
    private static final String DAO_PATH = "./Branching/src/main/java/by/serzhant/branching_app/database/task7/inputvaluesfortask7";

    @Override
    public Object execute() {
        DaoReader reader = new DaoReader();
        Validator validator = new Validator();

        List<String> listInputValues = reader.readDaoFile(DAO_PATH);

        if (validator.isValidInputValue(listInputValues)) {
            double firstValue;
            double secondValue;
            double thirdValue;
            double foursValue;

            try {
                firstValue = Double.parseDouble(listInputValues.get(0));
                secondValue = Double.parseDouble(listInputValues.get(1));
                thirdValue = Double.parseDouble(listInputValues.get(2));
                foursValue = Double.parseDouble(listInputValues.get(3));
            } catch (RuntimeException e) {
                LOGGER.error("Ошибка в парсинге данных");
                return Validator.ERROR_MESSAGE;
            }

            Function function = new Function(firstValue, secondValue, thirdValue, foursValue);

            double result = Math.abs(function.getResult());
            LOGGER.info("Расчет выполнел, результат {}", result);

            return result;
        }

        return Validator.ERROR_MESSAGE;
    }
}
