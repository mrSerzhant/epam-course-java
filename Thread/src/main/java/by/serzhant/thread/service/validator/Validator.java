package by.serzhant.thread.service.validator;

import by.serzhant.thread.service.parser.Parser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Validator {
    private static final Logger LOGGER = LogManager.getLogger(Validator.class);

    public boolean isValidMatrixData(List<String> inputData) {
        if (!inputData.isEmpty()) {
            Parser parser = new Parser();

            if (isValidSizeMatrix(inputData.get(0))) {
                int sizeMatrix = Integer.parseInt(inputData.get(0));

                Integer[][] matrix = parser.parseMatrixElement(inputData);

                if (isSquareMatrix(matrix) && matrix.length == sizeMatrix && isCorrectDiagonal(matrix)) {
                    LOGGER.info("valid matrix data");
                    return true;
                }
            }
        }

        LOGGER.error("invalid matrix data");
        return false;
    }

    public boolean isValidCountElement(List<String> inputData) {
        if (!inputData.isEmpty()) {

            if (isValidLine(inputData.get(0))) {
                Parser parser = new Parser();

                List<Integer> list = parser.parseDiapason(inputData.get(0));

                if (!list.isEmpty()) {
                    int fistLimit = list.get(0);
                    int secondLimit = list.get(1);
                    LOGGER.info("valid count thread");
                    return isValidDiapason(fistLimit, secondLimit);
                }
            }
        }

        LOGGER.error("invalid count thread");
        return false;
    }

    private boolean isSquareMatrix(Integer[][] inputMatrix) {
        int countRow = inputMatrix.length;

        for (int i = 0; i < inputMatrix.length; i++) {

            if (countRow != inputMatrix[i].length) {
                LOGGER.error("isnot square matrix");
                return false;
            }
        }

        LOGGER.info("square matrix");
        return true;
    }

    private boolean isValidDiapason(int firstLimit, int secondLimit) {
        return 1 < firstLimit && firstLimit <= secondLimit;
    }

    private boolean isValidLine(String inputString) {
        return inputString.length() > 2;
    }

    private boolean isCorrectDiagonal(Integer[][] inputMatrix) {
        for (int i = 0; i < inputMatrix.length; i++) {

            if (inputMatrix[i][i] != 0) {
                LOGGER.error("invalid value diagonal elements ");
                return false;
            }
        }

        LOGGER.info("valid value diagonal elements ");
        return true;
    }

    private boolean isValidSizeMatrix(String inputString) {

        try {
            if (Integer.parseInt(inputString) > 1) {
                LOGGER.info("valid matrix size");
                return true;
            }
        } catch (NumberFormatException e) {
            LOGGER.error("invalid matrix size");
            return false;
        }

        return false;
    }
}
