package by.serzhant.array_app.service.command;

import by.serzhant.array_app.entity.Array;
import by.serzhant.array_app.service.exception.ExecuteException;
import by.serzhant.array_app.service.validator.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

/**
 Класс содержит исполняющий метод для сортировки бинарного слияния и вспомогательные к нему методы.
 */

public class MergeSort implements Command {
    private static final Logger LOGGER = LogManager.getLogger(MergeSort.class);
    private Validator validator = new Validator();
    private Array<?> array;


    public MergeSort(Array<?> array) {
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

        //Делим исходный массив на 2 части и сортируем их

        Double[] firstPartSortArray = Arrays.copyOfRange((Double[]) array.getArray(), 0, array.getLength() / 2);
        Array<?> ar1 = new Array<>(firstPartSortArray);
        BubbleSort sortFirstPart = new BubbleSort(ar1);
        Array<Double> arrayTemp =  (Array<Double>) sortFirstPart.execute();

        Double[] sortArray = Arrays.copyOf(arrayTemp.getArray(), firstPartSortArray.length);
        LOGGER.info("{} {}", SUCCESS_SORT_MESSAGE, ar1);

        Double[] secondPartSortArray = Arrays.copyOfRange((Double[]) array.getArray(), array.getLength() / 2, array.getLength());
        Array<?> ar2 = new Array<>(secondPartSortArray);
        BubbleSort sortSecondPart = new BubbleSort(ar2);
        arrayTemp = (Array<Double>) sortSecondPart.execute();

        Double[] sortArray2 = Arrays.copyOf(arrayTemp.getArray(), secondPartSortArray.length);
        LOGGER.info("{} {}", SUCCESS_SORT_MESSAGE, ar2);

        return new Array<>(merge(sortArray, sortArray2));
    }

    /**
    Метод объединяет два отсортированных массива
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

        return resultArray;
    }
}
