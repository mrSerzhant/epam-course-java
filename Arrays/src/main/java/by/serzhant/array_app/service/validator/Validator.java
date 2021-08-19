package by.serzhant.array_app.service.validator;

import by.serzhant.array_app.entity.Array;
import by.serzhant.array_app.entity.Matrix;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Validator {
    private static final Logger LOGGER = LogManager.getLogger(Validator.class);

    public boolean isValidArray(Array<?> inputArray) {
        if (inputArray == null || inputArray.getLength() == 0) {
            LOGGER.error("Incorrect Input Array");
            return false;
        }

        return true;
    }

    public boolean isValidMatrix(Matrix<?> inputMatrix) {
        if (inputMatrix == null || inputMatrix.getRowLength() == 0) {
            LOGGER.error("Incorrect Input Array");
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
            return false;
        }

        for (int i = 0; i < firstMatrix.getRowLength(); i++) {

            if (firstMatrix.getMatrix()[i].length != secondMatrix.getMatrix()[i].length) {
                return false;
            }
        }

        return true;
    }
}
