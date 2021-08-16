package by.serzhant.array_app.service.command;

import by.serzhant.array_app.database.data_processing.DaoReader;
import by.serzhant.array_app.service.validator.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class BubbleSort implements Command{
    private final static Logger LOGGER = LogManager.getLogger(BubbleSort.class);
    private static final String DAO_PATH = "./Arrays/src/main/java/by/serzhant/array_app/database/array/array";


    @Override
    public Object execute() {
        DaoReader reader = new DaoReader();
        Validator validator = new Validator();

        List<String> listInputValues = reader.readDaoFile(DAO_PATH);


        if (validator.isValidInputValue(listInputValues)) {


        }

return null;
    }

}
