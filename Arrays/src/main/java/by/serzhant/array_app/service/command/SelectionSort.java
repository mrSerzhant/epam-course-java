package by.serzhant.array_app.service.command;

import by.serzhant.array_app.entity.Array;
import by.serzhant.array_app.service.exception.SortException;
import by.serzhant.array_app.service.validator.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class SelectionSort implements Command {
    private static final Logger LOGGER = LogManager.getLogger(SelectionSort.class);
    private Validator validator = new Validator();
    private Array<?> array;

    public SelectionSort(Array<?> array) {
        this.array = array;
    }

    @Override
    public Array<?> sort() throws SortException {
        if (!validator.isValidArray(array)) {
            throw new SortException(Command.ERROR_MESSAGE);
        }

        if (array.getLength() == 1) {
            return array;
        }

        Double[] sortArray = Arrays.copyOf((Double[]) array.getArray(), array.getLength());

        for (int i = 0; i < sortArray.length; i++) {
            double minElement = sortArray[i];

            for (int j = i + 1; j < sortArray.length; j++) {

                if (sortArray[j] < minElement) {
                    minElement = sortArray[j];
                    sortArray[j] = sortArray[i];
                    sortArray[i] = minElement;
                }
            }
        }

        LOGGER.info(SUCCESS_MESSAGE);
        return null;
    }
}
