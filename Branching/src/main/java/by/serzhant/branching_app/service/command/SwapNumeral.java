package by.serzhant.branching_app.service.command;

import by.serzhant.branching_app.database.data_processing.DaoReader;
import by.serzhant.branching_app.database.data_processing.DaoWriter;
import by.serzhant.branching_app.service.validator.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class SwapNumeral implements Command {
    private final static Logger LOGGER = LogManager.getLogger(SwapNumeral.class);
    private static final String DAO_PATH = "./Branching/src/main/java/by/serzhant/branching_app/database/task22/inputvaluesfortask22";

    @Override
    public Object execute() {
        DaoReader reader = new DaoReader();
        Validator validator = new Validator();

        List<String> listInputValues = reader.readDaoFile(DAO_PATH);

        if (validator.isValidInputValue(listInputValues)) {
            double x;
            double y;

            try {
                x = Double.parseDouble(listInputValues.get(0));
                y = Double.parseDouble(listInputValues.get(1));
            } catch (RuntimeException e) {
                LOGGER.error("Ошибка в парсинге данных");
                return Command.ERROR_MESSAGE;
            }

            DaoWriter writer = new DaoWriter();

            if (x > y) {
                LOGGER.info(Command.SUCCESS_EXECUTION_MESSAGE + " {}, {}", x, y);
                return String.format("%f %f", x, y);
            }

            List<String> newList = writer.writeDaoFile(DAO_PATH, y, x);

            LOGGER.info(Command.SUCCESS_EXECUTION_MESSAGE + " {}, {}", newList.get(0), newList.get(1));
            return String.format("%s %s ", newList.get(0), newList.get(1));
        }

        return Command.ERROR_MESSAGE;
    }
}
