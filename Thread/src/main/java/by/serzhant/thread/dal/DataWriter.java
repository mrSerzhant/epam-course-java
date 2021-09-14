package by.serzhant.thread.dal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataWriter {
    private static final Logger LOGGER = LogManager.getLogger(DataWriter.class);
    private static final String TEMP_DAO_PATH = "./Thread/src/main/resources/data/tempdata.txt";
    private static final String TEMP_THREAD_DAO_PATH = "./Thread/src/main/resources/data/tempthreaddata.txt";

    public void writeTempData(Integer[][] inputMatrix){
        StringBuilder stringBuilder;
        List<String> listTempData = new ArrayList<>();


        for(Integer[] ar : inputMatrix){
            stringBuilder = new StringBuilder();
            for(int element : ar){
                stringBuilder.append(element).append(" ");
            }
            listTempData.add(stringBuilder.toString());
        }

        Path path = Paths.get(TEMP_DAO_PATH);

        try {
            Files.write(path, listTempData);
            LOGGER.info("Успешная запись в файл");
        }catch (IOException e ){
            LOGGER.info("Ошибка записи в файл");
        }
    }

    public void writeTempThreadData(Integer inputValue){
        List<String> list = new ArrayList<>();
        list.add(String.valueOf(inputValue));

        Path path = Paths.get(TEMP_THREAD_DAO_PATH);

        try {
            Files.write(path, list);
            LOGGER.info("Успешная запись в файл");
        }catch (IOException e ){
            LOGGER.info("Ошибка записи в файл");
        }
    }
}
