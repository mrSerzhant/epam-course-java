package by.serzhant.array_app.service.command;

import by.serzhant.array_app.entity.Array;
import by.serzhant.array_app.service.exception.ExecuteException;
import by.serzhant.array_app.service.validator.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

/**
 Класс содержит исполняющий метод для сортировки вставкой.
 */

public class InsertionSort implements Command {
    private static final Logger LOGGER = LogManager.getLogger(InsertionSort.class);
    private Validator validator = new Validator();
    private Array<?> array;

    public InsertionSort(Array<?> array) {
        this.array = array;
    }

    @Override
    public Object execute() throws ExecuteException {

        if (!validator.isValidArray(array)) {
            LOGGER.error(ERROR_MESSAGE);
            throw new ExecuteException(Command.ERROR_MESSAGE);
        }

        if (array.getLength() == 1) {
            return array;
        }

        Double[] sortArray = Arrays.copyOf((Double[]) array.getArray(), array.getLength());

        for(int i = 1; i < sortArray.length; i++){

            for(int j = i; j >= 0; j--){

                if(sortArray[i] < sortArray[i - j]){
                    double tempValue = sortArray[i - j];
                    sortArray[i - j] = sortArray[i];
                    sortArray[i] = tempValue;

                }
            }
        }

        LOGGER.info(SUCCESS_SORT_MESSAGE);
        return new Array<>(sortArray);
    }
}
