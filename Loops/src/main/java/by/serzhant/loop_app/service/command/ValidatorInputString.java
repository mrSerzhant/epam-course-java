package by.serzhant.loop_app.service.command;

import by.serzhant.loop_app.database.dataprocessing.DaoReader;
import by.serzhant.loop_app.service.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ValidatorInputString implements Command {
    private final static Logger LOGGER = LogManager.getLogger(ValidatorInputString.class);
    private static final String DAO_PATH = "./Loops/src/main/java/by/serzhant/loop_app/database/task32/inputvaluesfortask32";
    private static final String LETTERS = "abcdefghijklmnopqrstuvwxyzабвгдеёжзийклмнопрстуфхцчшщъыьэюя_";
    private static final String NUMERALS = "0123456789";

    @Override
    public Object execute() {
        DaoReader reader = new DaoReader();
        Validator validator = new Validator();

        List<String> listInputValues = reader.readDaoFile(DAO_PATH);

        if (validator.isValidInputValue(listInputValues)) {
            String inputString = listInputValues.get(0);

            boolean firstCheck = false;
            boolean secondCheck = false;

            for (int i = 0; i < LETTERS.length(); i++) {

                if ((inputString.charAt(0) == LETTERS.charAt(i))) {
                    firstCheck = true;
                    break;
                }
            }

            for (int i = 1; i < inputString.length(); i++) {

                if (LETTERS.contains(String.valueOf(inputString.charAt(i))) || NUMERALS.contains(String.valueOf(inputString.charAt(i)))) {
                    secondCheck = true;
                } else {
                    LOGGER.info(Command.NOT_POSITIVE_RESULT_MESSAGE + " {}", Command.NO_MESSAGE);
                    return Command.NOT_POSITIVE_RESULT_MESSAGE;
                }
            }

            if (firstCheck && secondCheck) {
                LOGGER.info(Command.SUCCESS_EXECUTION_MESSAGE + " {}", Command.YES_MESSAGE);
                return Command.YES_MESSAGE;
            }
        }

        return Command.ERROR_MESSAGE;
    }
}
