package by.serzhant.thread.service.parser;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    public List<Integer> parseDiapason(String inputString) {

        String[] arrayStrings = inputString.split(" ");

        try {
            int firstLimit = Integer.parseInt(arrayStrings[0]);
            int secondLimit = Integer.parseInt(arrayStrings[1]);

            ArrayList<Integer> list = new ArrayList<>();
            list.add(firstLimit);
            list.add(secondLimit);
            return list;

        } catch (NumberFormatException e) {
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

                    return new Integer[0][0];
                }
            }
        }

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

                    return new Integer[0][0];
                }
            }
        }

        return tempMatrix;
    }
}
