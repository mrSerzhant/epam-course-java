package by.serzhant.array_app.service.command;

import by.serzhant.array_app.entity.Array;
import by.serzhant.array_app.service.exception.ExecuteException;
import by.serzhant.array_app.service.util.Sort;
import by.serzhant.array_app.service.validator.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SelectionSort implements Command {
    private static final Logger LOGGER = LogManager.getLogger(SelectionSort.class);
    private Validator validator = new Validator();
    private Array<?> array;
    private Sort sort;

    public SelectionSort(Array<?> array, Sort inputSort) {
        this.array = array;
        this.sort = inputSort;
    }

    /**
     * Класс содержит исполняющий метод для сортировки выбороом.
     */

    @Override
    public Object execute() throws ExecuteException {
        if (!validator.isValidArray(array)) {
            LOGGER.error(ERROR_MESSAGE);
            throw new ExecuteException(Command.ERROR_MESSAGE);
        }

        if (array.getLength() == 1) {
            return array;
        }

        LOGGER.info(VALID_PARAM);
        return sort.selectionSort(array);
    }
}
