package by.serzhant.array.dal;

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

    public List<String> readDaoFile(String inputPath) {
        Path path = Paths.get(inputPath);

        try {
            LOGGER.info("Чтение из базы данных");
            return Files.readAllLines(path);
        } catch (IOException e) {
            LOGGER.error("Ошибка при чтении из базы данных");
            return new ArrayList<>();
        }
    }
}
