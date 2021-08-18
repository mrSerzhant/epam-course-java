package by.serzhant.array_app.service;

import by.serzhant.array_app.database.data_processing.DaoReader;
import by.serzhant.array_app.service.command.Command;
import by.serzhant.array_app.service.exception.SortException;
import by.serzhant.array_app.service.validator.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ArrayBuilder {
    private static final Logger LOGGER = LogManager.getLogger(ArrayBuilder.class);
    private static final String DAO_PATH = "./Arrays/src/main/java/by/serzhant/array_app/database/array/array";
    private Validator validator = new Validator();
    private Double[] array;

    public ArrayBuilder() {
        array = build();
    }

    private Double[] build() {

        DaoReader reader = new DaoReader();
        List<String> stringList = reader.readDaoFile(DAO_PATH);

        Double[] tempArray = new Double[stringList.size()];

        for (int i = 0; i < stringList.size(); i++) {

            try {
                tempArray[i] = Double.parseDouble(stringList.get(i));
            } catch (NumberFormatException e) {
                return new Double[0];
            }
        }

        return tempArray;
    }


    public Double[] getArray() {
        return array;
    }
}
