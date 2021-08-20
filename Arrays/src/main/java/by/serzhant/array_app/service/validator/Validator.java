package by.serzhant.array_app.service.validator;

import by.serzhant.array_app.entity.Array;
import by.serzhant.array_app.entity.Matrix;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Validator {
    private static final Logger LOGGER = LogManager.getLogger(Validator.class);
    private static final String ERROR_MESSAGE = "Incorrect Input Vaue";

    public boolean isValidArray(Array<?> inputArray) {
        if (inputArray == null || inputArray.getLength() == 0) {
            LOGGER.error("{} {}", ERROR_MESSAGE, "Wrong Size");
            return false;
        }

        return true;
    }

    /**
     * метод  проверяет размер и нерегулярность
     */

    public boolean isValidMatrix(Matrix<?> inputMatrix) {
        if (inputMatrix == null || inputMatrix.getRowLength() == 0) {
            LOGGER.error("Wrong Size Matrix");
            return false;
        }

        int lengthFirstRow = inputMatrix.getMatrix()[0].length;

        for (int i = 1; i < inputMatrix.getRowLength(); i++) {

            if (lengthFirstRow != inputMatrix.getMatrix()[i].length) {
                return false;
            }
        }

        return true;
    }

    public boolean isEqualMatrix(Matrix<?> firstMatrix, Matrix<?> secondMatrix) {
        if (firstMatrix.getRowLength() != secondMatrix.getRowLength()) {
            LOGGER.error("{} {}", ERROR_MESSAGE, "isnot equals");
            return false;
        }

        for (int i = 0; i < firstMatrix.getRowLength(); i++) {

            if (firstMatrix.getMatrix()[i].length != secondMatrix.getMatrix()[i].length) {
                LOGGER.error("{} {}", ERROR_MESSAGE, "isnot equals");
                return false;
            }
        }

        return true;
    }

    public boolean isValidForMultiplication(Matrix<?> firstMatrix, Matrix<?> secondMatrix) {
        if (firstMatrix.getMatrix()[0].length != secondMatrix.getMatrix().length) {
            LOGGER.error("{} {}", ERROR_MESSAGE, "isnot equals size");
            return false;
        }

        return true;
    }
}
