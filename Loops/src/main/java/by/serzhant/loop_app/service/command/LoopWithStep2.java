package by.serzhant.loop_app.service.command;

import by.serzhant.loop_app.database.dataprocessing.DaoReader;
import by.serzhant.loop_app.service.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigInteger;
import java.util.List;

public class LoopWithStep2 implements Command {
    private final static Logger LOGGER = LogManager.getLogger(LoopWithStep2.class);
    private static final String DAO_PATH = "./Loops/src/main/java/by/serzhant/loop_app/database/task17/inputvaluesfortask17";

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

            if (!validator.isRealNumeral(secondValue)) {
                return Command.ERROR_MESSAGE;
            }

            BigInteger result = new BigInteger(String.valueOf(firstValue));

            for (int i = firstValue + 1; i <= firstValue + (secondValue - 1); i++) {
                result = result.multiply(BigInteger.valueOf(i));
            }

            LOGGER.info(Command.SUCCESS_EXECUTION_MESSAGE +" {}", result);
            return result;
        }

        return Command.ERROR_MESSAGE;
    }
}
