package by.serzhant.uml.dal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TempCarReader {
    private static final Logger LOGGER = LogManager.getLogger(TempCarReader.class);
    private static final String DAO_PATH = "./UML/src/main/resources/data/TempCar";

    public List<String> readDaoFile() {
        Path path = Paths.get(DAO_PATH);

        try {
            LOGGER.info("Чтение из базы данных");
            return Files.readAllLines(path);
        } catch (IOException e) {
            LOGGER.error("Ошибка при чтении из базы данных");
            return new ArrayList<>();
        }
    }
}
