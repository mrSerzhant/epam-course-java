package by.serzhant.thread.service.validator;

import by.serzhant.thread.service.parser.Parser;

import java.util.List;

public class Validator {
    public boolean isValidMatrixData(List<String> inputData) {
        if (!inputData.isEmpty()) {
            Parser parser = new Parser();

            if (isValidSizeMatrix(inputData.get(0))) {
                int sizeMatrix = Integer.parseInt(inputData.get(0));

                Integer[][] matrix = parser.parseMatrixElement(inputData);

                if (isSquareMatrix(matrix) && matrix.length == sizeMatrix && isCorrectDiagonal(matrix)) {
                    return true;
                }
            }
        }

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

                    return isValidDiapason(fistLimit, secondLimit);
                }
            }
        }

        return false;
    }

    private boolean isSquareMatrix(Integer[][] inputMatrix) {
        int countRow = inputMatrix.length;

        for (int i = 0; i < inputMatrix.length; i++) {

            if (countRow != inputMatrix[i].length) {
                return false;
            }
        }

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
                return false;
            }
        }

        return true;
    }

    private boolean isValidSizeMatrix(String inputString) {

        try {
            if (Integer.parseInt(inputString) > 1) {
                return true;
            }
        } catch (NumberFormatException e) {
            return false;
        }

        return false;
    }
}







