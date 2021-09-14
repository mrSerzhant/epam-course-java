package by.serzhant.thread.dal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
    private static final Logger LOGGER = LogManager.getLogger(DataReader.class);
    private static final String MATRIX_DATA = "./Thread/src/main/resources/data/matrix.txt";
    private static final String THREAD_DATA = "./Thread/src/main/resources/data/thread.txt";
    private static final String MATRIX_TEMP_DATA = "./Thread/src/main/resources/data/tempdata.txt";
    private static final String THREAD_TEMP_DATA = "./Thread/src/main/resources/data/tempthreaddata.txt";
    private static final String ERROR_MESSAGE = "Чтение из базы данных";
    private static final String SUCCESS_MESSAGE = "Ошибка при чтении из базы данных";

    public List<String> readMatrixDataFile() {
        Path path = Paths.get(MATRIX_DATA);

        try {
            LOGGER.info(SUCCESS_MESSAGE);
            return Files.readAllLines(path);
        } catch (IOException e) {
            LOGGER.error(ERROR_MESSAGE);
            return new ArrayList<>();
        }
    }

    public List<String> readThreadDataFile() {
        Path path = Paths.get(THREAD_DATA);

        try {
            LOGGER.info(SUCCESS_MESSAGE);
            return Files.readAllLines(path);
        } catch (IOException e) {
            LOGGER.error(ERROR_MESSAGE);
            return new ArrayList<>();
        }
    }

    public List<String> readMatrixTempDataFile() {
        Path path = Paths.get(MATRIX_TEMP_DATA);

        try {
            LOGGER.info(SUCCESS_MESSAGE);
            return Files.readAllLines(path);
        } catch (IOException e) {
            LOGGER.error(ERROR_MESSAGE);
            return new ArrayList<>();
        }
    }

    public List<String> readThreadTempDataFile() {
        Path path = Paths.get(THREAD_TEMP_DATA);

        try {
            LOGGER.info(SUCCESS_MESSAGE);
            return Files.readAllLines(path);
        } catch (IOException e) {
            LOGGER.error(ERROR_MESSAGE);
            return new ArrayList<>();
        }
    }
}
