package by.serzhant.array_app.service.command;

import by.serzhant.array_app.entity.Array;
import by.serzhant.array_app.service.exception.SortException;
import by.serzhant.array_app.service.validator.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

/**
 Класс содержит исполняющий метод для шейкер-сортировки.
 */

public class ShakerSort implements Command {
    private static final Logger LOGGER = LogManager.getLogger(ShakerSort.class);
    private Validator validator = new Validator();
    private Array<?> array;

    public ShakerSort(Array<?> array) {
        this.array = array;
    }

    @Override
    public Array<?> sort() throws SortException {
        if (!validator.isValidArray(array)) {
            LOGGER.error(ERROR_MESSAGE);
            throw new SortException(Command.ERROR_MESSAGE);
        }

        if (array.getLength() == 1) {
            return array;
        }

        Double[] sortArray = Arrays.copyOf((Double[]) array.getArray(), array.getLength());

        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;

            for (int i = 1; i < array.getLength(); i++) {

                if (sortArray[i] < sortArray[i - 1]) {
                    double tempValue = sortArray[i];
                    sortArray[i] = sortArray[i - 1];
                    sortArray[i - 1] = tempValue;
                    isSorted = false;
                }
            }

            for (int i = array.getLength() - 2; i > 0; i--) {

                if (sortArray[i] < sortArray[i - 1]) {
                    double tempValue = sortArray[i];
                    sortArray[i] = sortArray[i - 1];
                    sortArray[i - 1] = tempValue;
                    isSorted = false;
                }
            }
        }

        LOGGER.info(SUCCESS_SORT_MESSAGE);
        return new Array<>(sortArray);
    }
}
