package by.serzhant.branching_app.database.data_processing;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DaoWriter {
    private final static Logger LOGGER = LogManager.getLogger(DaoWriter.class);
    private List<String> listValues = new ArrayList<>();


    public List<String> writeDaoFile(String inputPath, double... params) {
        Path path = Paths.get(inputPath);

        try {
            for (double param : params) {
                listValues.add(String.valueOf(param));
            }

            Files.write(path, listValues);
            LOGGER.info("Запись в базу данных {}", listValues);
            return listValues;
        } catch (IOException e) {
            LOGGER.error("Ошибка при записи в базу данных");
            return new ArrayList<>();
        }
    }
}
