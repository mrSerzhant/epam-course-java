package by.serzhant.array_app.service.command;

import by.serzhant.array_app.entity.Array;
import by.serzhant.array_app.service.exception.SortException;
import by.serzhant.array_app.service.validator.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

/**
 Класс содержит исполняющий метод для сортировки методом Шелла.
 */

public class ShellSort implements Command {
    private static final Logger LOGGER = LogManager.getLogger(ShellSort.class);
    private Validator validator = new Validator();
    private Array<?> array;

    public ShellSort(Array<?> array) {
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

        int step = sortArray.length;

        while(step != 1){
            step =  step / 2;

            for(int i = 0; i + step < sortArray.length; i++) {

                if (sortArray[i + step] < sortArray[i]) {
                    double tempValue = sortArray[i];
                    sortArray[i] = sortArray[i + step];
                    sortArray[i + step] = tempValue;
                }
            }
        }

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
