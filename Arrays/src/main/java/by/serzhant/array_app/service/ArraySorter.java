package by.serzhant.array_app.service;

import by.serzhant.array_app.entity.Array;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class ArraySorter {
    private static final Logger LOGGER = LogManager.getLogger(ArraySorter.class);
    private static final String ERROR_MESSAGE = "Нет данных";
    private static final String SUCCESS_MESSAGE = "Сортировка завершена";

    public Object bubbleSort(Array<?> inputArray) {

        if (inputArray == null || inputArray.getLength() == 0) {
            LOGGER.error(ERROR_MESSAGE);
            return ERROR_MESSAGE;
        }

        if(isOneElement(inputArray)){
            return inputArray;
        }

        Double[] array = (Double[]) inputArray.getArray();

        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;

            for (int i = 1; i < inputArray.getLength(); i++) {

                if (array[i] < array[i - 1]) {
                    double tempValue = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = tempValue;
                    isSorted = false;
                }
            }
        }

        LOGGER.info(SUCCESS_MESSAGE);
        return Arrays.toString(array);
    }

    public Object shakerSort(Array<?> inputArray){

        if (inputArray == null || inputArray.getLength() == 0) {
            LOGGER.error(ERROR_MESSAGE);
            return ERROR_MESSAGE;
        }

        if(isOneElement(inputArray)){
            return inputArray;
        }

        Double[] array = (Double[]) inputArray.getArray();

        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;

            for (int i = 1; i < inputArray.getLength(); i++) {

                if (array[i] < array[i - 1]) {
                    double tempValue = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = tempValue;
                    isSorted = false;
                }
            }

            for (int i = inputArray.getLength()-2; i > 0; i--) {

                if (array[i] < array[i - 1]) {
                    double tempValue = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = tempValue;
                    isSorted = false;
                }
            }
        }

        LOGGER.info(SUCCESS_MESSAGE);
        return Arrays.toString(array);
    }





    private boolean isOneElement(Array<?> inputArray) {
        return inputArray.getLength() == 1;
    }
}
