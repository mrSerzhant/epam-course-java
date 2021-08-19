package by.serzhant.array_app.service.util;

import by.serzhant.array_app.entity.Array;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Sort {
    private static final Logger LOGGER = LogManager.getLogger(Sort.class);
    private static final String SUCCESS_SORT = "SUCCESS_SORT";

    public Array<?> bubbleSort(Array<?> inputArray) {
        Double[] sortArray = Arrays.copyOf((Double[]) inputArray.getArray(), inputArray.getLength());

        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;

            for (int i = 1; i < sortArray.length; i++) {

                if (sortArray[i] < sortArray[i - 1]) {
                    double tempValue = sortArray[i];
                    sortArray[i] = sortArray[i - 1];
                    sortArray[i - 1] = tempValue;
                    isSorted = false;
                }
            }
        }

        LOGGER.info("{} {}", SUCCESS_SORT, sortArray);
        return new Array<>(sortArray);
    }

    public Array<?> insertionSort(Array<?> inputArray) {
        Double[] sortArray = Arrays.copyOf((Double[]) inputArray.getArray(), inputArray.getLength());

        for (int i = 1; i < sortArray.length; i++) {
            for (int j = i; j >= 0; j--) {

                if (sortArray[i] < sortArray[i - j]) {
                    double tempValue = sortArray[i - j];
                    sortArray[i - j] = sortArray[i];
                    sortArray[i] = tempValue;

                }
            }
        }

        LOGGER.info("{} {}", SUCCESS_SORT, sortArray);
        return new Array<>(sortArray);
    }

    public Array<?> mergeSort(Array<?> inputArray) {
        Double[] firstPartSortArray = Arrays.copyOfRange((Double[]) inputArray.getArray(), 0, inputArray.getLength() / 2);
        Double[] secondPartSortArray = Arrays.copyOfRange((Double[]) inputArray.getArray(), inputArray.getLength() / 2, inputArray.getLength());

        return new Array<>(merge(customBubbleSort(firstPartSortArray), customBubbleSort(secondPartSortArray)));
    }

    public Array<?> selectionSort(Array<?> inputArray) {
        Double[] sortArray = Arrays.copyOf((Double[]) inputArray.getArray(), inputArray.getLength());

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

        LOGGER.info("{} {}", SUCCESS_SORT, sortArray);
        return new Array<>(sortArray);
    }

    public Array<?> shakerSort(Array<?> inputArray) {
        Double[] sortArray = Arrays.copyOf((Double[]) inputArray.getArray(), inputArray.getLength());

        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;

            for (int i = 1; i < inputArray.getLength(); i++) {

                if (sortArray[i] < sortArray[i - 1]) {
                    double tempValue = sortArray[i];
                    sortArray[i] = sortArray[i - 1];
                    sortArray[i - 1] = tempValue;
                    isSorted = false;
                }
            }

            for (int i = inputArray.getLength() - 2; i > 0; i--) {

                if (sortArray[i] < sortArray[i - 1]) {
                    double tempValue = sortArray[i];
                    sortArray[i] = sortArray[i - 1];
                    sortArray[i - 1] = tempValue;
                    isSorted = false;
                }
            }
        }

        LOGGER.info("{} {}", SUCCESS_SORT, sortArray);
        return new Array<>(sortArray);
    }

    public Array<?> shellSort(Array<?> inputArray) {
        Double[] sortArray = Arrays.copyOf((Double[]) inputArray.getArray(), inputArray.getLength());

        int step = sortArray.length;

        while (step != 1) {
            step = step / 2;

            for (int i = 0; i + step < sortArray.length; i++) {

                if (sortArray[i + step] < sortArray[i]) {
                    double tempValue = sortArray[i];
                    sortArray[i] = sortArray[i + step];
                    sortArray[i + step] = tempValue;
                }
            }
        }

        for (int i = 1; i < sortArray.length; i++) {
            for (int j = i; j >= 0; j--) {

                if (sortArray[i] < sortArray[i - j]) {
                    double tempValue = sortArray[i - j];
                    sortArray[i - j] = sortArray[i];
                    sortArray[i] = tempValue;

                }
            }
        }

        LOGGER.info("{} {}", SUCCESS_SORT, sortArray);
        return new Array<>(sortArray);
    }

    public Array<?> hashSort(Array<?> inputArray) {
        Map<Integer, ArrayList<Double>> map = new HashMap<>();
        Double[] sortArray = Arrays.copyOf((Double[]) inputArray.getArray(), inputArray.getLength());

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

        //Цикл сортирует значения с одним hash

        for (Map.Entry<Integer, ArrayList<Double>> entry : map.entrySet()) {

            if (entry.getValue().size() > 1) {
                sortList(entry.getValue());
            }
        }

        //Цикл заполняет массив в порядке возрастания hash

        int index = 0;

        for (Map.Entry<Integer, ArrayList<Double>> entry : map.entrySet()) {
            for (Double element : entry.getValue()) {
                sortArray[index] = element;
                index++;
            }
        }

        LOGGER.info("{} {}", SUCCESS_SORT, sortArray);
        return new Array<>(sortArray);
    }


    /**
     * Метод сортирует элементы
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
     * Метод вычисляет Hash элемента
     */

    private int calculateHash(double currentElement, double maxElement, int size) {
        if (currentElement < 0) {
            return 0;
        }

        return (int) ((currentElement / maxElement) * size);
    }

    /**
     * Метод вычисляет максимальный элемент для вычисления hash
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

    /**
     * Метод объединяет два отсортированных массива
     */


    private Double[] merge(Double[] leftPartArray, Double[] rightPartArray) {

        int leftLength = leftPartArray.length;
        int rightLength = rightPartArray.length;

        Double[] resultArray = new Double[leftLength + rightLength];

        int pointerLeftArray = 0;
        int pointerRightArray = 0;
        int pointerResultArray = 0;

        while (pointerLeftArray < leftLength && pointerRightArray < rightLength) {

            if (leftPartArray[pointerLeftArray] < rightPartArray[pointerRightArray]) {
                resultArray[pointerResultArray] = leftPartArray[pointerLeftArray];
                pointerLeftArray++;

            } else {
                resultArray[pointerResultArray] = rightPartArray[pointerRightArray];
                pointerRightArray++;
            }

            pointerResultArray++;
        }

        while (pointerLeftArray < leftLength) {
            resultArray[pointerResultArray] = leftPartArray[pointerLeftArray];
            pointerLeftArray++;
            pointerResultArray++;

        }

        while (pointerRightArray < rightLength) {
            resultArray[pointerResultArray] = rightPartArray[pointerRightArray];
            pointerRightArray++;
            pointerResultArray++;
        }

        LOGGER.info("{} {}", SUCCESS_SORT, resultArray);
        return resultArray;
    }

    private Double[] customBubbleSort(Double[] inputArray) {
        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;

            for (int i = 1; i < inputArray.length; i++) {

                if (inputArray[i] < inputArray[i - 1]) {
                    double tempValue = inputArray[i];
                    inputArray[i] = inputArray[i - 1];
                    inputArray[i - 1] = tempValue;
                    isSorted = false;
                }
            }
        }

        LOGGER.info("{} {}", SUCCESS_SORT, inputArray);
        return inputArray;
    }
}
