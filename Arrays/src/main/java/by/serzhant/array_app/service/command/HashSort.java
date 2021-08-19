package by.serzhant.array_app.service.command;

import by.serzhant.array_app.entity.Array;
import by.serzhant.array_app.service.exception.ExecuteException;
import by.serzhant.array_app.service.validator.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

/**
 Класс содержит исполняющий метод для сортировки с вычислений hash адреса и вспомогательные к нему методы.
 */

public class HashSort implements Command {
    private static final Logger LOGGER = LogManager.getLogger(HashSort.class);
    private Validator validator = new Validator();
    private Array<?> array;

    public HashSort(Array<?> array) {
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

        Map<Integer, ArrayList<Double>> map = new HashMap<>();
        Double[] sortArray = Arrays.copyOf((Double[]) array.getArray(), array.getLength());

        // Цикл формирует карту, ключ - hash элемента, значение - список из элементов имеющий этот hash

        double maxElement = calculateMaxElement(sortArray);

        for (Double element : sortArray) {
            int hash = calculateHash(element, maxElement, sortArray.length);

            if (element < 0) {
                hash = 0;
            }

            if (map.containsKey(hash)) {
                map.get(hash).add(element);
            } else {
                map.put(hash, new ArrayList<>());
                map.get(hash).add(element);
            }
        }

        LOGGER.info("{} {}", SUCCESS_EXECUTION_MESSAGE, map);

        //Цикл сортирует значения с одним hash

        for (Map.Entry<Integer, ArrayList<Double>> entry : map.entrySet()) {

            if (entry.getValue().size() > 1) {
                sortList(entry.getValue());
            }
        }

        LOGGER.info("{} {}", SUCCESS_EXECUTION_MESSAGE, map);

        //Цикл заполняет массив в порядке возрастания hash

        int index = 0;

        for (Map.Entry<Integer, ArrayList<Double>> entry : map.entrySet()) {
            for(Double element : entry.getValue()){
                sortArray[index] = element;
                index++;
            }
        }

        LOGGER.info("{} {}", SUCCESS_SORT_MESSAGE, sortArray);
        return new Array<>(sortArray);
    }

    /**
     Метод сортирует элементы
     */

    private void sortList(ArrayList<Double> inputList) {
        for (int i = 1; i < inputList.size(); i++) {
            for (int j = i; j >= 0; j--) {

                if (inputList.get(i) < inputList.get(i - j)) {
                    double tempValue = inputList.get(i - j);
                    inputList.set(i - j, inputList.get(i));
                    inputList.set(i, tempValue);
                }
            }
        }
    }

    /**
     Метод вычисляет Hash элемента
     */

    private int calculateHash(double currentElement, double maxElement, int size) {
        if (currentElement < 0) {
            return 0;
        }

        return (int) ((currentElement / maxElement) * size);
    }

    /**
     Метод вычисляет максимальный элемент для вычисления hash
     */

    private double calculateMaxElement(Double[] inputArray) {
        double maxElement = inputArray[0];

        for (double element : inputArray) {
            if (element > maxElement) {
                maxElement = element;
            }
        }

        return maxElement;
    }
}
