package by.serzhant.uml.dal;

import by.serzhant.uml.entity.Car;
import by.serzhant.uml.entity.typecar.Sedan;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataWriter {
    private static final Logger LOGGER = LogManager.getLogger(DataWriter.class);
    private static final String TEMP_DAO_PATH = "./UML/src/main/resources/data/TempCar";
    private static final String DAO_PATH = "./UML/src/main/resources/data/CarList";

    public void writeTempData(Car inputCar) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(inputCar.getType()).append(" ");

        if (inputCar instanceof Sedan) {
            stringBuilder.append(((Sedan) inputCar).getBrand()).append(" ");
        }

        stringBuilder.append(inputCar.getEngine().getBrand()).append(" ");
        stringBuilder.append(inputCar.getEngine().getPower()).append(" ");

        stringBuilder.append(inputCar.getChassis().getCountWheels()).append(" ");
        stringBuilder.append(inputCar.getChassis().getChassis().get("1").getDiameter()).append(" ");
        stringBuilder.append(inputCar.getFuelTank().getCapacity());

        try (FileWriter writer = new FileWriter(TEMP_DAO_PATH)) {
            writer.write(stringBuilder.toString());
            writer.flush();
            LOGGER.info("Успешная запись в файл");
        } catch (IOException ex) {
            LOGGER.error("Ошибка записи в файл");
        }
    }

    public void reWriteData(List<String> listTempCar, List<String> listAllCar, Car tempCar) {
        List<String> newCarList = new ArrayList<>();

        for (int i = 0; i < listAllCar.size(); i++) {

            if (!listAllCar.get(i).equals(listTempCar.get(0))) {
                newCarList.add(listAllCar.get(i));
            }
        }

        newCarList.add(buildString(tempCar));

        Path path = Paths.get(DAO_PATH);

        try {
            Files.write(path, newCarList);
            LOGGER.info("Успешная запись в файл");
        } catch (IOException e) {
            LOGGER.error("Ошибка записи в файл");
        }
    }


    private String buildString(Car inputCar) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(inputCar.getType()).append(" ");

        if (inputCar instanceof Sedan) {
            stringBuilder.append(((Sedan) inputCar).getBrand()).append(" ");
        }

        stringBuilder.append(inputCar.getEngine().getBrand()).append(" ");
        stringBuilder.append(inputCar.getEngine().getPower()).append(" ");

        stringBuilder.append(inputCar.getChassis().getCountWheels()).append(" ");
        stringBuilder.append(inputCar.getChassis().getChassis().get("1").getDiameter()).append(" ");
        stringBuilder.append(inputCar.getFuelTank().getCapacity());

        return stringBuilder.toString();
    }


}
