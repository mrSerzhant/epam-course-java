package by.serzhant.array.service;

import by.serzhant.array.dal.DataReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ArrayBuilder {
    private static final Logger LOGGER = LogManager.getLogger(ArrayBuilder.class);
    private static final String DAO_PATH = "./Arrays/src/main/java/resources/data/array.txt";
    private Double[] array;

    public ArrayBuilder() {
        array = build();
    }

    /**
     Данный метод собирает обьект из исходных данных
     */

    private Double[] build() {
        DataReader reader = new DataReader();
        List<String> stringList = reader.readDaoFile(DAO_PATH);

        Double[] tempArray = new Double[stringList.size()];

        for (int i = 0; i < stringList.size(); i++) {

            try {
                tempArray[i] = Double.parseDouble(stringList.get(i));
            } catch (NumberFormatException e) {
                return new Double[0];
            }
        }

        LOGGER.info("{} {}", "SUCCESS BUILD", tempArray);
        return tempArray;
    }

    public Double[] getArray() {
        return array;
    }
}
