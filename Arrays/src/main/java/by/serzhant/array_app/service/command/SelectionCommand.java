package by.serzhant.array_app.service.command;

import by.serzhant.array_app.entity.Array;
import by.serzhant.array_app.entity.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class SelectionCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(SelectionCommand.class);
    private Array<?> array;

    public SelectionCommand(Array<?> array) {
        this.array = array;
    }

    @Override
    public Message sort() {
        if (array == null || array.getLength() == 0) {
            LOGGER.error(ERROR_MESSAGE);
            return new Message(ERROR_MESSAGE);
        }

        if (array.getLength() == 1) {
            return new Message(array);
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
        return new Message(new Array<>(sortArray));
    }
}
