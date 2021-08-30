package by.serzhant.array.service;

import by.serzhant.array.dal.DataReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class MatrixBuilder {
    private static final Logger LOGGER = LogManager.getLogger(MatrixBuilder.class);
    private static final String DAO_PATH_ONE = "./Arrays/src/main/java/by/serzhant/array_app/database/matrix/firstMatrix.txt";
    private static final String DAO_PATH_TWO = "./Arrays/src/main/java/by/serzhant/array_app/database/matrix/secondMatrix.txt";
    private Double[][] matrix;

    /**
     Данный метод собирает обьект из исходных данных
     */

    public void build(String pathWay) {
        DataReader reader = new DataReader();

        List<String> stringList;

        if(pathWay.equals("1")){
           stringList = reader.readDaoFile(DAO_PATH_ONE);
        }else{
            stringList = reader.readDaoFile(DAO_PATH_TWO);
        }

        Double[][] tempMatrix = new Double[stringList.size()][];

        for (int i = 0; i < stringList.size(); i++) {
            String[] arrayStrings = stringList.get(i).split(" ");
            tempMatrix[i] = new Double[arrayStrings.length];

            for (int j = 0; j < arrayStrings.length; j++) {

                try {
                    tempMatrix[i][j] = Double.parseDouble(arrayStrings[j]);
                } catch (NumberFormatException e) {
                    matrix =  new Double[0][0];
                    return;
                }
            }
        }

        matrix = tempMatrix;
        LOGGER.info("{} {}", "SUCCESS BUILD", matrix);
    }

    public Double[][] getMatrix() {
        return matrix;
    }
}
