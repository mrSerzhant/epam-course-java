package by.serzhant.array.service.command;

import by.serzhant.array.entity.Array;
import by.serzhant.array.service.exception.ExecuteException;
import by.serzhant.array.service.util.Sort;
import by.serzhant.array.service.validator.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 Класс содержит исполняющий метод для команды сортировка пузырьком.
 */

public class BubbleSort implements Command {
    private static final Logger LOGGER = LogManager.getLogger(BubbleSort.class);
    private Validator validator = new Validator();
    private Array<?> array;
    private Sort sort;

    public BubbleSort(Array<?> array, Sort inputSort) {
        this.array = array;
        this.sort = inputSort;
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

        LOGGER.info(VALID_PARAM);
        return sort.bubbleSort(array);
    }
}
