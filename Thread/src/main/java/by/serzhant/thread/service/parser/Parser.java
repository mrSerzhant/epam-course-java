package by.serzhant.thread.service.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    private static final Logger LOGGER = LogManager.getLogger(Parser.class);

    public List<Integer> parseDiapason(String inputString) {
        String[] arrayStrings = inputString.split(" ");

        try {
            int firstLimit = Integer.parseInt(arrayStrings[0]);
            int secondLimit = Integer.parseInt(arrayStrings[1]);

            ArrayList<Integer> list = new ArrayList<>();
            list.add(firstLimit);
            list.add(secondLimit);
            LOGGER.info("diapason elements: {} {}", firstLimit, secondLimit);
            return list;

        } catch (NumberFormatException e) {
            LOGGER.error("bad diapason elements data");
            return new ArrayList<>();
        }
    }

    public Integer[][] parseMatrixElement(List<String> inputData) {
        Integer[][] tempMatrix = new Integer[inputData.size() - 1][];

        for (int i = 1; i < inputData.size(); i++) {
            String[] arrayStrings = inputData.get(i).split(" ");
            tempMatrix[i - 1] = new Integer[arrayStrings.length];

            for (int j = 0; j < arrayStrings.length; j++) {

                try {
                    tempMatrix[i - 1][j] = Integer.parseInt(arrayStrings[j]);
                } catch (NumberFormatException e) {
                    LOGGER.error("bad matrix data");
                    return new Integer[0][0];
                }
            }
        }

        LOGGER.info("success parsing");
        return tempMatrix;
    }

    public Integer[][] parseTempMatrixElement(List<String> inputData) {
        Integer[][] tempMatrix = new Integer[inputData.size()][];

        for (int i = 0; i < inputData.size(); i++) {
            String[] arrayStrings = inputData.get(i).split(" ");
            tempMatrix[i] = new Integer[arrayStrings.length];

            for (int j = 0; j < arrayStrings.length; j++) {

                try {
                    tempMatrix[i][j] = Integer.parseInt(arrayStrings[j]);
                } catch (NumberFormatException e) {
                    LOGGER.error("bad matrix data");
                    return new Integer[0][0];
                }
            }
        }

        LOGGER.info("success parsing");
        return tempMatrix;
    }
}
