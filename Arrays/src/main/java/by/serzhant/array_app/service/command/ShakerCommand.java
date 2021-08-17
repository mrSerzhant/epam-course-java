package by.serzhant.array_app.service.command;

import by.serzhant.array_app.entity.Array;
import by.serzhant.array_app.entity.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class ShakerCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(ShakerCommand.class);
    private Array<?> array;

    public ShakerCommand(Array<?> array) {
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

        LOGGER.info(SUCCESS_MESSAGE);
        return new Message(new Array<>(sortArray));
    }
}
