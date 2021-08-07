package by.serzhant.loop_app.service.command;

import by.serzhant.loop_app.database.dataprocessing.DaoReader;
import by.serzhant.loop_app.service.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Loop implements Command {
    private final static Logger LOGGER = LogManager.getLogger(Loop.class);
    private static final String DAO_PATH = "./Loops/src/main/java/by/serzhant/loop_app/database/task2/inputvaluesfortask2";

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
                return Command.ERROR_MESSAGE;
            }

            StringBuilder stringBuilder = new StringBuilder();

            if (firstValue > secondValue) {

                for (int i = firstValue; i > secondValue; i--) {
                    stringBuilder.append(i).append(" ");
                }

                return stringBuilder;
            }

            for (int i = firstValue; i < secondValue; i++) {
                stringBuilder.append(i).append(" ");
            }

            return stringBuilder;

        }

        return Command.ERROR_MESSAGE;
    }
}
